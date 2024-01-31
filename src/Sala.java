public class Sala {
    private String idSala;
    private int capacidad;
    private String equipamiento;
    private String ubicacion;

    public Sala(String idSala, int capacidad, String equipamiento, String ubicacion) {
        this.idSala = idSala;
        this.capacidad = capacidad;
        this.equipamiento = equipamiento;
        this.ubicacion = ubicacion;
    }

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento = equipamiento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    @Override
    public String toString() {
        return "Sala{" +
                "idSala='" + idSala + '\'' +
                ", capacidad=" + capacidad +
                ", equipamiento='" + equipamiento + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
