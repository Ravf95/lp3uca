package py.edu.uca.lp3.service.interfaces;

import java.util.List;

import py.edu.uca.lp3.domain.Alumno;

public interface IAlumnoService 
{
	public Alumno findByID(long id);
	public Alumno findByCI(int ci);
	public Alumno findByMatricula(String matricula);
	public List<Alumno> findAll();
	public void save(Alumno alumno);
	public void delete(long id);
	public void delete(int ci); // all
	public void delete(String matricula); // all
}
