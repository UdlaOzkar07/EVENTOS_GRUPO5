public class Usuario {
    private String idUsiario;
    private String contrasenia;
    private String rol;
    private String nombre;
    private String apellido;
    private String correo;
    private String preferencias;

    public Usuario(String idUsiario, String contrasenia, String rol, String nombre, String apellido, String correo, String preferencias) {
        this.idUsiario = idUsiario;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.preferencias = preferencias;
    }

    public String getId() {
        return idUsiario;
    }

    public void setId(String id) {
        this.idUsiario = id;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }
}
