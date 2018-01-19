package py.edu.uca.lp3.service.interfaces;

import java.util.List;
import py.edu.uca.lp3.domain.MateriaProfesor;

public interface IMateriaProfesorService 
{
	public void asignarMateria(MateriaProfesor materia);
	public MateriaProfesor findByID(long id);
	public List<MateriaProfesor> list();
	public List<MateriaProfesor> findByCodigoMateria(String codigoMateria);
	public List<MateriaProfesor> findByCIProfesor(int ciProfesor);
	public void delete(long id);
}
