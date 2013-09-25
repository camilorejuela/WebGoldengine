package uis.giib.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Entity
@Table(name = "multimedia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Multimedia.findAll", query = "SELECT m FROM Multimedia m"),
    @NamedQuery(name = "Multimedia.findByIdMultimedia", query = "SELECT m FROM Multimedia m WHERE m.idMultimedia = :idMultimedia"),
    @NamedQuery(name = "Multimedia.findByNombreMultimedia", query = "SELECT m FROM Multimedia m WHERE m.nombreMultimedia = :nombreMultimedia")})
public class Multimedia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_multimedia")
    private Integer idMultimedia;
    @Size(max = 800)
    @Column(name = "url_multimedia")
    private String urlMultimedia;
    @Size(max = 50)
    @Column(name = "nombre_multimedia")
    private String nombreMultimedia;
    @OneToMany(mappedBy = "idMultimedia")
    private List<Recursos> recursosCollection;
    @JoinColumn(name = "id_tipo_multimedia", referencedColumnName = "id_tipo_multimedia")
    @ManyToOne(optional = false)
    private TipoMultimedia idTipoMultimedia;
    @OneToMany(mappedBy = "idMultimedia")
    private List<Contenido> contenidoCollection;

    public Multimedia() {
    }

    public Multimedia(Integer idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public Multimedia(Integer idMultimedia, String nombreMultimedia, String urlTipoMultimedia, char estadoMultimedia) {
        this.idMultimedia = idMultimedia;
        this.nombreMultimedia = nombreMultimedia;
    }

    public Integer getIdMultimedia() {
        return idMultimedia;
    }

    public void setIdMultimedia(Integer idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public String getNombreMultimedia() {
        return nombreMultimedia;
    }

    public void setNombreMultimedia(String nombreMultimedia) {
        this.nombreMultimedia = nombreMultimedia;
    }    
    
    public TipoMultimedia getIdTipoMultimedia() {
        return idTipoMultimedia;
    }

    public void setIdTipoMultimedia(TipoMultimedia idTipoMultimedia) {
        this.idTipoMultimedia = idTipoMultimedia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMultimedia != null ? idMultimedia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Multimedia)) {
            return false;
        }
        Multimedia other = (Multimedia) object;
        if ((this.idMultimedia == null && other.idMultimedia != null) || (this.idMultimedia != null && !this.idMultimedia.equals(other.idMultimedia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + idMultimedia + "] - " + nombreMultimedia;
    }
    
    public String getUrlMultimedia() {
        return urlMultimedia;
    }

    public void setUrlMultimedia(String urlMultimedia) {
        this.urlMultimedia = urlMultimedia;
    }

    public List<Recursos> getRecursosCollection() {
        return recursosCollection;
    }

    public void setRecursosCollection(List<Recursos> recursosCollection) {
        this.recursosCollection = recursosCollection;
    }

    public List<Contenido> getContenidoCollection() {
        return contenidoCollection;
    }

    public void setContenidoCollection(List<Contenido> contenidoCollection) {
        this.contenidoCollection = contenidoCollection;
    }
}
