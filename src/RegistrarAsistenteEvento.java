import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrarAsistenteEvento extends JDialog {
    private JTable jtAsistenteEvento;
    private JTextField txtIdEvento_AE;
    private JComboBox cbxIdAsistente_AE;
    private JScrollPane scrollAsistenteEvento;
    private JLabel lbEventto_AE;
    private JLabel lblIdAsistente_AE;
    private JButton btnRegistrar_AE;
    private JPanel RegistrarAsistenteEvento;
    private JButton btnCancelar_AE;

    public RegistrarAsistenteEvento(AsistenteEventoMngt asitenteEventos, EventoMngt eventos, AsistenteMngt asistentes) {
        initializeJFrame();
        inicializarCbxAsistente(asistentes);
        initializeJTableEvento(eventos);
        txtIdEvento_AE.setEditable(false);
        btnRegistrar_AE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Evento evento = eventos.obtenerEvento(txtIdEvento_AE.getText());
                    Asistente asistente = asistentes.obtenerAsistentePorCedula(cbxIdAsistente_AE.getSelectedItem().toString());
                    AsistenteEvento nuevoAsistenteE = new AsistenteEvento(evento,asistente);
                    asitenteEventos.agregarAsistenteEvento(nuevoAsistenteE);
                    JOptionPane.showMessageDialog(null,"Asistente registrado al evento correctamente");
                    dispose();
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

            }
        });
        btnCancelar_AE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        jtAsistenteEvento.addMouseListener(new MouseAdapter() {
        });

        jtAsistenteEvento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                if(e.getClickCount() == 2) {
                    txtIdEvento_AE.setText(jtAsistenteEvento.getValueAt(jtAsistenteEvento.getSelectedRow(), 0).toString());
                }
            }
        });
    }

    public void inicializarCbxAsistente(AsistenteMngt asistentes)
    {
        cbxIdAsistente_AE.addItem("");
        for (Asistente a: asistentes.listarAsistentes()) {
            cbxIdAsistente_AE.addItem(a.getCedula());
        }
    }

    private void initializeJTableEvento(EventoMngt eventos){
        DefaultTableModel eventoModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        eventoModel.addColumn("Id. Evento");
        eventoModel.addColumn("Nombre del Evento");
        eventoModel.addColumn("Descripcion del Evento");
        eventoModel.addColumn("Tipo");
        eventoModel.addColumn("Aforo permitido");
        eventoModel.addColumn("Fecha evento");
        eventoModel.addColumn("Estado");

        eventoModel.setRowCount(0);

        for (Evento e : eventos.listarEventos()) {
            if (!e.getEstado().equals("Finalizado"))
                eventoModel.addRow(new Object[]{e.getIdEvento(),e.getNombre(),e.getDescripcion(),e.getTipoEvento(),e.getCupoMaximo(),e.getFecha(),e.getEstado()});
        }

        jtAsistenteEvento.setModel(eventoModel);
    }

    private void initializeJFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Eventos");
        setContentPane(RegistrarAsistenteEvento);
        setModal(true);
        getRootPane().setDefaultButton(btnRegistrar_AE);

        setSize(700,400);
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x,y);
        setResizable(false);
    }
}
