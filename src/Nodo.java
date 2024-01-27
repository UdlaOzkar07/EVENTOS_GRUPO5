import java.util.ArrayList;
import java.util.List;

public class Nodo {
    String id;
    String tipo; // "Evento", "Categoria" o "Orador"
    List<Nodo> hijos;

    Nodo(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
        hijos = new ArrayList<>();
    }

}
