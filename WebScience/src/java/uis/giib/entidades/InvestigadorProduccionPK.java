/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Carlos
 */
@Embeddable
public class InvestigadorProduccionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produccion")
    private int idProduccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_investigador")
    private String idInvestigador;

    public InvestigadorProduccionPK() {
    }

    public InvestigadorProduccionPK(int idProduccion, String idInvestigador) {
        this.idProduccion = idProduccion;
        this.idInvestigador = idInvestigador;
    }

    public int getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(int idProduccion) {
        this.idProduccion = idProduccion;
    }

    public String getIdInvestigador() {
        return idInvestigador;
    }

    public void setIdInvestigador(String idInvestigador) {
        this.idInvestigador = idInvestigador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduccion;
        hash += (idInvestigador != null ? idInvestigador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvestigadorProduccionPK)) {
            return false;
        }
        InvestigadorProduccionPK other = (InvestigadorProduccionPK) object;
        if (this.idProduccion != other.idProduccion) {
            return false;
        }
        if ((this.idInvestigador == null && other.idInvestigador != null) || (this.idInvestigador != null && !this.idInvestigador.equals(other.idInvestigador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.InvestigadorProduccionPK[ idProduccion=" + idProduccion + ", idInvestigador=" + idInvestigador + " ]";
    }
    
}
