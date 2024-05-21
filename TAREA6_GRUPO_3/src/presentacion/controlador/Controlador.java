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
	    private PanelModificar pnlModificar;
	    private PanelEliminar pnlEliminar;
	    private PanelListar pnlListar;
	    private PersonaNegocio pNeg;
	    private ArrayList<Persona> personasEnTabla;

	    
	    
	    
	    public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg) {
	        this.ventanaPrincipal = vista;
	        this.pNeg = pNeg;
	        this.pnlAgregar = new PanelAgregar();
	        this.pnlModificar = new PanelModificar();
	        this.pnlEliminar = new PanelEliminar();
	        this.pnlListar = new PanelListar();

	        
	        
	       
	            }
	       
	    
	    public void inicializar() {
	        
	        this.ventanaPrincipal.show();
	    }



		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	

}
