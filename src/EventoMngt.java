import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EventoMngt {
    private List<Evento> eventos;

    public EventoMngt() {
        this.eventos = new ArrayList<Evento>();

        eventos.add(new Evento("001","Iniciativas de team building", "objetivo es motivar o formar grupos de trabajo","Social", Date.valueOf(LocalDate.now()), Time.valueOf(LocalTime.now()),Time.valueOf(LocalTime.now()),35,"Pendiente"));
        eventos.add(new Evento("002","Juntas generales de accionistas", "elegir al Consejo de Administración","Laboral", Date.valueOf(LocalDate.now()), Time.valueOf(LocalTime.now()),Time.valueOf(LocalTime.now()),35,"Finalizado"));
    }

    public void agregarEvento(Evento evento) throws Exception{
        if (!existeEvento(evento.getIdEvento()))
            eventos.add(evento);
        else
            throw new Exception("Ya se encuentra registrado el Evento con id: " + evento.getIdEvento());
    }

    public void eliminarEvento(String idEvento) throws Exception{
        for (Evento e : eventos){
            if (e.getIdEvento().equals(idEvento)){
                eventos.remove(e);
                return;
            }
        }

        throw new Exception("No se encontro el Evento con Id: " + idEvento);
    }

    public void modificarEvento(Evento evento) throws Exception
    {
        if (!existeEvento(evento.getIdEvento()))
            throw new Exception("El evento con id: "+ evento.getIdEvento() + " no se encuentra registrada");
        for (Evento e: eventos) {
            if (e.getIdEvento().equals(evento.getIdEvento())){
                e.setDescripcion(evento.getDescripcion());
            }
        }
    }

    public boolean existeEvento(String idEvento)
    {
        for (Evento e: eventos) {
            if (e.getIdEvento().equals(idEvento))
                return true;
        }

        return false;
    }
    public List<Evento> listarEventos()
    {
        return eventos;
    }
}
