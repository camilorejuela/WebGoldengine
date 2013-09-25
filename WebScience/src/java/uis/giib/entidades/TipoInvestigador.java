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
@Table(name = "tipo_investigador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoInvestigador.findAll", query = "SELECT t FROM TipoInvestigador t"),
    @NamedQuery(name = "TipoInvestigador.findByIdTipoInvestigador", query = "SELECT t FROM TipoInvestigador t WHERE t.idTipoInvestigador = :idTipoInvestigador"),
    @NamedQuery(name = "TipoInvestigador.findByNombreTipoInvestigador", query = "SELECT t FROM TipoInvestigador t WHERE t.nombreTipoInvestigador = :nombreTipoInvestigador"),
    @NamedQuery(name = "TipoInvestigador.findAllNombreTipoInvestigador", query = "SELECT t.nombreTipoInvestigador FROM TipoInvestigador t "),
    @NamedQuery(name = "TipoInvestigador.findByDescripcionTipoInvestigador", query = "SELECT t FROM TipoInvestigador t WHERE t.descripcionTipoInvestigador = :descripcionTipoInvestigador")})
public class TipoInvestigador implements Serializable {
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_investigador")
    private Integer idTipoInvestigador;
    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "nombre_tipo_investigador")
    private String nombreTipoInvestigador;
    @Basic(optional = false)
    @NotNull
    @Size(max = 200)
    @Column(name = "descripcion_tipo_investigador")
    private String descripcionTipoInvestigador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoInvestigador")
    private List<Investigador> investigadorList;

    public TipoInvestigador() {
    }

    public TipoInvestigador(Integer idTipoInvestigador) {
        this.idTipoInvestigador = idTipoInvestigador;
    }

    public TipoInvestigador(Integer idTipoInvestigador, String nombreTipoInvestigador, String descripcionTipoInvestigador) {
        this.idTipoInvestigador = idTipoInvestigador;
        this.nombreTipoInvestigador = nombreTipoInvestigador;
        this.descripcionTipoInvestigador = descripcionTipoInvestigador;
    }

    public Integer getIdTipoInvestigador() {
        return idTipoInvestigador;
    }

    public void setIdTipoInvestigador(Integer idTipoInvestigador) {
        this.idTipoInvestigador = idTipoInvestigador;
    }

    public String getNombreTipoInvestigador() {
        return nombreTipoInvestigador;
    }

    public void setNombreTipoInvestigador(String nombreTipoInvestigador) {
        this.nombreTipoInvestigador = nombreTipoInvestigador;
    }

    public String getDescripcionTipoInvestigador() {
        return descripcionTipoInvestigador;
    }

    public void setDescripcionTipoInvestigador(String descripcionTipoInvestigador) {
        this.descripcionTipoInvestigador = descripcionTipoInvestigador;
    }

    @XmlTransient
    public List<Investigador> getInvestigadorList() {
        return investigadorList;
    }

    public void setInvestigadorList(List<Investigador> investigadorList) {
        this.investigadorList = investigadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoInvestigador != null ? idTipoInvestigador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInvestigador)) {
            return false;
        }
        TipoInvestigador other = (TipoInvestigador) object;
        if ((this.idTipoInvestigador == null && other.idTipoInvestigador != null) || (this.idTipoInvestigador != null && !this.idTipoInvestigador.equals(other.idTipoInvestigador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + idTipoInvestigador + "] - " + nombreTipoInvestigador;
    }
    
}
