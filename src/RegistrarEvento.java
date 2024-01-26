import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class RegistrarEvento extends JDialog{
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
    private JPanel jpEvento;
    private JPanel jpSalas;
    private JComboBox cbxSalas_E;
    private JLabel lblSala_E;
    private JComboBox cbxIdOrador_E;
    private JLabel lblIdOrador_E;
    private JTextField txtNombreO_E;
    private JLabel lblNombreO_E;
    private JLabel lblCapacidad_E;
    private JTextField txtCapacidad_E;
    private SalaMngt salas;
    private OradorMngt oradores;

    public RegistrarEvento(EventoMngt eventos, SalaMngt salas, OradorMngt oradores,String idEvento) {
        this.salas = salas;
        this.oradores = oradores;

        initializeJFrame();
        inicializarCbxSalas(salas);
        inicializarCbxOrador(oradores);

        lblEstado_E.setVisible(false);
        cbxEstado_E.setVisible(false);

        if (idEvento != "")
        {
            txtIdEvento_E.setEditable(false);
            btnRegistrar_E.setText("Editar");
            try {
                inicializeFields(eventos.obtenerEvento(idEvento));
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
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
                try{
                    Evento evento = new Evento(txtIdEvento_E.getText(),
                            txtNombreO_E.getText(),
                            txtDescripcion_E.getText(),
                            cbxTipo_E.getSelectedItem().toString(),
                            Date.valueOf(txtFecha_E.getText()),
                            Integer.parseInt(spAforo_E.getValue().toString()),
                            cbxEstado_E.getSelectedItem().toString(),
                            cbxSalas_E.getSelectedItem().toString(),
                            cbxIdOrador_E.getSelectedItem().toString());

                    if (idEvento == "") {
                        eventos.agregarEvento(evento);
                        JOptionPane.showMessageDialog(null, "Evento registrado correctamente");
                        dispose();
                    }
                    else {
                        eventos.modificarEvento(evento);
                        JOptionPane.showMessageDialog(null, "Evento modificado correctamente");
                        dispose();
                    }
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

            }
        });
        cbxSalas_E.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idSala = cbxSalas_E.getSelectedItem().toString();
                if (idSala != ""){
                    try {
                        Sala sala = salas.obtenerSala(idSala);
                        txtCapacidad_E.setText(sala.getCapacidad().toString());
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
            }
        });
    }

    public void inicializarCbxSalas(SalaMngt salas)
    {
        cbxSalas_E.addItem("");
        for (Sala s: salas.listarSalas()) {
            cbxSalas_E.addItem(s.getIdSala());
        }
    }

    public void inicializarCbxOrador(OradorMngt oradores)
    {
        cbxIdOrador_E.addItem("");
        for (Orador o: oradores.listarOradores()) {
            cbxIdOrador_E.addItem(o.getCedula());
        }
    }

    private void initializeJFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Eventos");
        setContentPane(RegistrarEvento);
        setModal(true);
        getRootPane().setDefaultButton(btnRegistrar_E);

        setSize(700,400);
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x,y);
        setResizable(false);
    }

    private void inicializeFields(Evento editarEvento)
    {
        try {
            Orador orador = oradores.obtenerOradorPorCedula(editarEvento.getIdOrador());
            Sala sala = salas.obtenerSala(editarEvento.getIdSala());

            txtIdEvento_E.setText(editarEvento.getIdEvento());
            txtNombre_E.setText(editarEvento.getNombre());
            txtDescripcion_E.setText(editarEvento.getDescripcion());
            spAforo_E.setValue(editarEvento.getCupoMaximo());
            txtFecha_E.setText(editarEvento.getFecha().toString());
            cbxEstado_E.setSelectedItem(editarEvento.getEstado());
            cbxTipo_E.setSelectedItem(editarEvento.getTipoEvento());
            cbxIdOrador_E.setSelectedItem(orador.getCedula());
            txtNombreO_E.setText(orador.getNombre() + ' ' + orador.getApellido());
            cbxSalas_E.setSelectedItem(sala.getIdSala());
            txtCapacidad_E.setText(sala.getCapacidad().toString());
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }


    }
}
