import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EventoEstado extends JDialog{
    private JPanel BuscarEventoEstado;
    private JTable jtEventoEstado;
    private JButton btnBuscar_EE;
    private JComboBox cbxEvEstado;
    private JLabel lblEstadoEvento;
    public EventoEstado(EventoMngt eventos) {
        initializeJFrame();
        initializeJTableEvento(new ArrayList<Evento>());

        btnBuscar_EE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String estado = cbxEvEstado.getSelectedItem().toString();
                if (estado != "")
                {
                    initializeJTableEvento(eventos.buscarEventoEstado(estado));
                }
            }
        });
    }

    private void initializeJFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Eventos por estado");
        setContentPane(BuscarEventoEstado);
        setModal(true);
        getRootPane().setDefaultButton(btnBuscar_EE);

        setSize(700,400);
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x,y);
        setResizable(false);
    }

    private void initializeJTableEvento(List<Evento> eventosList){
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

        for (Evento e : eventosList) {
            eventoModel.addRow(new Object[]{e.getIdEvento(),e.getNombre(),e.getDescripcion(),e.getCategorias(),e.getCupoMaximo(),e.getFecha(),e.getEstado()});
        }

        jtEventoEstado.setModel(eventoModel);
    }
}
