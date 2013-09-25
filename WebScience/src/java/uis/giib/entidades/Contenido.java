package uis.giib.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Entity
@Table(name = "contenido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contenido.findAll", query = "SELECT c FROM Contenido c"),
    @NamedQuery(name = "Contenido.findByIdPublicacion", query = "SELECT c FROM Contenido c WHERE c.idPublicacion = :idPublicacion"),
    @NamedQuery(name = "Contenido.findByFechaInicioevento", query = "SELECT c FROM Contenido c WHERE c.fechaInicioevento = :fechaInicioevento"),
    @NamedQuery(name = "Contenido.findByFechaFinevento", query = "SELECT c FROM Contenido c WHERE c.fechaFinevento = :fechaFinevento"),
    @NamedQuery(name = "Contenido.findByFechaDespublicar", query = "SELECT c FROM Contenido c WHERE c.fechaDespublicar = :fechaDespublicar"),
    @NamedQuery(name = "Contenido.findByTitulo", query = "SELECT c FROM Contenido c WHERE c.titulo = :titulo")})
public class Contenido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_publicacion")
    private Integer idPublicacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "contenido_resumido")
    private String contenidoResumido;
    @Column(name = "fecha_inicioevento")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioevento;
    @Column(name = "fecha_finevento")
    @Temporal(TemporalType.DATE)
    private Date fechaFinevento;
    @Column(name = "fecha_despublicar")
    @Temporal(TemporalType.DATE)
    private Date fechaDespublicar;
    @Size(max = 50)
    @Column(name = "titulo")
    private String titulo;
    @Lob
    @Size(max = 65535)
    @Column(name = "contenido_detallado")
    private String contenidoDetallado;
    @JoinColumn(name = "id_multimedia", referencedColumnName = "id_multimedia")
    @ManyToOne
    private Multimedia idMultimedia;
    @JoinColumn(name = "id_tipo_publicacion", referencedColumnName = "id_tipo_publicacion")
    @ManyToOne
    private TipoContenido idTipoPublicacion;
    @JoinColumn(name = "id_seccion", referencedColumnName = "id_seccion")
    @ManyToOne
    private Seccion idSeccion;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private EstadoGeneral idEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPublicacion")
    private List<Recursos> recursosList;

    public Contenido() {
    }

    public Contenido(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Contenido(Integer idPublicacion, String contenidoResumido, String titulo, String contenidoDetallado) {
        this.idPublicacion = idPublicacion;
        this.contenidoResumido = contenidoResumido;
        this.titulo = titulo;
        this.contenidoDetallado = contenidoDetallado;
    }

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getContenidoResumido() {
        return contenidoResumido;
    }

    public void setContenidoResumido(String contenidoResumido) {
        this.contenidoResumido = contenidoResumido;
    }

    public Date getFechaInicioevento() {
        return fechaInicioevento;
    }

    public void setFechaInicioevento(Date fechaInicioevento) {
        this.fechaInicioevento = fechaInicioevento;
    }

    public Date getFechaFinevento() {
        return fechaFinevento;
    }

    public void setFechaFinevento(Date fechaFinevento) {
        this.fechaFinevento = fechaFinevento;
    }

    public Date getFechaDespublicar() {
        return fechaDespublicar;
    }

    public void setFechaDespublicar(Date fechaDespublicar) {
        this.fechaDespublicar = fechaDespublicar;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenidoDetallado() {
        return contenidoDetallado;
    }

    public void setContenidoDetallado(String contenidoDetallado) {
        this.contenidoDetallado = contenidoDetallado;
    }

    public Multimedia getIdMultimedia() {
        return idMultimedia;
    }

    public void setIdMultimedia(Multimedia idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public TipoContenido getIdTipoPublicacion() {
        return idTipoPublicacion;
    }

    public void setIdTipoPublicacion(TipoContenido idTipoPublicacion) {
        this.idTipoPublicacion = idTipoPublicacion;
    }

    public Seccion getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Seccion idSeccion) {
        this.idSeccion = idSeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPublicacion != null ? idPublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contenido)) {
            return false;
        }
        Contenido other = (Contenido) object;
        if ((this.idPublicacion == null && other.idPublicacion != null) || (this.idPublicacion != null && !this.idPublicacion.equals(other.idPublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + idPublicacion + "] - " + titulo;
    }

    public EstadoGeneral getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoGeneral idEstado) {
        this.idEstado = idEstado;
    }

    @XmlTransient
    public List<Recursos> getRecursosList() {
        return recursosList;
    }

    public void setRecursosList(List<Recursos> recursosList) {
        this.recursosList = recursosList;
    }
}
