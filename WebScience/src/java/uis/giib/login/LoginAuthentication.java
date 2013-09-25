package uis.giib.login;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import uis.giib.administrador.dao.InvestigadorFacade;
import uis.giib.entidades.Investigador;

/**
 * COntorlador para verificar que los datos usados en la autenticación sean los
 * correctos
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "loginAuthentication")
@SessionScoped
public class LoginAuthentication implements Serializable {

    @EJB
    private uis.giib.administrador.dao.InvestigadorFacade investigadorDAO;
    private Investigador usuario;
    private Investigador usuarioAutenticado;
    private boolean loggedIn = false;
    private boolean[] arrayRender = new boolean[8];

    /**
     * Constructor LoginAuthentication
     */
    public LoginAuthentication() {
        usuario = new Investigador();
        usuarioAutenticado = null;
    }

    private InvestigadorFacade getInvestigadorDAO() {
        return investigadorDAO;
    }

    /**
     * Método que realiza la consulta y verifica que los datos de ID de usuario
     * y Contraseña coincidan.
     *
     * @return Investigador
     */
    public String login() {
        
        ValidarUsuario();
        if (usuarioAutenticado != null) {
            loggedIn = true;
            return "inicio.xhtml?faces-redirect=true";
        } else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Usted no cuenta con permisos Suficientes!", "Verifique su usuario y contraseña");
            facesContext.addMessage(null, facesMessage);
            return null;
        }
    }

    public String logout() {
        usuario = new Investigador();
        usuarioAutenticado = null;
        loggedIn = false;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "indexAdministracion.xhtml?faces-redirect=true";
    }

    /**
     * Método para verificar los permizos de admisnitración del usuario
     * autenticado
     *
     * @return boolean true o false
     */
    public void ValidarUsuario() {
        usuarioAutenticado = getInvestigadorDAO().loginAdministrador(getUsuario().getUsuarioInvestigador(), getUsuario().getContrasenaInvestigador());
        if (usuarioAutenticado.getIdNivelPermiso().getIdPermiso() == 1) {
            this.arrayRender[0] = true;
            this.arrayRender[1] = true;
            this.arrayRender[2] = true;
            this.arrayRender[3] = true;
            this.arrayRender[4] = true;
            this.arrayRender[5] = true;
            this.arrayRender[6] = true;
            this.arrayRender[7] = true;
            
        } 
        else {
            if (usuarioAutenticado.getIdNivelPermiso().getIdPermiso() == 2) {
                this.arrayRender[0] = true;
                this.arrayRender[1] = true;
                this.arrayRender[2] = true;
                this.arrayRender[3] = false;
                this.arrayRender[4] = false;
                this.arrayRender[5] = false;
                this.arrayRender[6] = false;
                this.arrayRender[7] = false;
                
            }
            else{
                this.usuarioAutenticado = null;
                this.arrayRender[0] = false;
                this.arrayRender[1] = false;
                this.arrayRender[2] = false;
                this.arrayRender[3] = false;
                this.arrayRender[4] = false;
                this.arrayRender[5] = false;
                this.arrayRender[6] = false;
                this.arrayRender[7] = false;
                            
            }
        }
    }

    // getters - Setters
    
    /**
     * @return the usuario
     */
    public Investigador getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Investigador usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuarioAutenticado
     */
    public Investigador getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    /**
     * @param usuarioAutenticado the usuarioAutenticado to set
     */
    public void setUsuarioAutenticado(Investigador usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    /**
     * @return the loggedIn
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * @param loggedIn the loggedIn to set
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean[] getArrayRender() {
        return arrayRender;
    }

    public void setArrayRender(boolean[] arrayRender) {
        this.arrayRender = arrayRender;
    }
}
