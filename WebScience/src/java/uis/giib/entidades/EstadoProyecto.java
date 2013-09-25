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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos David Prada remolina
 */
@Entity
@Table(name = "estado_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoProyecto.findAll", query = "SELECT e FROM EstadoProyecto e"),
    @NamedQuery(name = "EstadoProyecto.findByIdEstadoProyecto", query = "SELECT e FROM EstadoProyecto e WHERE e.idEstadoProyecto = :idEstadoProyecto"),
    @NamedQuery(name = "EstadoProyecto.findByNombreEstadoProyecto", query = "SELECT e FROM EstadoProyecto e WHERE e.nombreEstadoProyecto = :nombreEstadoProyecto")})
public class EstadoProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_proyecto")
    private Integer idEstadoProyecto;
    @Size(max = 50)
    @Basic(optional = false)
    @Column(name = "nombre_estado_proyecto")
    private String nombreEstadoProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoProyecto")
    private List<Proyecto> proyectoList;

    public EstadoProyecto() {
    }

    public EstadoProyecto(Integer idEstadoProyecto) {
        this.idEstadoProyecto = idEstadoProyecto;
    }

    public Integer getIdEstadoProyecto() {
        return idEstadoProyecto;
    }

    public void setIdEstadoProyecto(Integer idEstadoProyecto) {
        this.idEstadoProyecto = idEstadoProyecto;
    }

    public String getNombreEstadoProyecto() {
        return nombreEstadoProyecto;
    }

    public void setNombreEstadoProyecto(String nombreEstadoProyecto) {
        this.nombreEstadoProyecto = nombreEstadoProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoProyecto != null ? idEstadoProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoProyecto)) {
            return false;
        }
        EstadoProyecto other = (EstadoProyecto) object;
        if ((this.idEstadoProyecto == null && other.idEstadoProyecto != null) || (this.idEstadoProyecto != null && !this.idEstadoProyecto.equals(other.idEstadoProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + idEstadoProyecto + "] - " + nombreEstadoProyecto;
    }

    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }
}
