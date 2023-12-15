import java.util.ArrayList;
import java.util.List;

public class UsuarioMngt {
    private List<Usuario> usuarios;
    private Usuario usuarioActual;

    public UsuarioMngt() {
        this.usuarios = new ArrayList<Usuario>();
    }

    public void agregarUsuario(Usuario usuario) throws Exception{
        if(usuario.getIdUsuario().equals(""))
            throw new Exception("El Id. Usuario debe tener un valor");

        if(usuario.getContrasena().equals(""))
            throw new Exception("La Contraseña debe tener un valor");

        if (!existeUsuario(usuario.getIdUsuario()))
            usuarios.add(usuario);
        else
            throw new Exception("Ya se encuentra registrado un Usuario con id: " + usuario.getIdUsuario());
    }

    public void eliminarUsuario(String idUsuario) throws Exception{
        if(idUsuario.equals("admin"))
            throw new Exception("No se puede eliminar al usuario admin");

        for (Usuario u : usuarios){
            if (u.getIdUsuario().equals(idUsuario)){
                usuarios.remove(u);
                return;
            }
        }

        throw new Exception("No se encontro el Usuario con Id: " + idUsuario);
    }

    public void modificarUsuario(Usuario usuario) throws Exception
    {
        if (!existeUsuario(usuario.getIdUsuario()))
            throw new Exception("El usuario con id: "+ usuario.getIdUsuario() + " no se encuentra registrado");
        for (Usuario u: usuarios) {
            if (u.getIdUsuario().equals(usuario.getIdUsuario())){
                u.setContrasena(usuario.getContrasena());
                u.setNombreCompleto(usuario.getNombreCompleto());
                u.setRol(usuario.getRol());
            }
        }
    }

    public boolean existeUsuario(String idUsuario)
    {
        for (Usuario u: usuarios) {
            if (u.getIdUsuario().equals(idUsuario))
                return true;
        }

        return false;
    }
    public List<Usuario> listarUsuarios()
    {
        return usuarios;
    }
    public  boolean verificarCredenciales(String idUsario, String contrasenia) throws Exception{
        for (Usuario u : usuarios) {
            if (u.getIdUsuario().equals(idUsario) && u.getContrasena().equals(contrasenia)) {
                usuarioActual = u;
                return true;
            }
        }
        throw new Exception("Usario o Contraseña incorrectos");
    }

    public Usuario getUsuarioActual(){
        return usuarioActual;
    }
}
