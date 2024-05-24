package presentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidad.Persona;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelModificar extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDni;
    private JButton btnModificar;
    
    private JList<Persona> listPersonas;
    private DefaultListModel<Persona> listModel;
    
    public PanelModificar() {
        
        listModel = new DefaultListModel<>();
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(186, 44, 200, 295);
        add(scrollPane);
        
                listPersonas = new JList<>(listModel);
                scrollPane.setViewportView(listPersonas);
                
                
                listPersonas.addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        Persona personaSeleccionada = listPersonas.getSelectedValue();
                        if (personaSeleccionada != null) {
                            txtNombre.setText(personaSeleccionada.getNombre());
                            txtApellido.setText(personaSeleccionada.getApellido());
                            txtDni.setText(personaSeleccionada.getDni());
                        }
                    }
                });
        
        txtNombre = new JTextField();
        txtNombre.setBounds(36, 362, 100, 25);
        add(txtNombre);

        txtApellido = new JTextField();
        txtApellido.setBounds(166, 362, 100, 25);
        add(txtApellido);

        txtDni = new JTextField();
        txtDni.setBounds(296, 362, 94, 25);
        add(txtDni);

        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(422, 362, 100, 25);
        add(btnModificar);
        
        JLabel lblModificarPersona = new JLabel("Modificar Persona");
        lblModificarPersona.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblModificarPersona.setBounds(212, 19, 153, 14);
        add(lblModificarPersona);
    }

    public JList<Persona> getListPersonas() {
        return listPersonas;
    }

    public DefaultListModel<Persona> getListModel() {
        return listModel;
    }
    
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public JTextField getTxtDni() {
        return txtDni;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }
}