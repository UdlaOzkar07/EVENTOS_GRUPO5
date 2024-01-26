import javax.swing.*;

public class Aplicacion {
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{

            try {
                UsuarioMngt usuarios = new UsuarioMngt();
                usuarios.agregarUsuario(new Usuario("admin","admin","Administrador", "admin@correo.com", "Administrador"));
                Login login = new Login(usuarios);
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        });
    }

}
