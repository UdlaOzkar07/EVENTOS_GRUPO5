import java.util.ArrayList;
import java.util.List;

public class OradorMngt {
    private List<Orador> oradores;
    public OradorMngt() {
        this.oradores = new ArrayList<Orador>();

        oradores.add(new Orador("orodriguez","orodriguez","1722631296","Oscar","Rodriguez","correo@hotmail.com","0984694855","Pomasqui","Ing. Software"));
        oradores.add(new Orador("jarauz","jarauz","1722631297","Juan","Arauz","correo@prueba.com","0984694966","Tumbaco","Ing. Software"));
    }

    public void agregarOrador(Orador orador) throws Exception{
        if (!existeOrador(orador.getCedula()))
            oradores.add(orador);
        else
            throw new Exception("Ya se encuentra registrado un Orador con id: " + orador.getCedula());
    }

    public void eliminarOrador(String cedula) throws Exception{
        for (Orador o : oradores){
            if (o.getCedula().equals(cedula)){
                oradores.remove(o);
                return;
            }
        }

        throw new Exception("No se encuentra registrado el Orador con Id: " + cedula);
    }

    public void modificarOrador(Orador orador) throws Exception
    {
        if (!existeOrador(orador.getCedula()))
            throw new Exception("El Orador con id: "+ orador.getCedula() + " no se encuentra registrado");
        for (Orador o: oradores) {
            if (o.getCedula().equals(orador.getCedula())){
                o.setNombre(orador.getNombre());
            }
        }
    }

    public boolean existeOrador(String cedula)
    {
        for (Orador o: oradores) {
            if (o.getCedula().equals(cedula))
                return true;
        }

        return false;
    }
    public List<Orador> listarOradores()
    {
        return oradores;
    }
}
