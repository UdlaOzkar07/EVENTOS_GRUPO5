public class AsistenteEvento {
    private String idEvento;
    private String idAsistente;

    public AsistenteEvento(String idEvento, String idAsistente) {
        this.idEvento = idEvento;
        this.idAsistente = idAsistente;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(String idAsistente) {
        this.idAsistente = idAsistente;
    }
}
