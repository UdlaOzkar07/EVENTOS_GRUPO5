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
    private JButton REGISTRARORADORButton;
    private JButton btnRegistrarAsistente;
    private JButton REGISTRAREVENTOButton;
    private JButton REGISTRARSALASButton;
    private JButton INSCRIBIRASISTENTEAEVENTOButton;
    private JButton asignarProcesoButton;
    private JButton btnSalir;
    private JPanel jpUsuarioFieldCol1;
    private JTextField txtIdUsuario_U;
    private JTextField txtContrasena_U;
    private JTextField txtNombreCompleto_U;
    private JLabel lblIdUsuario_U;
    private JLabel lblContrasena_U;
    private JPanel jpUsuarioFieldCol2;
    private JLabel lblNombreCompleto_U;
    private JButton btnGuardar_U;
    private JButton btnAgregar_S;
    private JButton btnModificar_S;
    private JButton btnEliminar_S;
    private JTextField txtIdSala_S;
    private JTextField txtUbicacion_S;
    private JTextField txtEquipamiento_S;
    private JSpinner spCapacidad_S;
    private JButton btnEditar_A;
    private JButton btnEliminar_A;
    private JButton btnModificar_E;
    private JButton btnEliminar_E;
    private JTextField txtIdEvento_E;
    private JTextField txtDescripcion_E;
    private JComboBox cbxTipo_E;
    private JComboBox cbxEstado_E;
    private JTextField txtFecha_E;
    private JTextField txtHoraInicio_E;
    private JTextField txtHorafin_E;
    private JButton btnEditar_O;
    private JButton btnEliminar;
    private JTextField txtEmail_U;
    private JLabel lblEmail_U;
    private UsuarioMngt usuarios;
    private OradorMngt oradores = new OradorMngt();
    private AsistenteMngt asistentes = new AsistenteMngt();
    private SalaMngt salas = new SalaMngt();
    private EventoMngt eventos = new EventoMngt();
    private AsistenteEventoMngt asistenteEventos = new AsistenteEventoMngt();

    public AdminMain(UsuarioMngt usuarios) {
        this.usuarios = usuarios;
        initializeJFrame();
        initializeJTableUsuario();
        initializeJTableOrador();
        initializeJTableAsistente();
        initializeJTableSala();
        initializeJTableEvento();
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
                    Usuario usuario = new Usuario(txtIdUsuario_U.getText(),txtContrasena_U.getText(),txtNombreCompleto_U.getText(),txtEmail_U.getText(),"Administrador");
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
                    Usuario usuario = new Usuario(txtIdUsuario_U.getText(),txtContrasena_U.getText(),txtNombreCompleto_U.getText(),txtEmail_U.getText(),"Administrador");
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
                    txtEmail_U.setText(jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(),3).toString());
                }
            }
        });
        REGISTRARORADORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarOrador nuevoOrador = new RegistrarOrador(oradores, "");
                nuevoOrador.pack();
                nuevoOrador.setVisible(true);
                initializeJTableOrador();
            }
        });
        btnEditar_O.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jtOradores.getSelectedRow();
                if (selectedRow != -1) {
                    String cedula = jtOradores.getValueAt(jtOradores.getSelectedRow(), 0).toString();

                    RegistrarOrador nuevoOrador = new RegistrarOrador(oradores, cedula);
                    nuevoOrador.pack();
                    nuevoOrador.setVisible(true);
                    initializeJTableOrador();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Seleccione un orador");
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jtOradores.getSelectedRow();
                if (selectedRow != -1){
                    try {
                        oradores.eliminarOrador(jtOradores.getValueAt(selectedRow, 0).toString());
                        initializeJTableOrador();
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Seleccione un orador");
                }
            }
        });
        btnEditar_A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jtAsistentes.getSelectedRow();
                if (selectedRow != -1) {
                    String cedula = jtAsistentes.getValueAt(jtAsistentes.getSelectedRow(), 0).toString();

                    RegistrarAsistente nuevoAsistente = new RegistrarAsistente(asistentes,cedula);
                    nuevoAsistente.pack();
                    nuevoAsistente.setVisible(true);
                    initializeJTableAsistente();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Seleccione un asistente");
                }
            }
        });
        btnEliminar_A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jtAsistentes.getSelectedRow();
                if (selectedRow != -1){
                    try {
                        asistentes.eliminarAsistente(jtAsistentes.getValueAt(selectedRow, 0).toString());
                        initializeJTableAsistente();
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Seleccione un asistente");
                }
            }
        });
        btnModificar_S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jtSalas.getSelectedRow();
                if (selectedRow != -1){
                    String idSala = jtSalas.getValueAt(selectedRow, 0).toString();
                    RegistrarSala nuevaSala = new RegistrarSala(salas,idSala);
                    nuevaSala.pack();
                    nuevaSala.setVisible(true);
                    initializeJTableSala();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Seleccione una sala");
                }
            }
        });
        btnEliminar_S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jtSalas.getSelectedRow();
                if (selectedRow != -1){
                    try {
                        salas.eliminarSala(jtSalas.getValueAt(selectedRow, 0).toString());
                        initializeJTableSala();
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Seleccione una sala");
                }
            }
        });
        btnModificar_E.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jtEventos.getSelectedRow();
                if (selectedRow != -1){
                    String idEvento = jtEventos.getValueAt(selectedRow, 0).toString();
                    RegistrarEvento nuevoEvento = new RegistrarEvento(eventos,salas,oradores,idEvento);
                    nuevoEvento.pack();
                    nuevoEvento.setVisible(true);
                    initializeJTableEvento();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Seleccione un evento");
                }
            }
        });
        btnEliminar_E.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jtEventos.getSelectedRow();
                if (selectedRow != -1){
                    try {
                        eventos.eliminarEvento(jtEventos.getValueAt(selectedRow, 0).toString());
                        initializeJTableEvento();
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Seleccione un evento");
                }
            }
        });
        REGISTRAREVENTOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarEvento nuevoEvento = new RegistrarEvento(eventos,salas,oradores,"");
                nuevoEvento.pack();
                nuevoEvento.setVisible(true);
                initializeJTableEvento();
            }
        });
        btnRegistrarAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarAsistente nuevoAsistente = new RegistrarAsistente(asistentes,"");
                nuevoAsistente.pack();
                nuevoAsistente.setVisible(true);
                initializeJTableAsistente();
            }
        });
        REGISTRARSALASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarSala nuevaSala = new RegistrarSala(salas,"");
                nuevaSala.pack();
                nuevaSala.setVisible(true);
                initializeJTableSala();
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        INSCRIBIRASISTENTEAEVENTOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarAsistenteEvento inscribir = new RegistrarAsistenteEvento(asistenteEventos,eventos,asistentes);
                inscribir.pack();
                inscribir.setVisible(true);
                initializeJTableEvento();
            }
        });
        asignarProcesoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventoEstado buscarEvento = new EventoEstado(eventos);
                buscarEvento.pack();
                buscarEvento.setVisible(true);
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
        usuarioModel.addColumn("Corrreo");

        usuarioModel.setRowCount(0);

        for (Usuario u : usuarios.listarUsuarios()) {
            usuarioModel.addRow(new Object[]{u.getIdUsuario(),u.getContrasena(),u.getNombreCompleto(),u.getEmail()});
        }

        jtUsuarios.setModel(usuarioModel);
    }
    private void resetFieldUsuario()
    {
        txtIdUsuario_U.setText("");
        txtNombreCompleto_U.setText("");
        txtContrasena_U.setText("");
        txtEmail_U.setText("");
    }

    private void initializeJTableOrador(){
        DefaultTableModel  oaradorModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        oaradorModel.addColumn("Cedula");
        oaradorModel.addColumn("Nombre");
        oaradorModel.addColumn("Apellido");
        oaradorModel.addColumn("Titulo profesional");
        oaradorModel.addColumn("Correo");
        oaradorModel.addColumn("Telefono");
        oaradorModel.addColumn("Direccion");

        oaradorModel.setRowCount(0);

        for (Orador o : oradores.listarOradores()) {
            oaradorModel.addRow(new Object[]{o.getCedula(),o.getNombre(),o.getApellido(),o.getTitulo(),o.getCorreo(),o.getTelefono(),o.getDireccion()});
        }

        jtOradores.setModel(oaradorModel);
    }

    private void initializeJTableAsistente(){
        DefaultTableModel  asistenteModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        asistenteModel.addColumn("Cedula");
        asistenteModel.addColumn("Nombre");
        asistenteModel.addColumn("Apellido");
        asistenteModel.addColumn("Fecha nacimiento");
        asistenteModel.addColumn("Correo");
        asistenteModel.addColumn("Telefono");
        asistenteModel.addColumn("Direccion");

        asistenteModel.setRowCount(0);

        for (Asistente a : asistentes.listarAsistentes()) {
            asistenteModel.addRow(new Object[]{a.getCedula(),a.getNombre(),a.getApellido(),a.getFechaNacimiento(),a.getCorreo(),a.getTelefono(),a.getDireccion()});
        }

        jtAsistentes.setModel(asistenteModel);
    }

    private void initializeJTableSala(){
            DefaultTableModel  salaModel = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            salaModel.addColumn("Id. Sala");
            salaModel.addColumn("Capacidad");
            salaModel.addColumn("Equipamiento");
            salaModel.addColumn("Ubicacion");

            salaModel.setRowCount(0);

            for (Sala s : salas.listarSalas()) {
                salaModel.addRow(new Object[]{s.getIdSala(),s.getCapacidad(),s.getEquipamiento(),s.getUbicacion()});
            }

            jtSalas.setModel(salaModel);
    }

    private void initializeJTableEvento(){
        DefaultTableModel  eventoModel = new DefaultTableModel(){
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
        eventoModel.addColumn("Numero de Asistentes");

        eventoModel.setRowCount(0);

        for (Evento e : eventos.listarEventos()) {
            eventoModel.addRow(new Object[]{e.getIdEvento(),e.getNombre(),e.getDescripcion(),e.getCategorias(),e.getCupoMaximo(),e.getFecha(),e.getEstado(),eventos.contarAsistentes(asistenteEventos,e.getIdEvento())});
        }

        jtEventos.setModel(eventoModel);
    }

    private void initializeJFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Administración de eventos");
        setContentPane(Admin);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500,600);
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x,y);
        setResizable(false);
        setVisible(true);
    }
}
