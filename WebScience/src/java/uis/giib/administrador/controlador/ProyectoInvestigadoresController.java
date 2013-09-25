package uis.giib.administrador.controlador;

import uis.giib.entidades.ProyectoInvestigadores;
import uis.giib.administrador.controlador.util.JsfUtil;
import uis.giib.administrador.controlador.util.PaginationHelper;
import uis.giib.administrador.dao.ProyectoInvestigadoresFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("proyectoInvestigadoresController")
@SessionScoped
public class ProyectoInvestigadoresController implements Serializable {

    private ProyectoInvestigadores current;
    private DataModel items = null;
    @EJB
    private uis.giib.administrador.dao.ProyectoInvestigadoresFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ProyectoInvestigadoresController() {
    }

    public ProyectoInvestigadores getSelected() {
        if (current == null) {
            current = new ProyectoInvestigadores();
            current.setProyectoInvestigadoresPK(new uis.giib.entidades.ProyectoInvestigadoresPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private ProyectoInvestigadoresFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {
                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (ProyectoInvestigadores) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new ProyectoInvestigadores();
        current.setProyectoInvestigadoresPK(new uis.giib.entidades.ProyectoInvestigadoresPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getProyectoInvestigadoresPK().setIdInvestigador(current.getInvestigador().getUsuarioInvestigador());
            current.getProyectoInvestigadoresPK().setIdProyectoInvestigacion(current.getProyecto().getIdProyecto());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProyectoInvestigadoresCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (ProyectoInvestigadores) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getProyectoInvestigadoresPK().setIdInvestigador(current.getInvestigador().getUsuarioInvestigador());
            current.getProyectoInvestigadoresPK().setIdProyectoInvestigacion(current.getProyecto().getIdProyecto());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProyectoInvestigadoresUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (ProyectoInvestigadores) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProyectoInvestigadoresDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public ProyectoInvestigadores getProyectoInvestigadores(uis.giib.entidades.ProyectoInvestigadoresPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = ProyectoInvestigadores.class)
    public static class ProyectoInvestigadoresControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProyectoInvestigadoresController controller = (ProyectoInvestigadoresController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "proyectoInvestigadoresController");
            return controller.getProyectoInvestigadores(getKey(value));
        }

        uis.giib.entidades.ProyectoInvestigadoresPK getKey(String value) {
            uis.giib.entidades.ProyectoInvestigadoresPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new uis.giib.entidades.ProyectoInvestigadoresPK();
            key.setIdProyectoInvestigacion(Integer.parseInt(values[0]));
            key.setIdInvestigador(values[1]);
            return key;
        }

        String getStringKey(uis.giib.entidades.ProyectoInvestigadoresPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdProyectoInvestigacion());
            sb.append(SEPARATOR);
            sb.append(value.getIdInvestigador());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ProyectoInvestigadores) {
                ProyectoInvestigadores o = (ProyectoInvestigadores) object;
                return getStringKey(o.getProyectoInvestigadoresPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ProyectoInvestigadores.class.getName());
            }
        }
    }
}
