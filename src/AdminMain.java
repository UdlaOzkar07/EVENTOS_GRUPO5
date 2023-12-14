import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JPanel jpSalesTable;
    private JPanel jpSalas;
    private JTable jtEventos;
    private JPanel jpEventos;
    private JPanel jpEventosTable;
    private JScrollPane jspEventos;
    private JButton btnEliminarUsuario;
    private JButton btnModificarUsuario;
    private JPanel jpUsuarioField;
    private JTextField txtIdUsuarui_U;
    private JTextField txtNombre_U;
    private JTextField txtApellido_U;
    private JTextField txtCorreo_U;
    private JLabel lblIdUsuario_U;
    private JLabel lblNombre_U;
    private JLabel lblApellido_U;
    private JLabel lblCorreo_U;
    private JLabel lblLogoInicio;
    private JPanel jpLogoInicion;
    private JButton CREAREVENTOButton;
    private JButton CANCELAREVENTOButton;
    private JButton VEREVENTOSButton;
    private JButton ASIGNARSALAButton;
    private JButton ASIGNARORADORButton;
    private JButton REGISTRARASISTENTEButton1;
    private JButton btnSalir;
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
                    Usuario usuario = new Usuario(txtIdUsuarui_U.getText(),"","",txtNombre_U.getText(),txtApellido_U.getText(),txtCorreo_U.getText(),"");
                    usuarios.modificarUsuario(usuario);
                    initializeJTableUsuario();
                    JOptionPane.showMessageDialog(null,"Usuario modificado correctamente");
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    private void initializeJTableUsuario(){
        DefaultTableModel  usuarioModel = new DefaultTableModel();

        usuarioModel.addColumn("Id. Usario");
        usuarioModel.addColumn("Contraseña");
        usuarioModel.addColumn("Rol");
        usuarioModel.addColumn("Nombre");
        usuarioModel.addColumn("Apellido");
        usuarioModel.addColumn("Correo");
        usuarioModel.addColumn("Preferencias");

        usuarioModel.setRowCount(0);

        for (Usuario u : usuarios.listarUsuarios()) {
            usuarioModel.addRow(new Object[]{u.getId(),u.getContrasenia(),u.getRol(),u.getNombre(),u.getApellido(),u.getCorreo(),u.getPreferencias()});
        }

        jtUsuarios.setModel(usuarioModel);
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
