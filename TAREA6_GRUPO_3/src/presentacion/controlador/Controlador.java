package presentacion.controlador;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import negocio.PersonaNegocio;
import presentacion.vista.PanelEliminar;
import presentacion.vista.PanelModificar;
import presentacion.vista.PanelAgregar;
    
	import presentacion.vista.PanelListar;
	
	import presentacion.vista.VentanaPrincipal;
	import entidad.Persona;

	public class Controlador implements ActionListener {
			
	    private VentanaPrincipal ventanaPrincipal;
	    private PanelAgregar pnlAgregar;
	    private PanelListar pnListar;
	    private PanelModificar pnlModificar;
	    private PanelEliminar pnlEliminar;
	    

		private ArrayList<Persona> personasEnTabla;
	    private PersonaNegocio pNeg;	   
	    
	    public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg) {
	    	
	        this.ventanaPrincipal = vista;
	        this.pNeg = pNeg;
	        
	        this.pnlAgregar = new PanelAgregar();  
	        this.pnListar = new PanelListar();
	        this.pnlModificar = new PanelModificar();
	        this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
	        this.ventanaPrincipal.getMenuListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersonas(a));
	        this.ventanaPrincipal.getMntmModificar().addActionListener(a->EventoClickMenu_AbrirModificar_ModificarPersona(a));
	        this.ventanaPrincipal.getMntmEliminar().addActionListener(a->EventoClickMenu_AbrirEliminar_EliminarPersona(a));
	        this.pnlAgregar.getBtnAgregar().addActionListener(a->PanelAgregarPersonas(a));
	        this.pnlModificar.getBtnModificar().addActionListener(a->ventanaModificarPersona(a));
	        
	        
	      
	        
	                
	    }
	    
	    public void EventoClickMenu_AbrirModificar_ModificarPersona(ActionEvent a) {
	    	actualizarListaPersonasModificar();
	    	this.ventanaPrincipal.setPanel(pnlModificar);
	    	
	    }
	    
	    public void  EventoClickMenu_AbrirEliminar_EliminarPersona(ActionEvent a){
	    
	    	this.ventanaPrincipal.setPanel(pnlEliminar);
    	
    }
	    public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
		{		
	    	this.ventanaPrincipal.setPanel(pnlAgregar);
		}
	    
	    
	    public void  EventoClickMenu_AbrirPanel_ListarPersonas(ActionEvent a)
	    {	
	    	this.ventanaPrincipal.setPanel(pnListar);
	    	
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
		   this.refrescarTabla();
		   this.ventanaPrincipal.show();
	    	
	   }

	   
		private void refrescarTabla()
		{
			this.personasEnTabla = (ArrayList<Persona>) pNeg.readALL();
			this.pnListar.llenarTabla(this.personasEnTabla);
		}
		
		
		
	    private void ventanaModificarPersona(ActionEvent a) {
	    	
	        Persona personaSeleccionada = this.pnlModificar.getListPersonas().getSelectedValue();
	        if (personaSeleccionada != null) {
	            
	            String nombre = this.pnlModificar.getTxtNombre().getText();
	            String apellido = this.pnlModificar.getTxtApellido().getText();
	            String dni = this.pnlModificar.getTxtDni().getText();
	            
	           
	            Persona personaModificada = new Persona(nombre, apellido, dni);
	            
	         
	            boolean estado = pNeg.update(personaModificada);
	            String mensaje;
	            if (estado) {
	                mensaje = "Persona modificada con éxito";
	                
	                this.pnlModificar.getTxtNombre().setText("");
	                this.pnlModificar.getTxtApellido().setText("");
	                this.pnlModificar.getTxtDni().setText("");
	            } else {
	                mensaje = "Persona no modificada, No se puede modificar el DNI";
	            }
      
	          
	            JOptionPane.showMessageDialog(null, mensaje);
	            actualizarListaPersonasModificar();
     
	        } else {
	          
	            
	        }
	    }
	    
  
	    private void actualizarListaPersonasModificar() {
	        personasEnTabla = (ArrayList<Persona>) pNeg.readALL();
	        DefaultListModel<Persona> listModelModificar = pnlModificar.getListModel();
	        listModelModificar.clear();
	        for (Persona persona : personasEnTabla) {
	            listModelModificar.addElement(persona);
	        }
	    }

	    
	    
	    
	    
		@Override
	   public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub		
		}
		
		
		
		
		

	
}