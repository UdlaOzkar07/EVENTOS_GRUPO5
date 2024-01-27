import java.sql.Time;
import java.util.Date;
import java.util.Set;

public class Evento implements Comparable<Evento> {
    private String idEvento;
    private String nombre;
    private String descripcion;

    private Date fecha;
    private int cupoMaximo;
    private String estado;
    private String idSala;
    private String idOrador;

    private String categorias;

    public Evento(String idEvento, String nombre, String descripcion, Date fecha, int cupoMaximo, String estado, String idSala,
                  String idOrador,String categorias) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.cupoMaximo = cupoMaximo;
        this.estado = estado;
        this.idSala = idSala;
        this.idOrador = idOrador;
        this.categorias = categorias;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(Integer cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;

    }

    public String getIdOrador() {
        return idOrador;
    }

    public void setIdOrador(String idOrador) {
        this.idOrador = idOrador;
    }
    @Override
    public int compareTo(Evento e) {
        return this.estado.compareTo(e.getEstado());
    }

    @Override
    public String toString() {
        return "Evento{" +
                "idEvento='" + idEvento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", CategoriaEvento='" + categorias + '\'' +
                ", fecha=" + fecha +
                ", cupoMaximo=" + cupoMaximo +
                ", estado='" + estado + '\'' +
                '}';
    }
}
