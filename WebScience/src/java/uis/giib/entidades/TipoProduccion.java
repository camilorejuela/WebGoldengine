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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Entity
@Table(name = "tipo_produccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProduccion.findAll", query = "SELECT t FROM TipoProduccion t"),
    @NamedQuery(name = "TipoProduccion.findByIdTipoProduccion", query = "SELECT t FROM TipoProduccion t WHERE t.idTipoProduccion = :idTipoProduccion"),
    @NamedQuery(name = "TipoProduccion.findByNombreTipoProduccion", query = "SELECT t FROM TipoProduccion t WHERE t.nombreTipoProduccion = :nombreTipoProduccion")})
public class TipoProduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_produccion")
    private Integer idTipoProduccion;
    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "nombre_tipo_produccion")
    private String nombreTipoProduccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoProduccion")
    private List<ProduccionIntelectual> produccionIntelectualList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoBibliografia")
    private List<Bibliografia> bibliografiaList;

    public TipoProduccion() {
    }

    public TipoProduccion(Integer idTipoProduccion) {
        this.idTipoProduccion = idTipoProduccion;
    }

    public TipoProduccion(Integer idTipoProduccion, String nombreTipoProduccion) {
        this.idTipoProduccion = idTipoProduccion;
        this.nombreTipoProduccion = nombreTipoProduccion;
    }

    public Integer getIdTipoProduccion() {
        return idTipoProduccion;
    }

    public void setIdTipoProduccion(Integer idTipoProduccion) {
        this.idTipoProduccion = idTipoProduccion;
    }

    public String getNombreTipoProduccion() {
        return nombreTipoProduccion;
    }

    public void setNombreTipoProduccion(String nombreTipoProduccion) {
        this.nombreTipoProduccion = nombreTipoProduccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProduccion != null ? idTipoProduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProduccion)) {
            return false;
        }
        TipoProduccion other = (TipoProduccion) object;
        if ((this.idTipoProduccion == null && other.idTipoProduccion != null) || (this.idTipoProduccion != null && !this.idTipoProduccion.equals(other.idTipoProduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + idTipoProduccion + "] - " + nombreTipoProduccion;
    }

    public List<ProduccionIntelectual> getProduccionIntelectualList() {
        return produccionIntelectualList;
    }

    public void setProduccionIntelectualList(List<ProduccionIntelectual> produccionIntelectualList) {
        this.produccionIntelectualList = produccionIntelectualList;
    }

    @XmlTransient
    public List<Bibliografia> getBibliografiaList() {
        return bibliografiaList;
    }

    public void setBibliografiaList(List<Bibliografia> bibliografiaList) {
        this.bibliografiaList = bibliografiaList;
    }
}
