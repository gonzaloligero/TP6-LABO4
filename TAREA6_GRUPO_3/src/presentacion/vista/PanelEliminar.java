package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import entidad.Persona;

public class PanelEliminar extends JPanel {
    private static final long serialVersionUID = 1L;
    private JList<Persona> listPersonas;
    private DefaultListModel<Persona> listModel;
    private JButton btnEliminar;

    public PanelEliminar() {
        setLayout(null);

        listModel = new DefaultListModel<>();

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(130, 11, 200, 295);
        add(scrollPane);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(130, 340, 200, 25);
        add(btnEliminar);

        listPersonas = new JList<>(listModel);
        scrollPane.setViewportView(listPersonas);
    }

    public JList<Persona> getListPersonas() {
        return listPersonas;
    }

    public DefaultListModel<Persona> getListModel() {
        return listModel;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }
}
