import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class EventoMngt {
    private List<Evento> eventos;
    private Map<String, Set<Evento>>categoriaEventoMap;

    public EventoMngt() {
        this.eventos = new ArrayList<>();


        eventos.add(new Evento("001","Iniciativas de team building", "objetivo es motivar o formar grupos de trabajo",Date.valueOf("2023-12-25"),35,"Finalizado", "001","1722631296","Social"));
        eventos.add(new Evento("002","Juntas generales de accionistas", "elegir al Consejo de Administración",Date.valueOf("2023-12-31"),35,"Finalizado","002","1722631297","Social"));
        eventos.add(new Evento("003","Juntas generales de accionistas", "elegir al Consejo de Administración",Date.valueOf("2024-02-01"),35,"Creado","002","1722631297","Laboral"));
        eventos.add(new Evento("004","Juntas generales de accionistas", "elegir al Consejo de Administración",Date.valueOf("2024-02-15"),35,"Creado","002","1722631297","Social"));
        eventos.add(new Evento("005","Juntas generales de accionistas", "elegir al Consejo de Administración",Date.valueOf("2024-02-15"),35,"En Proceso","002","1722631297","Infantil"));
        eventos.add(new Evento("006","Juntas generales de accionistas", "elegir al Consejo de Administración", Date.valueOf("2024-02-15"),35,"Cancelado","002","1722631297","Infantil"));

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

    public Evento obtenerEvento(String idEvento) throws Exception
    {
        for (Evento e: eventos) {
            if(e.getIdEvento().equals(idEvento))
                return e;
        }

        throw new Exception("No se encuentra registrado el evento con Id: " + idEvento);
    }

    public int contarAsistentes(AsistenteEventoMngt aEventos, String idEvento)
    {
        return contarAsistentes(aEventos,idEvento,0);
    }

    private int contarAsistentes(AsistenteEventoMngt aEventos, String idEvento, int indice)
    {

        if(indice== aEventos.listarAsistenteEventos().size())
            return 0;

        AsistenteEvento asistenteEvento = aEventos.listarAsistenteEventos().get(indice);

        if(asistenteEvento.getIdEvento().equals(idEvento))
            return contarAsistentes(aEventos,idEvento, indice + 1) + 1;
        else
            return contarAsistentes(aEventos,idEvento, indice + 1);
    }

    public List<Evento> buscarEventoEstado(String estado)
    {
        List<Evento> eventosEncontrados = new ArrayList<Evento>();
        int inicio = 0;
        int fin = eventos.size() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int comparacion = eventos.get(medio).getEstado().compareTo(estado);

            if (comparacion == 0) {
                // Elemento encontrado, agregar a la lista
                eventosEncontrados.add(eventos.get(medio));

                // Buscar en la mitad izquierda y derecha por si hay más elementos con el mismo estado
                int i = medio - 1;
                while (i >= 0 && eventos.get(i).getEstado().equals(estado)) {
                    eventosEncontrados.add(eventos.get(i));
                    i--;
                }

                int j = medio + 1;
                while (j < eventos.size() && eventos.get(j).getEstado().equals(estado)) {
                    eventosEncontrados.add(eventos.get(j));
                    j++;
                }

                return eventosEncontrados;
            } else if (comparacion < 0) {
                inicio = medio + 1; // Buscar en la mitad derecha
            } else {
                fin = medio - 1; // Buscar en la mitad izquierda
            }
        }

        return eventosEncontrados; // Elementos no encontrados
    }

}
