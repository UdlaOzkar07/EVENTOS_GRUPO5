import java.util.ArrayList;
import java.util.List;

public class AsistenteEventoMngt {

    private List<AsistenteEvento> asistenteEventos;
    public AsistenteEventoMngt() {
        asistenteEventos = new ArrayList<AsistenteEvento>();
    }

    public void agregarAsistenteEvento(AsistenteEvento asistenteEvento) throws Exception{
        if (!existeAsistente(asistenteEvento.getEvento().getIdEvento(),asistenteEvento.getAsistente().getCedula()))
            asistenteEventos.add(asistenteEvento);
        else
            throw new Exception("El Asistente con Id: " + asistenteEvento.getAsistente().getCedula() + "ya se encuentra inscrito en el evento con Id: " + asistenteEvento.getEvento().getIdEvento());
    }


    public boolean existeAsistente(String idEvento, String cedula)
    {
        for (AsistenteEvento a: asistenteEventos) {
            if (a.getAsistente().getCedula().equals(cedula) && a.getEvento().getIdEvento().equals(idEvento))
                return true;
        }

        return false;
    }
    public List<AsistenteEvento> listarAsistenteEventos()
    {
        return asistenteEventos;
    }
}
