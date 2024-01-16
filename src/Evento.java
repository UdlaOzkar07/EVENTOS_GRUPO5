import java.sql.Time;
import java.util.Date;

public class Evento {
    private String idEvento;
    private String nombre;
    private String descripcion;
    private String tipoEvento;
    private Date fecha;
    private Time horainicio;
    private Time horafin;
    private Integer cupoMaximo;
    private String estado;
    private String idSala;

    public Evento(String idEvento, String nombre, String descripcion, String tipoEvento, Date fecha, Time horainicio, Time horafin, Integer cupoMaximo, String estado, String idSala) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoEvento = tipoEvento;
        this.fecha = fecha;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.cupoMaximo = cupoMaximo;
        this.estado = estado;
        this.idSala = idSala;
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

    public Time getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Time horainicio) {
        this.horainicio = horainicio;
    }

    public Time getHorafin() {
        return horafin;
    }

    public void setHorafin(Time horafin) {
        this.horafin = horafin;
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

    @Override
    public String toString() {
        return "Evento{" +
                "idEvento='" + idEvento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", fecha=" + fecha +
                ", horainicio=" + horainicio +
                ", horafin=" + horafin +
                ", cupoMaximo=" + cupoMaximo +
                ", estado='" + estado + '\'' +
                '}';
    }
}
