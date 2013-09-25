/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "investigador_produccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvestigadorProduccion.findAll", query = "SELECT i FROM InvestigadorProduccion i"),
    @NamedQuery(name = "InvestigadorProduccion.findByIdProduccion", query = "SELECT i FROM InvestigadorProduccion i WHERE i.investigadorProduccionPK.idProduccion = :idProduccion"),
    @NamedQuery(name = "InvestigadorProduccion.findByIdInvestigador", query = "SELECT i FROM InvestigadorProduccion i WHERE i.investigadorProduccionPK.idInvestigador = :idInvestigador")})

public class InvestigadorProduccion implements Serializable {
    
    @JoinColumn(name = "id_produccion", referencedColumnName = "id_produccion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProduccionIntelectual produccionIntelectual;
    @JoinColumn(name = "id_investigador", referencedColumnName = "usuario_investigador", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Investigador investigador;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvestigadorProduccionPK investigadorProduccionPK;

    public InvestigadorProduccion() {
    }

    public InvestigadorProduccion(InvestigadorProduccionPK investigadorProduccionPK) {
        this.investigadorProduccionPK = investigadorProduccionPK;
    }

    public InvestigadorProduccion(int idProduccion, String idInvestigador) {
        this.investigadorProduccionPK = new InvestigadorProduccionPK(idProduccion, idInvestigador);
    }

    public InvestigadorProduccionPK getInvestigadorProduccionPK() {
        return investigadorProduccionPK;
    }

    public void setInvestigadorProduccionPK(InvestigadorProduccionPK investigadorProduccionPK) {
        this.investigadorProduccionPK = investigadorProduccionPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (investigadorProduccionPK != null ? investigadorProduccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvestigadorProduccion)) {
            return false;
        }
        InvestigadorProduccion other = (InvestigadorProduccion) object;
        if ((this.investigadorProduccionPK == null && other.investigadorProduccionPK != null) || (this.investigadorProduccionPK != null && !this.investigadorProduccionPK.equals(other.investigadorProduccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.InvestigadorProduccion[ investigadorProduccionPK=" + investigadorProduccionPK + " ]";
    }

    public ProduccionIntelectual getProduccionIntelectual() {
        return produccionIntelectual;
    }

    public void setProduccionIntelectual(ProduccionIntelectual produccionIntelectual) {
        this.produccionIntelectual = produccionIntelectual;
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }
    
}
