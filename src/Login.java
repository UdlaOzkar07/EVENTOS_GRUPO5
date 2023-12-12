import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JPanel Login;
    private JTextField txtUsuario_L;
    private JTextField txtContrasena_L;
    private JButton btnInciarSesion_L;
    private JPanel jpLogo_L;
    private JLabel lblLogo_L;
    private JPanel jpLogin_L;
    private JPanel jpField_L;
    private JLabel lblUsuario_L;
    private JLabel lblContrasena_L;

    private UsuarioList usuarios;

    public Login(UsuarioList usuarios) {
        this.usuarios = usuarios;
        initializeJFrame();
        btnInciarSesion_L.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idUsario = txtUsuario_L.getText();
                String contrasenia = txtContrasena_L.getText();
                try {
                    if (usuarios.verificarCredenciales(idUsario, contrasenia)) {
                        JOptionPane.showMessageDialog(null,"Bienvenidos!!");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    private void initializeJFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("Login");
        frame.setContentPane(Login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,400);
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x,y);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /*public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().Login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,400);
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x,y);
        frame.setResizable(false);
        frame.setVisible(true);
    }*/
}
