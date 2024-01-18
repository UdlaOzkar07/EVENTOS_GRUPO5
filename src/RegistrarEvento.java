import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarEvento extends JFrame{
    private JPanel RegistrarEvento;
    private JButton btnCancelar_E;
    private JButton btnRegistrar_E;
    private JLabel lblIdEvento_E;
    private JTextField txtIdEvento_E;
    private JTextField txtNombre_E;
    private JLabel lblNombre_E;
    private JLabel lblaforo_E;
    private JSpinner spAforo_E;
    private JTextField txtFecha_E;
    private JLabel lblFecha_E;
    private JLabel lblDescripcion_E;
    private JTextField txtDescripcion_E;
    private JComboBox cbxTipo_E;
    private JLabel lblTipo_E;
    private JComboBox cbxEstado_E;
    private JLabel lblEstado_E;
    private JLabel lblHoraInicio_E;
    private JTextField txtHoraInicio_E;
    private JLabel lblHoraFin_E;
    private JTextField txtHorafin_E;
    private JPanel jpEvento;
    private JPanel jpSalas;
    private JComboBox cbxSalas_E;
    private JLabel lblSala_E;
    private JComboBox cbxIdOrador_E;
    private JLabel lblIdOrador_E;
    private JTextField txtNombreO_E;
    private JLabel lblNombreO_E;
    EventoMngt eventos;
    SalaMngt salas;
    OradorMngt oradores;

    public RegistrarEvento(EventoMngt eventos, SalaMngt salas, OradorMngt oradores) {
        this.eventos = eventos;
        this.salas = salas;
        this.oradores = oradores;
        initializeJFrame();
        inicializarCbxSalas();
        inicializarCbxOrador();
        btnCancelar_E.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cbxIdOrador_E.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = cbxIdOrador_E.getSelectedItem().toString();
                txtNombreO_E.setText("");
                if (cedula != "")
                {
                    try {
                        Orador orador = oradores.obtenerOradorPorCedula(cedula);
                        txtNombreO_E.setText(orador.getNombre() + " " + orador.getApellido());
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
            }
        });
        btnRegistrar_E.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void inicializarCbxSalas()
    {
        cbxSalas_E.addItem("");
        for (Sala s: salas.listarSalas()) {
            cbxSalas_E.addItem(s.getIdSala());
        }
    }

    public void inicializarCbxOrador()
    {
        cbxIdOrador_E.addItem("");
        for (Orador o: oradores.listarOradores()) {
            cbxIdOrador_E.addItem(o.getCedula());
        }
    }

    private void initializeJFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Registrar eventos");
        setContentPane(RegistrarEvento);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,400);
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x,y);
        setResizable(false);
        setVisible(true);
    }
}
