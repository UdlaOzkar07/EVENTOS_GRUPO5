import java.sql.Time;
import java.util.Date;

public class Evento implements Comparable<Evento> {
    private String idEvento;
    private String nombre;
    private String descripcion;
    private String tipoEvento;
    private Date fecha;
    private int cupoMaximo;
    private String estado;
    private Sala sala;
    private Orador orador;

    public Evento(String idEvento, String nombre, String descripcion, String tipoEvento, Date fecha, int cupoMaximo, String estado, Sala sala, Orador orador) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoEvento = tipoEvento;
        this.fecha = fecha;
        this.cupoMaximo = cupoMaximo;
        this.estado = estado;
        this.sala = sala;
        this.orador = orador;
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

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Orador getOrador() {
        return orador;
    }

    public void setOrador(Orador orador) {
        this.orador = orador;
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
                ", tipoEvento='" + tipoEvento + '\'' +
                ", fecha=" + fecha +
                ", cupoMaximo=" + cupoMaximo +
                ", estado='" + estado + '\'' +
                '}';
    }
}
