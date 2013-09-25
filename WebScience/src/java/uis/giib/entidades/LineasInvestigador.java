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
@Table(name = "lineas_investigador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LineasInvestigador.findAll", query = "SELECT l FROM LineasInvestigador l"),
    @NamedQuery(name = "LineasInvestigador.findByIdLinea", query = "SELECT l FROM LineasInvestigador l WHERE l.lineasInvestigadorPK.idLinea = :idLinea"),
    @NamedQuery(name = "LineasInvestigador.findByIdInvestigador", query = "SELECT l FROM LineasInvestigador l WHERE l.lineasInvestigadorPK.idInvestigador = :idInvestigador")})
public class LineasInvestigador implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LineasInvestigadorPK lineasInvestigadorPK;
    @JoinColumn(name = "id_investigador", referencedColumnName = "usuario_investigador", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Investigador investigador;
    @JoinColumn(name = "id_linea", referencedColumnName = "id_linea_investigacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LineaInvestigacion lineaInvestigacion;

    public LineasInvestigador() {
    }

    public LineasInvestigador(LineasInvestigadorPK lineasInvestigadorPK) {
        this.lineasInvestigadorPK = lineasInvestigadorPK;
    }

    public LineasInvestigador(int idLinea, String idInvestigador) {
        this.lineasInvestigadorPK = new LineasInvestigadorPK(idLinea, idInvestigador);
    }

    public LineasInvestigadorPK getLineasInvestigadorPK() {
        return lineasInvestigadorPK;
    }

    public void setLineasInvestigadorPK(LineasInvestigadorPK lineasInvestigadorPK) {
        this.lineasInvestigadorPK = lineasInvestigadorPK;
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }

    public LineaInvestigacion getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(LineaInvestigacion lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lineasInvestigadorPK != null ? lineasInvestigadorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineasInvestigador)) {
            return false;
        }
        LineasInvestigador other = (LineasInvestigador) object;
        if ((this.lineasInvestigadorPK == null && other.lineasInvestigadorPK != null) || (this.lineasInvestigadorPK != null && !this.lineasInvestigadorPK.equals(other.lineasInvestigadorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.LineasInvestigador[ lineasInvestigadorPK=" + lineasInvestigadorPK + " ]";
    }
    
}
