public class AsistenteEvento {
    private Evento evento;
    private Asistente asistente;

    public AsistenteEvento(Evento evento, Asistente asistente) {
        this.evento = evento;
        this.asistente = asistente;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Asistente getAsistente() {
        return asistente;
    }

    public void setAsistente(Asistente asistente) {
        this.asistente = asistente;
    }
}
