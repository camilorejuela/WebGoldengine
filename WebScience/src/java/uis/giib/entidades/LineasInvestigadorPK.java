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
public class LineasInvestigadorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_linea")
    private int idLinea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_investigador")
    private String idInvestigador;

    public LineasInvestigadorPK() {
    }

    public LineasInvestigadorPK(int idLinea, String idInvestigador) {
        this.idLinea = idLinea;
        this.idInvestigador = idInvestigador;
    }

    public int getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
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
        hash += (int) idLinea;
        hash += (idInvestigador != null ? idInvestigador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineasInvestigadorPK)) {
            return false;
        }
        LineasInvestigadorPK other = (LineasInvestigadorPK) object;
        if (this.idLinea != other.idLinea) {
            return false;
        }
        if ((this.idInvestigador == null && other.idInvestigador != null) || (this.idInvestigador != null && !this.idInvestigador.equals(other.idInvestigador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.LineasInvestigadorPK[ idLinea=" + idLinea + ", idInvestigador=" + idInvestigador + " ]";
    }
    
}
