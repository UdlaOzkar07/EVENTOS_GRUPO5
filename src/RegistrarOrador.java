import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarOrador extends JDialog{

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
    private JButton btnGuardar_O;
    private JPanel RegistrarOrador;
    private JButton btnCancelar_O;
    private JTextField txtIdUsuario_O;
    private JTextField txtContrasena_O;
    private JLabel lbIdUsuario_O;
    private JLabel lblContrasena_O;

    public RegistrarOrador(OradorMngt oradores, String cedula) {
        initializeJFrame();
        if(cedula != "") {
            btnGuardar_O.setText("Editar");
            txtCedula_O.setEditable(false);
            try {
                inicializeFields(oradores.obtenerOradorPorCedula(cedula));
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }

        btnCancelar_O.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnGuardar_O.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Orador orador = new Orador(txtIdUsuario_O.getText(),txtContrasena_O.getText(),txtCedula_O.getText(),txtNombre_O.getText(),txtApellido_O.getText(),txtCorreo_O.getText(),txtTelefono_O.getText(),txtDireccion_O.getText(),txtTitulo_O.getText());
                    if (cedula == "") {
                        oradores.agregarOrador(orador);
                        JOptionPane.showMessageDialog(null, "Orador registrado correctamente");
                    }
                    else
                    {
                        oradores.modificarOrador(orador);
                        JOptionPane.showMessageDialog(null, "Orador modificado correctamente");
                    }
                    dispose();
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    private void initializeJFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Orador");
        setContentPane(RegistrarOrador);
        setModal(true);
        getRootPane().setDefaultButton(btnGuardar_O);

        setSize(700, 300);
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
        setResizable(false);
    }

    private void inicializeFields(Orador editarOrador)
    {
        txtCedula_O.setText(editarOrador.getCedula());
        txtNombre_O.setText(editarOrador.getNombre());
        txtApellido_O.setText(editarOrador.getApellido());
        txtCorreo_O.setText(editarOrador.getCorreo());
        txtDireccion_O.setText(editarOrador.getDireccion());
        txtTelefono_O.setText(editarOrador.getTelefono());
        txtTitulo_O.setText(editarOrador.getTitulo());
        txtIdUsuario_O.setText(editarOrador.getIdUsuario());
        txtContrasena_O.setText(editarOrador.getContrasena());
    }
}
