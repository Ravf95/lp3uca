package py.edu.uca.lp3.service.interfaces;

import java.util.List;
import py.edu.uca.lp3.domain.Persona;

public interface IPersonaService 
{
	public Persona findByID(long id);
	public Persona findByCI(int ci);
	public List<Persona> findAll();
	public void save(Persona persona);
	public void delete(long id);
	public void delete(int ci);
	public List<Persona> findByRol(String rol);
}
