import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminMain extends JFrame{
    private JTabbedPane tpAdminApp;
    private JPanel Admin;
    private JPanel jpHome;
    private JPanel jpOrador;
    private JPanel jpEvento;
    private JPanel jpAsistente;
    private JPanel jpSala;
    private JPanel jpUsuario;
    private JTable jtUsuarios;
    private JScrollPane spUsuarios;
    private JPanel jpUsuariosTable;
    private JPanel JpUsuarios;
    private JTable jtOradores;
    private JPanel jpOradores;
    private JPanel jpOradoresTable;
    private JScrollPane jspOradores;
    private JTable jtAsistentes;
    private JPanel jpAsistentes;
    private JPanel jpAsistentesTable;
    private JScrollPane jspAsistentes;
    private JTable jtSalas;
    private JScrollPane jspSalas;
    private JPanel jpSalasTable;
    private JPanel jpSalas;
    private JTable jtEventos;
    private JPanel jpEventos;
    private JPanel jpEventosTable;
    private JScrollPane jspEventos;
    private JButton btnEliminarUsuario;
    private JButton btnModificarUsuario;
    private JPanel jpUsuarioField;
    private JLabel lblLogoInicio;
    private JPanel jpLogoInicion;
    private JButton CREAREVENTOButton;
    private JButton CANCELAREVENTOButton;
    private JButton VEREVENTOSButton;
    private JButton ASIGNARSALAButton;
    private JButton ASIGNARORADORButton;
    private JButton REGISTRARASISTENTEButton1;
    private JButton btnSalir;
    private JPanel jpUsuarioFieldCol1;
    private JTextField txtIdUsuario_U;
    private JTextField txtContrasena_U;
    private JTextField txtNombreCompleto_U;
    private JComboBox cbxRol_U;
    private JLabel lblIdUsuario_U;
    private JLabel lblContrasena_U;
    private JPanel jpUsuarioFieldCol2;
    private JLabel lblNombreCompleto_U;
    private JLabel lblRol_U;
    private JButton btnGuardar_U;
    private JPanel jpSalasFields;
    private JButton btnAgregar_S;
    private JButton btnModificar_S;
    private JButton btnEliminar_S;
    private JTextField txtIdSala_S;
    private JTextField textField2;
    private JPanel jpSalasColm1;
    private JPanel jpSalasColm2;
    private JLabel lblIdSala_S;
    private JTextField txtEquipamiento_S;
    private JLabel lblEquipamiento_S;
    private JSpinner spCapacidad_S;
    private JLabel lblCapacidad_S;
    private JLabel lblUbicacion_S;
    private JLabel lblDisponibilidad;
    private JRadioButton rdDisponibilidad_S;
    private JRadioButton rbDisponibilidadN_S;
    private UsuarioMngt usuarios;
    private SalaMngt salas;

    public AdminMain(UsuarioMngt usuarios) {
        this.usuarios = usuarios;
        initializeJFrame();
        initializeJTableUsuario();
        initializeJTableSala();
        btnEliminarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jtUsuarios.getSelectedRow();
                if (selectedRow != -1){
                    try {
                        usuarios.eliminarUsuario(jtUsuarios.getValueAt(selectedRow, 0).toString());
                        initializeJTableUsuario();
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Seleccione un usuario");
                }
            }
        });
        btnModificarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Usuario usuario = new Usuario(txtIdUsuario_U.getText(),txtContrasena_U.getText(),txtNombreCompleto_U.getText(),cbxRol_U.getSelectedItem().toString());
                    usuarios.modificarUsuario(usuario);
                    initializeJTableUsuario();
                    resetFieldUsuario();
                    JOptionPane.showMessageDialog(null,"Usuario modificado correctamente");
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnGuardar_U.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Usuario usuario = new Usuario(txtIdUsuario_U.getText(),txtContrasena_U.getText(),txtNombreCompleto_U.getText(),cbxRol_U.getSelectedItem().toString());
                    usuarios.agregarUsuario(usuario);
                    initializeJTableUsuario();
                    resetFieldUsuario();
                    JOptionPane.showMessageDialog(null,"Usuario creado correctamente");
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        jtUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    txtIdUsuario_U.setText(jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 0).toString());
                    txtContrasena_U.setText(jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 1).toString());
                    txtNombreCompleto_U.setText(jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 2).toString());
                    cbxRol_U.setSelectedItem(jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 3).toString());
                }
            }
        });
    }

    private void initializeJTableUsuario(){
        DefaultTableModel  usuarioModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        usuarioModel.addColumn("Id. Usario");
        usuarioModel.addColumn("Contraseña");
        usuarioModel.addColumn("Nombre completo");
        usuarioModel.addColumn("Rol");

        usuarioModel.setRowCount(0);

        for (Usuario u : usuarios.listarUsuarios()) {
            usuarioModel.addRow(new Object[]{u.getIdUsuario(),u.getContrasena(),u.getNombreCompleto(),u.getRol()});
        }

        jtUsuarios.setModel(usuarioModel);
    }
    private void resetFieldUsuario()
    {
        txtIdUsuario_U.setText("");
        txtNombreCompleto_U.setText("");
        txtContrasena_U.setText("");
        cbxRol_U.setSelectedIndex(0);
    }

    private void initializeJTableSala(){
        try {
            salas = new SalaMngt();
            salas.agregarSala(new Sala("001",50,"Proyector, Control, Computador","Planta Baja",true));
            salas.agregarSala(new Sala("002",100,"Proyector, Control, Computador","Segundo Piso",false));

            DefaultTableModel  salaModel = new DefaultTableModel();

            salaModel.addColumn("Id. Sala");
            salaModel.addColumn("Capacidad");
            salaModel.addColumn("Equipamiento");
            salaModel.addColumn("Ubicacion");
            salaModel.addColumn("Disponible");

            salaModel.setRowCount(0);

            for (Sala s : salas.listarSalas()) {
                salaModel.addRow(new Object[]{s.getIdSala(),s.getCapacidad(),s.getEquipamiento(),s.getUbicacion(),s.isDispoble()});
            }

            jtSalas.setModel(salaModel);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }

    }

    private void initializeJFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Administración de eventos");
        setContentPane(Admin);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,600);
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x,y);
        setResizable(false);
        setVisible(true);
    }
}
