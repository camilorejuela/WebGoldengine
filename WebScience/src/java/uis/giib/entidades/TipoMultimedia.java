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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Entity
@Table(name = "tipo_multimedia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMultimedia.findAll", query = "SELECT t FROM TipoMultimedia t"),
    @NamedQuery(name = "TipoMultimedia.findByIdTipoMultimedia", query = "SELECT t FROM TipoMultimedia t WHERE t.idTipoMultimedia = :idTipoMultimedia"),
    @NamedQuery(name = "TipoMultimedia.findByNombreTipoMultimedia", query = "SELECT t FROM TipoMultimedia t WHERE t.nombreTipoMultimedia = :nombreTipoMultimedia")})
public class TipoMultimedia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_multimedia")
    private Integer idTipoMultimedia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_tipo_multimedia")
    private String nombreTipoMultimedia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoMultimedia")
    private List<Multimedia> multimediaCollection;

    public TipoMultimedia() {
    }

    public TipoMultimedia(Integer idTipoMultimedia) {
        this.idTipoMultimedia = idTipoMultimedia;
    }

    public TipoMultimedia(Integer idTipoMultimedia, String nombreTipoMultimedia) {
        this.idTipoMultimedia = idTipoMultimedia;
        this.nombreTipoMultimedia = nombreTipoMultimedia;
    }

    public Integer getIdTipoMultimedia() {
        return idTipoMultimedia;
    }

    public void setIdTipoMultimedia(Integer idTipoMultimedia) {
        this.idTipoMultimedia = idTipoMultimedia;
    }

    public String getNombreTipoMultimedia() {
        return nombreTipoMultimedia;
    }

    public void setNombreTipoMultimedia(String nombreTipoMultimedia) {
        this.nombreTipoMultimedia = nombreTipoMultimedia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMultimedia != null ? idTipoMultimedia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMultimedia)) {
            return false;
        }
        TipoMultimedia other = (TipoMultimedia) object;
        if ((this.idTipoMultimedia == null && other.idTipoMultimedia != null) || (this.idTipoMultimedia != null && !this.idTipoMultimedia.equals(other.idTipoMultimedia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + idTipoMultimedia + "] - " + nombreTipoMultimedia;
    }

    public List<Multimedia> getMultimediaCollection() {
        return multimediaCollection;
    }

    public void setMultimediaCollection(List<Multimedia> multimediaCollection) {
        this.multimediaCollection = multimediaCollection;
    }
}
