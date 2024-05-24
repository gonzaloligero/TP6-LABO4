package presentacion.vista;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import entidad.Persona;

public class PanelListar extends JPanel {
    private JTable tablaPersonas;
    private DefaultTableModel modelPersonas;
    private String[] nombreColumnas = {"Dni", "Nombre", "Apellido"};

    public PanelListar() {
        setLayout(null);

        modelPersonas = new DefaultTableModel(null, nombreColumnas);
        tablaPersonas = new JTable(modelPersonas);

        JScrollPane scrollPane = new JScrollPane(tablaPersonas);
        scrollPane.setBounds(55, 69, 494, 196);
        add(scrollPane);
    }

    public void llenarTabla(List<Persona> personasEnTabla) {
        this.getModelPersonas().setRowCount(0);
        this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

        for (Persona p : personasEnTabla) {
            String nombre = p.getNombre();
            String apellido = p.getApellido();
            String dni = p.getDni();
            Object[] fila = {dni, nombre, apellido};
            this.getModelPersonas().addRow(fila);
        }
    }

    public String[] getNombreColumnas() {
        return nombreColumnas;
    }

    public DefaultTableModel getModelPersonas() {
        return modelPersonas;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}