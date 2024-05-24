package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.table.DefaultTableModel;

import javax.swing.JList;

import daoImpl.Conexion;
import entidad.Persona;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;	
	
	private JFrame frmPrograma;
    private DefaultTableModel modelPersonas;
    private String[] nombreColumnas = {"Nombre y apellido", "Dni"};
    private JMenuBar menuBar;
    private JMenu mnPersona;
    private JMenuItem mntmAgregar;
    private JMenuItem mntmModificar;
    private JMenuItem mntmEliminar;
    private JMenuItem mntmListar;
   

    public VentanaPrincipal() {
    	
    	 
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
	
	
	public JMenuItem getMntmModificar() {
		return mntmModificar;
	}


	public void setMntmModificar(JMenuItem mntmModificar) {
		this.mntmModificar = mntmModificar;
	}


	public JMenuItem getMntmEliminar() {
		return mntmEliminar;
	}


	public void setMntmEliminar(JMenuItem mntmEliminar) {
		this.mntmEliminar = mntmEliminar;
	}


	private void initialize() 
	{
		frmPrograma = new JFrame();
		frmPrograma.setTitle("Programa");
		frmPrograma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrograma.setBounds(100, 100, 783, 494);
		frmPrograma.getContentPane().setLayout(null);
       

        modelPersonas = new DefaultTableModel(null, nombreColumnas);

		 menuBar = new JMenuBar();
	     menuBar.setToolTipText("Persona");
	     frmPrograma.setJMenuBar(menuBar);

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
	     
	     //setJMenuBar(menuBar);
	}
	
	
	
	
	public void show() {
        this.frmPrograma.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.frmPrograma.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(null, "¿Estás seguro que quieres salir de Programa?",
                        "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    Conexion.getConexion().cerrarConexion();
                    System.exit(0);
                }
            }
        });
        this.frmPrograma.setVisible(true);
    }

    public DefaultTableModel getModelPersonas() {
        return modelPersonas;
    }

    public String[] getNombreColumnas() {
        return nombreColumnas;
    }

    public void llenarTabla(List<Persona> personasEnTabla) {
        this.getModelPersonas().setRowCount(0); // Para vaciar la tabla
        this.getModelPersonas().setColumnCount(0);
        this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

        for (Persona p : personasEnTabla) {
            String nombre = p.getNombre();
            String apellido = p.getApellido();
            String dni = p.getDni();
            Object[] fila = {nombre, apellido, dni};
            this.getModelPersonas().addRow(fila);
        }
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void agregarListenerAgregar(ActionListener listener) {
        mntmAgregar.addActionListener(listener);
    }
    
    public void agregarListenerModificar(ActionListener listener) {
        mntmModificar.addActionListener(listener);
    }
    
    public void agregarListenerEliminar(ActionListener listener) {
       
        mntmEliminar.addActionListener(listener);
        //mnPersona.add(mntmEliminar);
    }
    public void agregarListenerListar(ActionListener listener) {  // Método para añadir listener a Listar
        mntmListar.addActionListener(listener);
    }
	
    public void setPanel(JPanel panel) {
    	frmPrograma.getContentPane().removeAll();
        panel.setBounds(0, 0, frmPrograma.getWidth(), frmPrograma.getHeight());
        frmPrograma.getContentPane().add(panel);
        frmPrograma.revalidate();
        frmPrograma.repaint();
    }
    
	
	  public JList<Persona> getListPersonas() {
	        return getListPersonas();
	    }

}