package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelModificar extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public PanelModificar() {
		setLayout(null);
		
		JLabel lblPersModificar = new JLabel("   Seleccione la persona que desea modificar");
		lblPersModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPersModificar.setBounds(58, 11, 287, 14);
		add(lblPersModificar);
		
		JList list = new JList();
		list.setBounds(58, 36, 413, 181);
		add(list);
		
		textField = new JTextField();
		textField.setBounds(63, 241, 103, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 241, 103, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(296, 241, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificar.setBounds(409, 228, 89, 35);
		add(btnModificar);
	}
}
