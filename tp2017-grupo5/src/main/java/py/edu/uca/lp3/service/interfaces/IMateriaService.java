package py.edu.uca.lp3.service.interfaces;

import java.util.List;
import py.edu.uca.lp3.domain.Materia;

public interface IMateriaService 
{
	public Materia findByID(long id);
	public Materia findByCodigoMateria(String materia);
	public List<Materia> findAll();
	public void save(Materia materia);
	public void delete(long id);
	public void delete(String codigoMateria);	
}