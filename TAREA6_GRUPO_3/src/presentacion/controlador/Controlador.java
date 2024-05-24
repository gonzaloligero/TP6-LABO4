package presentacion.controlador;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import negocio.PersonaNegocio;
	import presentacion.vista.PanelAgregar;
    import presentacion.vista.PanelEliminar;
	import presentacion.vista.PanelListar;
	import presentacion.vista.PanelModificar;
	import presentacion.vista.VentanaPrincipal;
	import entidad.Persona;

	public class Controlador implements ActionListener {
			
	    private VentanaPrincipal ventanaPrincipal;
	    private PanelAgregar pnlAgregar;
	    private PanelListar pnListar;
	    
	    

		private ArrayList<Persona> personasEnTabla;
	    private PersonaNegocio pNeg;	   
	    
	    public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg) {
	    	
	        this.ventanaPrincipal = vista;
	        this.pNeg = pNeg;
	        
	        this.pnlAgregar = new PanelAgregar();  
	        this.pnListar = new PanelListar();
	        
	        this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
	        this.ventanaPrincipal.getMenuListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersonas(a));
	        
	        this.pnlAgregar.getBtnAgregar().addActionListener(a->PanelAgregarPersonas(a));
	                
	    }
	    
	    public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
		{		
			ventanaPrincipal.getContentPane().removeAll();
			ventanaPrincipal.getContentPane().add(pnlAgregar);
			ventanaPrincipal.getContentPane().repaint();
			ventanaPrincipal.getContentPane().revalidate();
		}
	    
	    
	    public void  EventoClickMenu_AbrirPanel_ListarPersonas(ActionEvent a)
	    {		
	    	ventanaPrincipal.getContentPane().removeAll();
	    	ventanaPrincipal.getContentPane().add(pnListar);
	    	ventanaPrincipal.getContentPane().repaint();
	    	ventanaPrincipal.getContentPane().revalidate();
	    	refrescarTabla();
	    }
	    
	    
	    
	    
	   private void PanelAgregarPersonas(ActionEvent a) {
			
			String nombre = this.pnlAgregar.getTxtNombre().getText();	
			String apellido = this.pnlAgregar.getTxtApellido().getText();
			String dni = this.pnlAgregar.getTxtDni().getText();
			
			 if (!esNombreValido(nombre) || !esNombreValido(apellido)) {
		            JOptionPane.showMessageDialog(null, "Nombre y apellido no deben contener números ni estar vacíos");
		            return;
		        }

		        if (!esDniValido(dni)) {
		            JOptionPane.showMessageDialog(null, "DNI debe contener solo números y no debe estar vacío");
		            return;
		        }
			
		        
		        Persona nuevaPersona = new Persona(dni,nombre,apellido);
			    boolean estado = pNeg.insert(nuevaPersona);
			
			String mensaje;
			if(estado==true)
			{
				mensaje="Persona agregada con exito";
				System.out.println("Se agregó a la base de datos");
				this.pnlAgregar.getTxtNombre().setText("");	
				this.pnlAgregar.getTxtApellido().setText("");
				this.pnlAgregar.getTxtDni().setText("");
			}
			else {
				mensaje="Persona no agregada, complete todos los campos";
			    System.out.println("No se agregó a la base de datos");
	    }
			JOptionPane pnConfirmacion = null;
			pnConfirmacion.showMessageDialog(null,"Persona agregada exitosamente!");
	
	}    

       private boolean esNombreValido(String texto) {
         return texto.matches("[a-zA-Z]+");
       }

       private boolean esDniValido(String texto) {
        return texto.matches("\\d+");
       }
	
	   public void inicializar() {
	        
	    	this.ventanaPrincipal.setVisible(true);
	   }

	   
		private void refrescarTabla()
		{
			this.personasEnTabla = (ArrayList<Persona>) pNeg.readALL();
			this.pnListar.llenarTabla(this.personasEnTabla);
		}

		@Override
	   public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub		
		}
		
		

	
}