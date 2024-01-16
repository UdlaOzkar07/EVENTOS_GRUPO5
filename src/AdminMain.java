import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;

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
    private JButton ASIGNARPROCESOButton;
    private JButton ASIGNAPROCESOButton;
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
    private JTextField txtUbicacion_S;
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
    private JButton btnModificar_A;
    private JButton btnEliminar_A;
    private JTextField txtCedula_A;
    private JTextField txtNombre_A;
    private JTextField txtApellido_A;
    private JSpinner spEdad;
    private JTextField txtCorreo_A;
    private JTextField txtTelefono_A;
    private JTextField txtDireccion_A;
    private JLabel lblCedula_A;
    private JLabel lblNombre_A;
    private JLabel lblApellido_A;
    private JLabel lvlEdad_A;
    private JLabel lblCorreo_A;
    private JLabel lblTelefono_A;
    private JLabel lblDireccion_A;
    private JButton btnModificar_E;
    private JButton btnEliminar_E;
    private JTextField txtIdEvento_E;
    private JTextField txtDescripcion_E;
    private JComboBox cbxTipo_E;
    private JComboBox cbxEstado_E;
    private JTextField txtFecha_E;
    private JTextField txtHoraInicio_E;
    private JTextField txtHorafin_E;
    private JButton btnModificar_O;
    private JButton btnEliminar;
    private JTextField txtCedula_O;
    private JTextField txtNombre_O;
    private JTextField txtApellido_O;
    private JTextField txtTituloPro_O;
    private JTextField txtCorreo_O;
    private JTextField txtTelefono_O;
    private JTextField txtDireccion_O;
    private JLabel lblCedula_O;
    private JLabel lblNombre_O;
    private JLabel lblApellido_O;
    private JLabel lblTituloPro_O;
    private JLabel lblCorreo_O;
    private JLabel lblTelefono_O;
    private JLabel lblDireccion_O;
    private UsuarioMngt usuarios;
    private OradorMngt oradores = new OradorMngt();
    private AsistenteMngt asistentes = new AsistenteMngt();
    private SalaMngt salas = new SalaMngt();
    private EventoMngt eventos = new EventoMngt();

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
        btnRegistrarAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    initializeJTableAsistente();
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        REGISTRARORADORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    initializeJTableOrador();
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnModificar_O.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Orador orador = new Orador("","",txtCedula_O.getText(),txtNombre_O.getText(),txtApellido_O.getText(),txtCorreo_O.getText(),txtTelefono_O.getText(),txtDireccion_O.getText(),txtTituloPro_O.getText());
                    oradores.modificarOrador(orador);
                    initializeJTableOrador();
                    JOptionPane.showMessageDialog(null,"Orador modificado correctamente");
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
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
        btnModificar_A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Asistente asistente = new Asistente("","",txtCedula_A.getText(),txtNombre_A.getText(),txtApellido_A.getText(),Integer.parseInt(spEdad.getValue().toString()),txtCorreo_A.getText(),txtTelefono_A.getText(),txtDireccion_A.getText());
                    asistentes.modificarAsistente(asistente);
                    initializeJTableAsistente();
                    JOptionPane.showMessageDialog(null,"Asistente modificado correctamente");
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
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
        btnAgregar_S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Sala sala = new Sala(txtIdSala_S.getText(),Integer.parseInt(spCapacidad_S.getValue().toString()),txtEquipamiento_S.getText(),txtUbicacion_S.getText(),true);
                    salas.agregarSala(sala);
                    initializeJTableSala();
                    JOptionPane.showMessageDialog(null,"Sala creada correctamente");
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnModificar_S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Sala sala = new Sala(txtIdSala_S.getText(),Integer.parseInt(spCapacidad_S.getValue().toString()),txtEquipamiento_S.getText(),txtUbicacion_S.getText(),true);
                    salas.modificarSala(sala);
                    initializeJTableSala();
                    JOptionPane.showMessageDialog(null,"Sala modificada correctamente");
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
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
                try {
                    Evento evento = new Evento(txtIdEvento_E.getText(),txtNombre_A.getText(),txtDescripcion_E.getText(),cbxTipo_E.getSelectedItem().toString(), Date.valueOf(txtFecha_E.getText()), Time.valueOf(txtHoraInicio_E.getText()),Time.valueOf(txtHorafin_E.getText()),Integer.parseInt(spCapacidad_S.getValue().toString()),cbxEstado_E.getSelectedItem().toString(),txtIdEvento_E.getText());
                    eventos.modificarEvento(evento);
                    initializeJTableEvento();
                    JOptionPane.showMessageDialog(null,"Evento modificado correctamente");
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
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
        jtOradores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                if(e.getClickCount() == 2) {
                    txtCedula_O.setText(jtOradores.getValueAt(jtOradores.getSelectedRow(), 0).toString());
                    txtNombre_O.setText(jtOradores.getValueAt(jtOradores.getSelectedRow(), 1).toString());
                    txtApellido_O.setText(jtOradores.getValueAt(jtOradores.getSelectedRow(), 2).toString());
                    txtCorreo_O.setText(jtOradores.getValueAt(jtOradores.getSelectedRow(), 3).toString());
                    txtTelefono_O.setText(jtOradores.getValueAt(jtOradores.getSelectedRow(), 4).toString());
                    txtDireccion_O.setText(jtOradores.getValueAt(jtOradores.getSelectedRow(), 5).toString());
                    txtTituloPro_O.setText(jtOradores.getValueAt(jtOradores.getSelectedRow(), 6).toString());
                }
            }
        });
        jtAsistentes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        jtSalas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        jtEventos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        REGISTRAREVENTOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarEvento nuevoEvento = new RegistrarEvento(eventos,salas,oradores);
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
        asistenteModel.addColumn("Edad");
        asistenteModel.addColumn("Correo");
        asistenteModel.addColumn("Telefono");
        asistenteModel.addColumn("Direccion");

        asistenteModel.setRowCount(0);

        for (Asistente a : asistentes.listarAsistentes()) {
            asistenteModel.addRow(new Object[]{a.getCedula(),a.getNombre(),a.getApellido(),a.getEdad(),a.getCorreo(),a.getTelefono(),a.getDireccion()});
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
            salaModel.addColumn("Disponible");

            salaModel.setRowCount(0);

            for (Sala s : salas.listarSalas()) {
                salaModel.addRow(new Object[]{s.getIdSala(),s.getCapacidad(),s.getEquipamiento(),s.getUbicacion(),s.isDispoble()});
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
        eventoModel.addColumn("Hora Inicio");
        eventoModel.addColumn("Hora Fin");
        eventoModel.addColumn("Estado");

        eventoModel.setRowCount(0);

        for (Evento e : eventos.listarEventos()) {
            eventoModel.addRow(new Object[]{e.getIdEvento(),e.getNombre(),e.getDescripcion(),e.getTipoEvento(),e.getCupoMaximo(),e.getFecha(),e.getHorainicio(),e.getHorafin(),e.getEstado()});
        }

        jtEventos.setModel(eventoModel);
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
