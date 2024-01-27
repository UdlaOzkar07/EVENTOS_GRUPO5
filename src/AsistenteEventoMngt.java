import java.util.ArrayList;
import java.util.List;

public class AsistenteEventoMngt {

    private List<AsistenteEvento> asistenteEventos;
    public AsistenteEventoMngt() {
        asistenteEventos = new ArrayList<AsistenteEvento>();
    }

    public void agregarAsistenteEvento(AsistenteEvento asistenteEvento) throws Exception{
        if (!existeAsistente(asistenteEvento.getIdEvento(),asistenteEvento.getIdAsistente()))
            asistenteEventos.add(asistenteEvento);
        else
            throw new Exception("El Asistente con Id: " + asistenteEvento.getIdAsistente() + "ya se encuentra inscrito en el evento con Id: " + asistenteEvento.getIdEvento());
    }


    public boolean existeAsistente(String idEvento, String cedula)
    {
        for (AsistenteEvento a: asistenteEventos) {
            if (a.getIdAsistente().equals(cedula) && a.getIdEvento().equals(idEvento))
                return true;
        }

        return false;
    }
    public List<AsistenteEvento> listarAsistenteEventos()
    {
        return asistenteEventos;
    }
}
