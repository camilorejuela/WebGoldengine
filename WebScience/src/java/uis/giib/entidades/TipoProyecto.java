package uis.giib.entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Entity
@Table(name = "tipo_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProyecto.findAll", query = "SELECT t FROM TipoProyecto t"),
    @NamedQuery(name = "TipoProyecto.findByIdTipoProyecto", query = "SELECT t FROM TipoProyecto t WHERE t.idTipoProyecto = :idTipoProyecto"),
    @NamedQuery(name = "TipoProyecto.findByNombreTipoProyecto", query = "SELECT t FROM TipoProyecto t WHERE t.nombreTipoProyecto = :nombreTipoProyecto"),
    @NamedQuery(name = "TipoProyecto.findByDescripcionTipoProyecto", query = "SELECT t FROM TipoProyecto t WHERE t.descripcionTipoProyecto = :descripcionTipoProyecto")})
public class TipoProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_proyecto")
    private Integer idTipoProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "nombre_tipo_proyecto")
    private String nombreTipoProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(max = 150)
    @Column(name = "descripcion_tipo_proyecto")
    private String descripcionTipoProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoProyecto")
    private List<Proyecto> proyectoList;

    public TipoProyecto() {
    }

    public TipoProyecto(Integer idTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
    }

    public TipoProyecto(Integer idTipoProyecto, String nombreTipoProyecto, String descripcionTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
        this.nombreTipoProyecto = nombreTipoProyecto;
        this.descripcionTipoProyecto = descripcionTipoProyecto;
    }

    public Integer getIdTipoProyecto() {
        return idTipoProyecto;
    }

    public void setIdTipoProyecto(Integer idTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
    }

    public String getNombreTipoProyecto() {
        return nombreTipoProyecto;
    }

    public void setNombreTipoProyecto(String nombreTipoProyecto) {
        this.nombreTipoProyecto = nombreTipoProyecto;
    }

    public String getDescripcionTipoProyecto() {
        return descripcionTipoProyecto;
    }

    public void setDescripcionTipoProyecto(String descripcionTipoProyecto) {
        this.descripcionTipoProyecto = descripcionTipoProyecto;
    }

    @XmlTransient
    public Collection<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProyecto != null ? idTipoProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProyecto)) {
            return false;
        }
        TipoProyecto other = (TipoProyecto) object;
        if ((this.idTipoProyecto == null && other.idTipoProyecto != null) || (this.idTipoProyecto != null && !this.idTipoProyecto.equals(other.idTipoProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + idTipoProyecto + "] - " + nombreTipoProyecto;
    }
}
