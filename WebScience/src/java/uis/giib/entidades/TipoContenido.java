package uis.giib.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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

/**
 *
 * @author Carlos David Prada Remolina
 */
@Entity
@Table(name = "tipo_contenido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoContenido.findAll", query = "SELECT t FROM TipoContenido t"),
    @NamedQuery(name = "TipoContenido.findByIdTipoPublicacion", query = "SELECT t FROM TipoContenido t WHERE t.idTipoPublicacion = :idTipoPublicacion"),
    @NamedQuery(name = "TipoContenido.findByNombreTipoContenido", query = "SELECT t FROM TipoContenido t WHERE t.nombreTipoContenido = :nombreTipoContenido")})
public class TipoContenido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_publicacion")
    private Integer idTipoPublicacion;
    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "nombre_tipo_contenido")
    private String nombreTipoContenido;
    @OneToMany(mappedBy = "idTipoPublicacion")
    private List<Contenido> contenidoList;

    public TipoContenido() {
    }

    public TipoContenido(Integer idTipoPublicacion) {
        this.idTipoPublicacion = idTipoPublicacion;
    }

    public TipoContenido(Integer idTipoPublicacion, String nombreTipoContenido) {
        this.idTipoPublicacion = idTipoPublicacion;
        this.nombreTipoContenido = nombreTipoContenido;
    }

    public Integer getIdTipoPublicacion() {
        return idTipoPublicacion;
    }

    public void setIdTipoPublicacion(Integer idTipoPublicacion) {
        this.idTipoPublicacion = idTipoPublicacion;
    }

    public String getNombreTipoContenido() {
        return nombreTipoContenido;
    }

    public void setNombreTipoContenido(String nombreTipoContenido) {
        this.nombreTipoContenido = nombreTipoContenido;
    }

    public List<Contenido> getContenidoList() {
        return contenidoList;
    }

    public void setContenidoList(List<Contenido> contenidoList) {
        this.contenidoList = contenidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPublicacion != null ? idTipoPublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoContenido)) {
            return false;
        }
        TipoContenido other = (TipoContenido) object;
        if ((this.idTipoPublicacion == null && other.idTipoPublicacion != null) || (this.idTipoPublicacion != null && !this.idTipoPublicacion.equals(other.idTipoPublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + idTipoPublicacion + "] - " + nombreTipoContenido;
    }
}
