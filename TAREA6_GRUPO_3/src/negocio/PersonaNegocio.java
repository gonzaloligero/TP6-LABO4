package negocio;

import java.util.List;

import entidad.Persona;

public interface PersonaNegocio {
	public boolean insert(Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public boolean update(Persona persona_a_modificar);
	public List<Persona> readALL();
}
