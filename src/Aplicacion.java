import javax.swing.*;

public class Aplicacion {
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
            UsuarioList usuarios = new UsuarioList();
            Login login = new Login(usuarios);
        });
    }

}
