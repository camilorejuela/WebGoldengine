package uis.giib.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Entity
@Table(name = "bibliografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bibliografia.findAll", query = "SELECT b FROM Bibliografia b"),
    @NamedQuery(name = "Bibliografia.findByIdBibliografia", query = "SELECT b FROM Bibliografia b WHERE b.idBibliografia = :idBibliografia"),
    @NamedQuery(name = "Bibliografia.findByNomnreBibliografia", query = "SELECT b FROM Bibliografia b WHERE b.nomnreBibliografia = :nomnreBibliografia"),
    @NamedQuery(name = "Bibliografia.findByAgnoBibliografia", query = "SELECT b FROM Bibliografia b WHERE b.agnoBibliografia = :agnoBibliografia"),
    @NamedQuery(name = "Bibliografia.findByReferenciaBibliografia", query = "SELECT b FROM Bibliografia b WHERE b.referenciaBibliografia = :referenciaBibliografia"),
    @NamedQuery(name = "Bibliografia.findByUrlBibliografia", query = "SELECT b FROM Bibliografia b WHERE b.urlBibliografia = :urlBibliografia")})
public class Bibliografia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bibliografia")
    private Integer idBibliografia;
    @Size(max = 500)
    @Column(name = "nomnre_bibliografia")
    private String nomnreBibliografia;
    @Column(name = "agno_bibliografia")
    @Temporal(TemporalType.DATE)
    private Date agnoBibliografia;
    @Size(max = 800)
    @Column(name = "referencia_bibliografia")
    private String referenciaBibliografia;
    @Size(max = 800)
    @Column(name = "url_bibliografia")
    private String urlBibliografia;
    @JoinColumn(name = "id_tipo_bibliografia", referencedColumnName = "id_tipo_produccion")
    @ManyToOne(optional = false)
    private TipoProduccion idTipoBibliografia;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private EstadoGeneral idEstado;
    @JoinColumn(name = "id_linea", referencedColumnName = "id_linea_investigacion")
    @ManyToOne(optional = false)
    private LineaInvestigacion idLinea;

    public Bibliografia() {
    }

    public Bibliografia(Integer idBibliografia) {
        this.idBibliografia = idBibliografia;
    }

    public Integer getIdBibliografia() {
        return idBibliografia;
    }

    public void setIdBibliografia(Integer idBibliografia) {
        this.idBibliografia = idBibliografia;
    }

    public String getNomnreBibliografia() {
        return nomnreBibliografia;
    }

    public void setNomnreBibliografia(String nomnreBibliografia) {
        this.nomnreBibliografia = nomnreBibliografia;
    }

    public Date getAgnoBibliografia() {
        return agnoBibliografia;
    }

    public void setAgnoBibliografia(Date agnoBibliografia) {
        this.agnoBibliografia = agnoBibliografia;
    }

    public String getReferenciaBibliografia() {
        return referenciaBibliografia;
    }

    public void setReferenciaBibliografia(String referenciaBibliografia) {
        this.referenciaBibliografia = referenciaBibliografia;
    }

    public String getUrlBibliografia() {
        return urlBibliografia;
    }

    public void setUrlBibliografia(String urlBibliografia) {
        this.urlBibliografia = urlBibliografia;
    }

    public TipoProduccion getIdTipoBibliografia() {
        return idTipoBibliografia;
    }

    public void setIdTipoBibliografia(TipoProduccion idTipoBibliografia) {
        this.idTipoBibliografia = idTipoBibliografia;
    }

    public EstadoGeneral getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoGeneral idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBibliografia != null ? idBibliografia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bibliografia)) {
            return false;
        }
        Bibliografia other = (Bibliografia) object;
        if ((this.idBibliografia == null && other.idBibliografia != null) || (this.idBibliografia != null && !this.idBibliografia.equals(other.idBibliografia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.Bibliografia[ idBibliografia=" + idBibliografia + " ]";
    }

    public LineaInvestigacion getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(LineaInvestigacion idLinea) {
        this.idLinea = idLinea;
    }
}
