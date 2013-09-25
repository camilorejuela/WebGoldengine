package uis.giib.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByIdProyecto", query = "SELECT p FROM Proyecto p WHERE p.idProyecto = :idProyecto"),
    @NamedQuery(name = "Proyecto.findByNombreProyecto", query = "SELECT p FROM Proyecto p WHERE p.nombreProyecto = :nombreProyecto"),
    @NamedQuery(name = "Proyecto.findByDescripcionResumidaProyecto", query = "SELECT p FROM Proyecto p WHERE p.descripcionResumidaProyecto = :descripcionResumidaProyecto"),
    @NamedQuery(name = "TipoProyecto.findByIdTipoProyecto", query = "SELECT t FROM TipoProyecto t WHERE t.idTipoProyecto = :idTipoProyecto")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proyecto")
    private Integer idProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(max = 200)
    @Column(name = "nombre_proyecto")
    private String nombreProyecto;
    @Basic(optional = false)
    @Size(max = 90)
    @Column(name = "descripcion_resumida_proyecto")
    private String descripcionResumidaProyecto;
    @Basic(optional = false)
    @Lob
    @Size( max = 65535)
    @Column(name = "descripcion_detallada_proyecto")
    private String descripcionDetalladaProyecto;
    @Size(max = 200)
    @Column(name = "imagen_proyecto")
    private String imagenProyecto;
    @Basic(optional = false)
    @Lob
    @Size(max = 65535)
    @Column(name = "objetivos_proyecto")
    private String objetivosProyecto;
    @Basic(optional = false)
    @Lob
    @Size(max = 65535)
    @Column(name = "resultados_proyecto")
    private String resultadosProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<ProyectoInvestigadores> proyectoInvestigadoresList;
    @JoinColumn(name = "id_tipo_proyecto", referencedColumnName = "id_tipo_proyecto")
    @ManyToOne(optional = false)
    private TipoProyecto idTipoProyecto;
    @JoinColumn(name = "id_estado_proyecto", referencedColumnName = "id_estado_proyecto")
    @ManyToOne(optional = false)
    private EstadoProyecto idEstadoProyecto;
    @JoinColumn(name = "id_linea", referencedColumnName = "id_linea_investigacion")
    @ManyToOne(optional = false)
    private LineaInvestigacion idLinea;
    @JoinColumn(name = "id_estado_general", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private EstadoGeneral idEstadoGeneral;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private List<ProductoProyecto> productoProyectoList;

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Proyecto(Integer idProyecto, String nombreProyecto, String descripcionResumidaProyecto, String descripcionDetalladaProyecto, String objetivosProyecto, String resultadosProyecto) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcionResumidaProyecto = descripcionResumidaProyecto;
        this.descripcionDetalladaProyecto = descripcionDetalladaProyecto;
        this.objetivosProyecto = objetivosProyecto;
        this.resultadosProyecto = resultadosProyecto;
    }

    @XmlTransient
    public List<ProyectoInvestigadores> getProyectoInvestigadoresList() {
        return proyectoInvestigadoresList;
    }

    public void setProyectoInvestigadoresList(List<ProyectoInvestigadores> proyectoInvestigadoresList) {
        this.proyectoInvestigadoresList = proyectoInvestigadoresList;
    }

    public String getImagenProyecto() {
        return imagenProyecto;
    }

    public void setImagenProyecto(String imagenProyecto) {
        this.imagenProyecto = imagenProyecto;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionResumidaProyecto() {
        return descripcionResumidaProyecto;
    }

    public void setDescripcionResumidaProyecto(String descripcionResumidaProyecto) {
        this.descripcionResumidaProyecto = descripcionResumidaProyecto;
    }

    public String getDescripcionDetalladaProyecto() {
        return descripcionDetalladaProyecto;
    }

    public void setDescripcionDetalladaProyecto(String descripcionDetalladaProyecto) {
        this.descripcionDetalladaProyecto = descripcionDetalladaProyecto;
    }

    public String getObjetivosProyecto() {
        return objetivosProyecto;
    }

    public void setObjetivosProyecto(String objetivosProyecto) {
        this.objetivosProyecto = objetivosProyecto;
    }

    public String getResultadosProyecto() {
        return resultadosProyecto;
    }

    public void setResultadosProyecto(String resultadosProyecto) {
        this.resultadosProyecto = resultadosProyecto;
    }

    public TipoProyecto getIdTipoProyecto() {
        return idTipoProyecto;
    }

    public void setIdTipoProyecto(TipoProyecto idTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
    }

    public EstadoProyecto getIdEstadoProyecto() {
        return idEstadoProyecto;
    }

    public void setIdEstadoProyecto(EstadoProyecto idEstadoProyecto) {
        this.idEstadoProyecto = idEstadoProyecto;
    }

    public LineaInvestigacion getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(LineaInvestigacion idLinea) {
        this.idLinea = idLinea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + idProyecto + "] - " + nombreProyecto;
    }

    public EstadoGeneral getIdEstadoGeneral() {
        return idEstadoGeneral;
    }

    public void setIdEstadoGeneral(EstadoGeneral idEstadoGeneral) {
        this.idEstadoGeneral = idEstadoGeneral;
    }

    @XmlTransient
    public List<ProductoProyecto> getProductoProyectoList() {
        return productoProyectoList;
    }

    public void setProductoProyectoList(List<ProductoProyecto> productoProyectoList) {
        this.productoProyectoList = productoProyectoList;
    }
}
