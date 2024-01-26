import java.util.ArrayList;
import java.util.List;

public class SalaMngt {
    private List<Sala> salas;

    public SalaMngt() {
        this.salas = new ArrayList<Sala>();

        salas.add(new Sala("001",50,"Proyector, Control, Computador","Planta Baja"));
        salas.add(new Sala("002",50,"Proyector, Control, Computador","Planta Baja"));
        salas.add(new Sala("003",70,"Proyector, Control, Computador","Segundo Piso"));
        salas.add(new Sala("004",70,"Proyector, Control, Computador","Segundo Piso"));
        salas.add(new Sala("005",100,"Proyector, Control, Computador","Tercer Piso"));
    }

    public void agregarSala(Sala sala) throws Exception{
        if (!existeSala(sala.getIdSala()))
            salas.add(sala);
        else
            throw new Exception("Ya se encuentra registrado un Sala con id: " + sala.getIdSala());
    }

    public void eliminarSala(String idSala) throws Exception{
        for (Sala s : salas){
            if (s.getIdSala().equals(idSala)){
                salas.remove(s);
                return;
            }
        }

        throw new Exception("No se encontro la Sala con Id: " + idSala);
    }

    public void modificarSala(Sala sala) throws Exception
    {
        if (!existeSala(sala.getIdSala()))
            throw new Exception("La sala con id: "+ sala.getIdSala() + " no se encuentra registrada");
        for (Sala s: salas) {
            if (s.getIdSala().equals(sala.getIdSala())){
                s.setCapacidad(sala.getCapacidad());
                s.setEquipamiento(sala.getEquipamiento());
                s.setUbicacion(sala.getUbicacion());
            }
        }
    }

    public boolean existeSala(String idSala)
    {
        for (Sala s: salas) {
            if (s.getIdSala().equals(idSala))
                return true;
        }

        return false;
    }
    public List<Sala> listarSalas()
    {
        return salas;
    }

    public Sala obtenerSala(String idSala) throws Exception
    {
        for (Sala s: salas) {
            if(s.getIdSala().equals(idSala))
                return s;
        }

        throw new Exception("No se encuentra registrado la Sala con Id: " + idSala);
    }
}
