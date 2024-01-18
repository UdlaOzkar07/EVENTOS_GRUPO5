import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarAsistente extends JFrame{
    private JPanel jpEvento;
    private JLabel lblIdEvento_E;
    private JTextField txtCedula_A;
    private JLabel lblNombre_E;
    private JTextField txtNombre_A;
    private JLabel lblD_E;
    private JTextField txtApellido_A;
    private JLabel lblaforo_E;
    private JTextField txtTelefono_A;
    private JLabel lblFecha_E;
    private JLabel lblHoraInicio_E;
    private JTextField txtDireccion_A;
    private JLabel lblHoraFin_E;
    private JTextField txtCorreo_A;
    private JTextField txtEdad_A;
    private JButton btnCancelar_A;
    private JButton btnRegistrar_A;
    private JPanel RegistrarAsistente;

    private AsistenteMngt asistente;

    public RegistrarAsistente(AsistenteMngt asistente) {
        initializeJFrame();
        this.asistente = asistente;


        btnCancelar_A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
    }
    private void initializeJFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Registrar Asistente");
        setContentPane(RegistrarAsistente);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 300);
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
        setResizable(false);
        setVisible(true);
    }
}
