import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarOrador extends JFrame{

    private JPanel jpEvento;
    private JLabel lblIdEvento_E;
    private JTextField txtCedula_O;
    private JLabel lblNombre_E;
    private JTextField txtNombre_O;
    private JLabel lblD_E;
    private JTextField txtApellido_O;
    private JLabel lblaforo_E;
    private JTextField txtTelefono_O;
    private JLabel lblFecha_E;
    private JLabel lblHoraInicio_E;
    private JTextField txtDireccion_O;
    private JLabel lblHoraFin_E;
    private JTextField txtTitulo_O;
    private JTextField txtCorreo_O;
    private JButton btnCancelar_E;
    private JButton btnRegistrar_O;
    private JPanel RegistrarOrador;

    private OradorMngt orador;

    public RegistrarOrador(OradorMngt orador) {
        this.orador = orador;
        initializeJFrame();

        btnCancelar_E.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void initializeJFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Registrar Orador");
        setContentPane(RegistrarOrador);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
        setResizable(false);
        setVisible(true);
    }


}
