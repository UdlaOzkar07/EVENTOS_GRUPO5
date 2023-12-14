public class Sala {
    private String idSala;
    private Integer capacidad;
    private String equipamiento;
    private String ubicacion;
    private boolean disponiblible;

    public Sala(String idSala, Integer capacidad, String equipamiento, String ubicacion, boolean disponiblible) {
        this.idSala = idSala;
        this.capacidad = capacidad;
        this.equipamiento = equipamiento;
        this.ubicacion = ubicacion;
        this.disponiblible = disponiblible;
    }

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
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

    public boolean isDispoble() {
        return disponiblible;
    }

    public void setDisponible(boolean disponiblible) {
        this.disponiblible = disponiblible;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "idSala='" + idSala + '\'' +
                ", capacidad=" + capacidad +
                ", equipamiento='" + equipamiento + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", disponiblible=" + disponiblible +
                '}';
    }
}
