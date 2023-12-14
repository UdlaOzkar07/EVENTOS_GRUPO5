import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
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
    private UsuarioMngt usuarios;

    public Login(UsuarioMngt usuarios) {
        this.usuarios = usuarios;
        initializeJFrame();
        btnInciarSesion_L.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idUsario = txtUsuario_L.getText();
                String contrasenia = txtContrasena_L.getText();
                try {
                    if (usuarios.verificarCredenciales(idUsario, contrasenia)) {
                        dispose();
                        if (usuarios.getUsuarioActual().getRol() == "Administrador") {
                            AdminMain adminapp = new AdminMain(usuarios);
                        }else{
                            JOptionPane.showMessageDialog(null, "Bienvenido Invitado!!");
                        }
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    private void initializeJFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Login");
        setContentPane(Login);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,400);
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x,y);
        setResizable(false);
        setVisible(true);
    }
}
