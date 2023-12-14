import java.util.ArrayList;
import java.util.List;

public class UsuarioMngt {
    private List<Usuario> usuarios;
    private Usuario usuarioActual;

    public UsuarioMngt() {
        this.usuarios = new ArrayList<Usuario>();
    }

    public void agregarUsuario(Usuario usuario) throws Exception{
        if (!existeUsuario(usuario.getId()))
        usuarios.add(usuario);
        else
            throw new Exception("Ya se encuentra registrado un Usuario con id: " + usuario.getId());
    }

    public void eliminarUsuario(String idUsuario) throws Exception{
        if(idUsuario.equals("admin"))
            throw new Exception("No se puede eliminar al usuario admin");

        for (Usuario u : usuarios){
            if (u.getId().equals(idUsuario)){
                usuarios.remove(u);
                return;
            }
        }

        throw new Exception("No se encontro el Usuario con Id: " + idUsuario);
    }

    public void modificarUsuario(Usuario usuario) throws Exception
    {
        if (!existeUsuario(usuario.getId()))
            throw new Exception("El usuario con id: "+ usuario.getId() + " no se encuentra registrado");
        for (Usuario u: usuarios) {
            if (u.getId().equals(usuario.getId())){
                u.setNombre(usuario.getNombre());
                u.setApellido(usuario.getApellido());
                u.setCorreo(usuario.getCorreo());
            }
        }
    }

    public boolean existeUsuario(String idUsuario)
    {
        for (Usuario u: usuarios) {
            if (u.getId().equals(idUsuario))
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
            if (u.getId().equals(idUsario) && u.getContrasenia().equals(contrasenia)) {
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
