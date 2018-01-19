package py.edu.uca.lp3.service.interfaces;

import java.util.List;
import py.edu.uca.lp3.domain.Profesor;

public interface IProfesorService 
{
	public Profesor findByID(long id);
	public Profesor findByCI(int ci);
	public List<Profesor> findAll();
	public void save(Profesor profesor);
	public void delete(long id);
	public void delete(int ci); // all
}
