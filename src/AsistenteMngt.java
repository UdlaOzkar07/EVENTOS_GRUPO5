import java.util.ArrayList;
import java.util.List;

public class AsistenteMngt {
    private List<Asistente> asistentes;

    public AsistenteMngt() {
        this.asistentes = new ArrayList<Asistente>();
    }

    public void agregarOrador(Asistente asistente) throws Exception{
        if (!existeAsistente(asistente.getCedula()))
            asistentes.add(asistente);
        else
            throw new Exception("Ya se encuentra registrado el Asistente con id: " + asistente.getCedula());
    }

    public void eliminarAsistente(String cedula) throws Exception{
        for (Asistente a : asistentes){
            if (a.getCedula().equals(cedula)){
                asistentes.remove(a);
                return;
            }
        }

        throw new Exception("No se encuentra registrado el Asistente con Id: " + cedula);
    }

    public void modificarAsistente(Asistente asistente) throws Exception
    {
        if (!existeAsistente(asistente.getCedula()))
            throw new Exception("El Asistente con id: "+ asistente.getCedula() + " no se encuentra registrado");
        for (Asistente a: asistentes) {
            if (a.getCedula().equals(asistente.getCedula())){
                a.setNombre(asistente.getNombre());
            }
        }
    }

    public boolean existeAsistente(String cedula)
    {
        for (Asistente a: asistentes) {
            if (a.getCedula().equals(cedula))
                return true;
        }

        return false;
    }
    public List<Asistente> listarAsistentes()
    {
        return asistentes;
    }
}
