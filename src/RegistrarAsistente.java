import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class RegistrarAsistente extends JDialog{
    private JPanel jpEvento;
    private JLabel lblIdEvento_E;
    private JTextField txtCedula_A;
    private JLabel lblNombre_E;
    private JTextField txtNombre_A;
    private JLabel lblD_E;
    private JTextField txtApellido_A;
    private JLabel lblFechaNacimiento_A;
    private JTextField txtTelefono_A;
    private JLabel lblFecha_E;
    private JLabel lblHoraInicio_E;
    private JTextField txtDireccion_A;
    private JLabel lblHoraFin_E;
    private JTextField txtCorreo_A;
    private JTextField txtFechaNacimiento_A;
    private JButton btnCancelar_A;
    private JButton btnGuardar_A;
    private JPanel RegistrarAsistente;
    private JTextField txtIdUsuario_A;
    private JTextField txtContrasena_A;
    private JLabel lblContrasena_A;
    private JLabel lblaforo_E;
    private JLabel lblIdUsuario_A;
    private JTextField txtEdad_A;
    private JButton btnRegistrar_A;

    public RegistrarAsistente(AsistenteMngt asistentes,String cedula) {
        initializeJFrame();

        if(cedula != "")
        {
            txtCedula_A.setEditable(false);
            btnGuardar_A.setText("Editar");

            try{
                inicializeFields(asistentes.obtenerAsistentePorCedula(cedula));
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }

        btnCancelar_A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnGuardar_A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Asistente asistente = new Asistente(txtIdUsuario_A.getText(),
                            txtContrasena_A.getText(),
                            txtCedula_A.getText(),
                            txtNombre_A.getText(),
                            txtApellido_A.getText(),
                            Date.valueOf(txtFechaNacimiento_A.getText()),
                            txtCorreo_A.getText(),
                            txtTelefono_A.getText(),
                            txtDireccion_A.getText());
                    if(cedula == "")
                    {
                        asistentes.agregarAsistente(asistente);
                        JOptionPane.showMessageDialog(null, "Asistente creado correctamente");
                        dispose();
                    }
                    else{
                        asistentes.modificarAsistente(asistente);
                        JOptionPane.showMessageDialog(null, "Asistente modificado correctamente");
                        dispose();
                    }
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
    private void initializeJFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Asistente");
        setContentPane(RegistrarAsistente);
        setModal(true);
        getRootPane().setDefaultButton(btnGuardar_A);
        setSize(700, 300);
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
        setResizable(false);
    }

    private void inicializeFields(Asistente editarAsistente)
    {
        txtCedula_A.setText(editarAsistente.getCedula());
        txtNombre_A.setText(editarAsistente.getNombre());
        txtApellido_A.setText(editarAsistente.getApellido());
        txtCorreo_A.setText(editarAsistente.getCorreo());
        txtDireccion_A.setText(editarAsistente.getDireccion());
        txtTelefono_A.setText(editarAsistente.getTelefono());
        txtEdad_A.setText(editarAsistente.getFechaNacimiento().toString());
        txtIdUsuario_A.setText(editarAsistente.getIdUsuario());
        txtContrasena_A.setText(editarAsistente.getContrasena());
    }
}
