package negocioImpl;

import java.util.List;

import dao.IPersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{

	IPersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		
		boolean estado=false;
		if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0)
		{
			estado=pdao.insert(persona);
		}
		return estado;
	}

	@Override
	public boolean delete(Persona persona_a_eliminar) {
		boolean estado=false;
		if(persona_a_eliminar.getDni()!="" )
		{
			estado=pdao.delete(persona_a_eliminar);
		}
		return estado;
	}


	@Override
	public boolean update(Persona persona_a_modificar) {
	    boolean estado = false;
	    if(persona_a_modificar.getDni() != "") {
	       estado = pdao.update(persona_a_modificar);
	    }
	    return estado;
	}


	@Override
	public List<Persona> readALL() {
		
		return pdao.readALL();
	}

}
