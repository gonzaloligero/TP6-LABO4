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
		private ArrayList<Persona> personasEnLista;
		private ArrayList<Persona> listaPersonas;
		
	    private PersonaNegocio pNeg;	   
	    
	    public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg) {
	    	
	        this.ventanaPrincipal = vista;
	        this.pNeg = pNeg;
	        
	        this.pnlAgregar = new PanelAgregar();  
	        this.pnListar = new PanelListar();
	        this.pnlModificar = new PanelModificar();
	        this.pnlEliminar = new PanelEliminar();
	        this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
	        this.ventanaPrincipal.getMenuListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersonas(a));
	        this.ventanaPrincipal.getMntmModificar().addActionListener(a->EventoClickMenu_AbrirModificar_ModificarPersona(a));
	        this.ventanaPrincipal.getMntmEliminar().addActionListener(a->EventoClickMenu_AbrirEliminar_EliminarPersona(a));
	        this.pnlAgregar.getBtnAgregar().addActionListener(a->PanelAgregarPersonas(a));
	        this.pnlModificar.getBtnModificar().addActionListener(a->ventanaModificarPersona(a));
	        this.pnlEliminar.getBtnEliminar().addActionListener(a->PanelEliminar(a));
	        	        	                         
	    }
	    
	    public void EventoClickMenu_AbrirModificar_ModificarPersona(ActionEvent a)
	    {
	    	actualizarListaPersonasModificar();
	    	this.ventanaPrincipal.setPanel(pnlModificar);    	
	    }
	    
	    public void  EventoClickMenu_AbrirEliminar_EliminarPersona(ActionEvent a)
	    {
	    	actualizarListaPersonasEliminar();
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
		            JOptionPane.showMessageDialog(null, "Nombre y apellido no deben contener n�meros ni estar vac�os");
		            return;
		     }
			 
		     if (!esDniValido(dni)) {
		            JOptionPane.showMessageDialog(null, "DNI debe contener solo n�meros y no debe estar vac�o");
		            return;
		     }
		     
		     if(!validarDni(dni)) {
		    	 
		    	 Persona nuevaPersona = new Persona(dni,nombre,apellido);
		    	 boolean estado = pNeg.insert(nuevaPersona);
		    	 
		    	 String mensaje;
		    	 if(estado==true)
		    	 {
		    		 mensaje="Persona agregada con exito";
		    		 System.out.println("Se agreg� a la base de datos");
		    		 this.pnlAgregar.getTxtNombre().setText("");	
		    		 this.pnlAgregar.getTxtApellido().setText("");
		    		 this.pnlAgregar.getTxtDni().setText("");
		    	 }
		    	 else {
		    		 mensaje="Persona no agregada, complete todos los campos";
		    		 //System.out.println("No se agreg� a la base de datos");
		    	 }
		    	 JOptionPane pnConfirmacion = null;
		    	 pnConfirmacion.showMessageDialog(null,"Persona agregada exitosamente!");
		     }
		     else {
		    	 JOptionPane.showMessageDialog(null, "El dni "+dni+" ya existe");
		    	 this.pnlAgregar.getTxtDni().setText("");
		     }
		        
	   }  
	   
	   
	   private void PanelEliminar(ActionEvent a) {
		    Persona personaSeleccionada = (Persona) this.pnlEliminar.getListPersonas().getSelectedValue();
		    if (personaSeleccionada != null) {
		        int confirmacion = JOptionPane.showConfirmDialog(null, "�Est� seguro que desea eliminar a esta persona?", "Confirmar Eliminaci�n", JOptionPane.YES_NO_OPTION);
		        if (confirmacion == JOptionPane.YES_OPTION) {
		            boolean estado = pNeg.delete(personaSeleccionada);
		            String mensaje;
		            if (estado) {
		                mensaje = "Persona eliminada con �xito";
		                actualizarListaPersonasEliminar();
		            } else {
		                mensaje = "Error al eliminar la persona";
		            }
		            JOptionPane.showMessageDialog(null, mensaje);
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "Seleccione una persona para eliminar");
		    }
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
		
		
		private boolean validarDni(String dni) {
			listaPersonas = (ArrayList<Persona>) pNeg.readALL();
			for (Persona persona : listaPersonas) {
				
				if(persona.getDni().equals(dni)) {
					return true;
				}
			}
			return false;
		}
			
		
	    private void ventanaModificarPersona(ActionEvent a) {
	    	
	        Persona personaSeleccionada = this.pnlModificar.getListPersonas().getSelectedValue();
	        if (personaSeleccionada != null) {
	            
	            String nombre = this.pnlModificar.getTxtNombre().getText();
	            String apellido = this.pnlModificar.getTxtApellido().getText();
	            String dni = this.pnlModificar.getTxtDni().getText();
	            
				 if (!esNombreValido(nombre) || !esNombreValido(apellido)) {
			            JOptionPane.showMessageDialog(null, "Nombre y apellido no deben contener n�meros ni estar vac�os");
			            return;
			     }
				 else {
					 
					 
					 Persona personaModificada = new Persona(nombre, apellido, dni);
					 
					 
					 boolean estado = pNeg.update(personaModificada);
					 String mensaje;
					 if (estado) {
						 mensaje = "Persona modificada con �xito";
						 
						 this.pnlModificar.getTxtNombre().setText("");
						 this.pnlModificar.getTxtApellido().setText("");
						 this.pnlModificar.getTxtDni().setText("");
					 } else {
						 mensaje = "Persona no modificada, No se puede modificar el DNI";
					 }
					 
					 
					 JOptionPane.showMessageDialog(null, mensaje);
					 actualizarListaPersonasModificar();
					 
				 }
					 	 
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
	    private void actualizarListaPersonasEliminar() {
	        personasEnLista = (ArrayList<Persona>) pNeg.readALL();
	        DefaultListModel<Persona> listModelEliminar = pnlEliminar.getListModel();
	        listModelEliminar.clear();
	        for (Persona persona : personasEnLista) {
	        	listModelEliminar.addElement(persona);
	        }
	    }
	        	    
	    
		@Override
	   public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub		
		}						
	
		
		
}