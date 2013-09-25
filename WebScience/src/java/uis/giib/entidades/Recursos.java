/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "recursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recursos.findAll", query = "SELECT r FROM Recursos r"),
    @NamedQuery(name = "Recursos.findByIdRecurso", query = "SELECT r FROM Recursos r WHERE r.idRecurso = :idRecurso")})
public class Recursos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_recurso")
    private Integer idRecurso;
    @JoinColumn(name = "id_publicacion", referencedColumnName = "id_publicacion")
    @ManyToOne(optional = false)
    private Contenido idPublicacion;
    @JoinColumn(name = "id_multimedia", referencedColumnName = "id_multimedia")
    @ManyToOne
    private Multimedia idMultimedia;

    public Recursos() {
    }

    public Recursos(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Integer getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Contenido getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Contenido idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Multimedia getIdMultimedia() {
        return idMultimedia;
    }

    public void setIdMultimedia(Multimedia idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecurso != null ? idRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recursos)) {
            return false;
        }
        Recursos other = (Recursos) object;
        if ((this.idRecurso == null && other.idRecurso != null) || (this.idRecurso != null && !this.idRecurso.equals(other.idRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + idRecurso + "] - " ;
    }
    
}
