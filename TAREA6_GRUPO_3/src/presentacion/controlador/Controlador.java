package presentacion.controlador;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;



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
	    private PersonaNegocio pNeg;	   
	    
	    public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg) {
	    	
	        this.ventanaPrincipal = vista;
	        this.pNeg = pNeg;
	        
	        this.pnlAgregar = new PanelAgregar();        
	        this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
	        this.pnlAgregar.getBtnAgregar().addActionListener(a->PanelAgregarPersonas(a));
	                
	    }
	    
	    public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
		{		
			ventanaPrincipal.getContentPane().removeAll();
			ventanaPrincipal.getContentPane().add(pnlAgregar);
			ventanaPrincipal.getContentPane().repaint();
			ventanaPrincipal.getContentPane().revalidate();
		}
	    
	    private void PanelAgregarPersonas(ActionEvent a) {
			
			String nombre = this.pnlAgregar.getTxtNombre().getText();	
			String apellido = this.pnlAgregar.getTxtApellido().getText();
			String dni = this.pnlAgregar.getTxtDni().getText();
			
			Persona nuevaPersona = new Persona(dni,nombre,apellido);
			
			boolean estado = pNeg.insert(nuevaPersona);
			
			String mensaje;
			if(estado==true)
			{
				mensaje="Persona agregada con exito";
				System.out.println("se agrego a la base de datos");
				this.pnlAgregar.getTxtNombre().setText("");	
				this.pnlAgregar.getTxtApellido().setText("");
				this.pnlAgregar.getTxtDni().setText("");
			}
			else
				/*mensaje="Persona no agregada, complete todos los campos";*/
			    System.out.println("no se agrego a la base de datos");
		}
	           
	    public void inicializar() {
	        
	    	this.ventanaPrincipal.setVisible(true);
	    }


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub		
		}
	
}
