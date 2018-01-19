package py.edu.uca.lp3.service.interfaces;

import java.util.List;

import py.edu.uca.lp3.domain.Nota;

public interface INotaService 
{
	public void asignarNota(Nota nota);
	public List<Nota> findAll();
	public Nota findByID(long id);
	public List<Nota> findByMatricula(String matricula);
	public List<Nota> findByCodigoMateria(String codigoMateria);
	public void delete(long id);
}
