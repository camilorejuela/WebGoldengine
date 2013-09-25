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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Entity
@Table(name = "produccion_intelectual")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProduccionIntelectual.findAll", query = "SELECT p FROM ProduccionIntelectual p"),
    @NamedQuery(name = "ProduccionIntelectual.findByIdProduccion", query = "SELECT p FROM ProduccionIntelectual p WHERE p.idProduccion = :idProduccion"),
    @NamedQuery(name = "ProduccionIntelectual.findByNombreProduccion", query = "SELECT p FROM ProduccionIntelectual p WHERE p.nombreProduccion = :nombreProduccion"),
    @NamedQuery(name = "ProduccionIntelectual.findByAgnoProduccion", query = "SELECT p FROM ProduccionIntelectual p WHERE p.agnoProduccion = :agnoProduccion")})
public class ProduccionIntelectual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produccion")
    private Integer idProduccion;
    @Size(max = 300)
    @Column(name = "nombre_produccion")
    private String nombreProduccion;
    @Column(name = "agno_produccion")
    private Integer agnoProduccion;
    @Lob
    @Size(max = 65535)
    @Column(name = "referencia_produccion")
    private String referenciaProduccion;
    @Size(max = 800)
    @Column(name = "url_produccion")
    private String urlProduccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produccionIntelectual")
    private List<InvestigadorProduccion> investigadorProduccionList;
    @JoinColumn(name = "id_tipo_produccion", referencedColumnName = "id_tipo_produccion")
    @ManyToOne(optional = false)
    private TipoProduccion idTipoProduccion;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private EstadoGeneral idEstado;

    public ProduccionIntelectual() {
    }

    public ProduccionIntelectual(Integer idProduccion) {
        this.idProduccion = idProduccion;
    }

    public ProduccionIntelectual(Integer idProduccion, String nombreProduccion, int agnoProduccion) {
        this.idProduccion = idProduccion;
        this.nombreProduccion = nombreProduccion;
        this.agnoProduccion = agnoProduccion;
    }

    public Integer getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(Integer idProduccion) {
        this.idProduccion = idProduccion;
    }

    public String getNombreProduccion() {
        return nombreProduccion;
    }

    public void setNombreProduccion(String nombreProduccion) {
        this.nombreProduccion = nombreProduccion;
    }

    public String getReferenciaProduccion() {
        return referenciaProduccion;
    }

    public void setReferenciaProduccion(String referenciaProduccion) {
        this.referenciaProduccion = referenciaProduccion;
    }

    public TipoProduccion getIdTipoProduccion() {
        return idTipoProduccion;
    }

    public void setIdTipoProduccion(TipoProduccion idTipoProduccion) {
        this.idTipoProduccion = idTipoProduccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduccion != null ? idProduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduccionIntelectual)) {
            return false;
        }
        ProduccionIntelectual other = (ProduccionIntelectual) object;
        if ((this.idProduccion == null && other.idProduccion != null) || (this.idProduccion != null && !this.idProduccion.equals(other.idProduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + idProduccion + "] - " + nombreProduccion;
    }

    @XmlTransient
    public List<InvestigadorProduccion> getInvestigadorProduccionList() {
        return investigadorProduccionList;
    }

    public void setInvestigadorProduccionList(List<InvestigadorProduccion> investigadorProduccionList) {
        this.investigadorProduccionList = investigadorProduccionList;
    }

    public EstadoGeneral getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoGeneral idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getAgnoProduccion() {
        return agnoProduccion;
    }

    public void setAgnoProduccion(Integer agnoProduccion) {
        this.agnoProduccion = agnoProduccion;
    }

    public String getUrlProduccion() {
        return urlProduccion;
    }

    public void setUrlProduccion(String urlProduccion) {
        this.urlProduccion = urlProduccion;
    }
}
