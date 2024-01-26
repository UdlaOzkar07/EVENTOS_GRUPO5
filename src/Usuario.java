public class Usuario {
    private String idUsuario;
    private String contrasena;
    private String nombreCompleto;
    private String email;
    private String rol;

    public Usuario(String idUsuario, String contrasena, String nombreCompleto, String email, String rol) {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.rol = rol;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
