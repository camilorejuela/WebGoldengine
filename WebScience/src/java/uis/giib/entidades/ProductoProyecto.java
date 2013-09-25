package uis.giib.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Entity
@Table(name = "producto_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoProyecto.findAll", query = "SELECT p FROM ProductoProyecto p"),
    @NamedQuery(name = "ProductoProyecto.findByIdProducto", query = "SELECT p FROM ProductoProyecto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "ProductoProyecto.findByNombreProducto", query = "SELECT p FROM ProductoProyecto p WHERE p.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "ProductoProyecto.findByEnlaceProducto", query = "SELECT p FROM ProductoProyecto p WHERE p.enlaceProducto = :enlaceProducto")})
public class ProductoProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Size(max = 150)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion_producto")
    private String descripcionProducto;
    @Size(max = 800)
    @Column(name = "enlace_producto")
    private String enlaceProducto;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private EstadoGeneral idEstado;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private Proyecto idProyecto;

    public ProductoProyecto() {
    }

    public ProductoProyecto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getEnlaceProducto() {
        return enlaceProducto;
    }

    public void setEnlaceProducto(String enlaceProducto) {
        this.enlaceProducto = enlaceProducto;
    }

    public EstadoGeneral getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoGeneral idEstado) {
        this.idEstado = idEstado;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoProyecto)) {
            return false;
        }
        ProductoProyecto other = (ProductoProyecto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + idProducto + "] - " + nombreProducto;
    }
    
}
