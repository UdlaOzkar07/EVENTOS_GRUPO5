import java.util.ArrayList;
import java.util.List;

public class UsuarioList {
    private List<Usuario> usuarios;
    private Usuario usuarioActual;

    public UsuarioList() {
        this.usuarios = new ArrayList<Usuario>();
        inicializarUsuario();
    }

    private void inicializarUsuario(){
        usuarios.add(new Usuario("admin","admin","Administrador","","","",""));
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
