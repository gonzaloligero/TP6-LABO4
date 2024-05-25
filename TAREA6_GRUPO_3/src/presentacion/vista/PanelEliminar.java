package presentacion.vista;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;


import entidad.Persona;

public class PanelEliminar extends JPanel {
	
	private JList listPersonas;
	private DefaultListModel<Persona> listModel;
	private JButton btnEliminar;
	
	public PanelEliminar() {
		
		setLayout(null);
		
		listModel = new DefaultListModel<>();
		
		listPersonas = new JList();
		listPersonas.setBounds(190, 20, 350, 270);	
		listModel = new DefaultListModel <Persona>();
		listPersonas.setModel(listModel);
		add(listPersonas);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(250, 340, 200, 25);
		add(btnEliminar);
		
	}
	public JList getListPersonas() {
		return listPersonas;
	}
	public void setListPersonas(JList listPersonas) {
		this.listPersonas = listPersonas;
	}
	public DefaultListModel<Persona> getListModel() {
		return listModel;
	}
	public void setListModel(DefaultListModel<Persona> listModel) {
		this.listModel = listModel;
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
		
		
}
