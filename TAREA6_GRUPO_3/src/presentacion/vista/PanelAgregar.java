package presentacion.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAgregar extends JPanel {
    
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnAgregar;
	
	public PanelAgregar() {	
		super();
		initialize();
	}
	
	
	private void initialize() 
	{
		
		setLayout(null);
				
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(200, 68, 56, 16);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(290, 68, 200, 22);
		add(txtNombre);
		
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(200, 108, 56, 16);
		add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(290, 105, 200, 22);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(200, 150, 56, 16);
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(290, 145, 200, 22);
		add(txtDni);
		txtDni.setColumns(10);
		
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(200, 211, 97, 25);
		add(btnAgregar);
	}


	
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}


	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}


	public JTextField getTxtApellido() {
		return txtApellido;
	}


	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}


	public JTextField getTxtDni() {
		return txtDni;
	}


	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}


	public JButton getBtnAgregar() {
		return btnAgregar;
	}


	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}


	public void show()
	{
		this.setVisible(true);
	}
	
}
