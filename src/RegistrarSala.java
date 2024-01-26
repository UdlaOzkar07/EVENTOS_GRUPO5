import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarSala extends JDialog {
    private JPanel RegistrarSala;
    private JTextField txtIdSala_S;
    private JTextField txtEquipamiento_S;
    private JTextField txtUbicacion_S;
    private JSpinner spCapacidad_S;
    private JLabel lblIdSala_S;
    private JLabel lblEquipamiento_S;
    private JLabel lblCapacidad;
    private JLabel lblUbicacion_S;
    private JButton btnGuardar_S;
    private JButton btnCancelar_S;
    public RegistrarSala(SalaMngt salas,String idSala) {
        initializeJFrame();

        if(idSala != "")
        {
            txtIdSala_S.setEditable(false);
            try {
                inicializeFields(salas.obtenerSala(idSala));
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
        btnGuardar_S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Sala sala = new Sala(txtIdSala_S.getText(),Integer.parseInt(spCapacidad_S.getValue().toString()),txtEquipamiento_S.getText(),txtEquipamiento_S.getText());
                    if(idSala == ""){
                        salas.agregarSala(sala);
                        JOptionPane.showMessageDialog(null, "Sala registrado correctamente");
                        dispose();
                    }
                    else {
                        salas.modificarSala(sala);
                        JOptionPane.showMessageDialog(null, "Sala modificada correctamente");
                        dispose();
                    }
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnCancelar_S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void initializeJFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Sala");
        setContentPane(RegistrarSala);
        setModal(true);
        getRootPane().setDefaultButton(btnGuardar_S);

        setSize(700, 300);
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
        setResizable(false);
    }

    private void inicializeFields(Sala editarSala)
    {
        txtIdSala_S.setText(editarSala.getIdSala());
        txtEquipamiento_S.setText(editarSala.getEquipamiento());
        txtUbicacion_S.setText(editarSala.getUbicacion());
        spCapacidad_S.setValue (editarSala.getCapacidad());
    }
}
