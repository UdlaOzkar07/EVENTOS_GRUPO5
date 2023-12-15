import javax.swing.*;

public class Aplicacion {
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{

            try {
                UsuarioMngt usuarios = new UsuarioMngt();
                usuarios.agregarUsuario(new Usuario("admin","admin","Adminitrador","Administrador"));
                usuarios.agregarUsuario(new Usuario("orador","orador","Orador","Orador"));
                Login login = new Login(usuarios);
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        });
    }

}
