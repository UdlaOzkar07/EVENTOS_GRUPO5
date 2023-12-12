import javax.swing.*;
import java.awt.*;

public class Login {
    private JPanel Login;
    private JTextField txtCorreo_L;
    private JTextField txtContrasena_L;
    private JButton btnInciarSesion_L;
    private JPanel jpLogo_L;
    private JLabel lblLogo_L;
    private JPanel jpLogin_L;
    private JPanel jpField_L;
    private JLabel lblCorreo_L;
    private JLabel lblContrasena_L;

    public static void main(String[] args) {
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
    }
}
