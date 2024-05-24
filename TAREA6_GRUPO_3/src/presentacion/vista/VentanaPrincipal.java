package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.table.DefaultTableModel;
//import javax.swing.DefaultListModel;
import javax.swing.JList;

import daoImpl.Conexion;
import entidad.Persona;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;	
    private JMenuBar menuBar;
    private JMenu mnPersona;
    private JMenuItem mntmAgregar;
    private JMenuItem mntmModificar;
    private JMenuItem mntmEliminar;
    private JMenuItem mntmListar;
   

    public VentanaPrincipal() {
    	
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setBounds(100, 100, 783, 494);
		 initialize();
    	
    }
       
    
    public JMenu getMnPersonas() {
		return mnPersona;
	}
    public void setMnPersonas(JMenu mnPersonas) {
		this.mnPersona = mnPersonas;
	}
    
    public JMenuItem getMenuAgregar() {
		return mntmAgregar;
	}

	public void setMenuAgregar(JMenuItem menuAgregar) {
		this.mntmAgregar = menuAgregar;
	}
	
	
	
    public JMenuItem getMenuListar() {
		return mntmListar;
	}

	public void setMenuListar(JMenuItem menuListar) {
		this.mntmListar = menuListar;
	}
	
	
	private void initialize() 
	{
		 menuBar = new JMenuBar();
	     menuBar.setToolTipText("Persona");
	    

	     mnPersona = new JMenu("Persona");
	     menuBar.add(mnPersona);

	     mntmAgregar = new JMenuItem("Agregar");
	     mnPersona.add(mntmAgregar);

	     mntmModificar = new JMenuItem("Modificar");
	     mnPersona.add(mntmModificar);

	     mntmEliminar = new JMenuItem("Eliminar");
	     mnPersona.add(mntmEliminar);

	     mntmListar = new JMenuItem("Listar");
	     mnPersona.add(mntmListar);
	     
	     setJMenuBar(menuBar);
	}

}