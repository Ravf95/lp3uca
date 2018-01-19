package py.edu.uca.lp3.service.interfaces;

import java.util.List;

import py.edu.uca.lp3.domain.MateriaAlumno;

public interface IMateriaAlumnoService 
{
	public void asignarMateria(MateriaAlumno materia);
	public MateriaAlumno findByID(long id);
	public List<MateriaAlumno> list();
	public List<MateriaAlumno> findByCodigoMateria(String codigoMateria);
	public List<MateriaAlumno> findByCIAlumno(int ciAlumno); // consulta ci de Alumno
	public List<MateriaAlumno> findByMatriculaAlumno(String matricula);
	public void delete(long id);
}
