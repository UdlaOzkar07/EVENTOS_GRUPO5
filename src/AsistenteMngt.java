import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class AsistenteMngt {
    private List<Asistente> asistentes;

    public AsistenteMngt() {
        this.asistentes = new ArrayList<Asistente>();

        asistentes.add(new Asistente("jarteaga","jarteaga","1722631299"," Jahir","Arteaga", Date.valueOf("2023-01-23"),"jarteaga@hotmail.com","0984694655","Quito"));
        asistentes.add(new Asistente("jsanchez","jsanchez","1722631289","José","Sánchez",Date.valueOf("2023-01-23"),"jsanchez@hotmail.com","0984694800","Quito"));
        asistentes.add(new Asistente("pmartinez","pmartinez","1725245963"," Pedro","Martinez", Date.valueOf("2023-01-23"),"jarteaga@hotmail.com","0984694655","Quito"));
        asistentes.add(new Asistente("jperez","jsanchez","1722631275","Juan","Perez",Date.valueOf("2023-01-23"),"jsanchez@hotmail.com","0984694800","Quito"));
    }

    public void agregarAsistente(Asistente asistente) throws Exception{
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
                a.setApellido(asistente.getApellido());
                a.setFechaNacimiento(asistente.getFechaNacimiento());
                a.setCorreo(asistente.getCorreo());
                a.setDireccion(asistente.getDireccion());
                a.setTelefono(asistente.getTelefono());
                a.setIdUsuario(asistente.getIdUsuario());
                a.setContrasena(asistente.getContrasena());
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

    public Asistente obtenerAsistentePorCedula(String cedula) throws Exception
    {
        for (Asistente a: asistentes) {
            if(a.getCedula().equals(cedula))
                return a;
        }

        throw new Exception("No se encuentra registrado el Asistente con Id: " + cedula);
    }
}
