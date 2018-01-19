package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.MateriaAlumno;
import py.edu.uca.lp3.rest.controller.interfaces.IMateriaAlumnoController;
import py.edu.uca.lp3.service.MateriaAlumnoService;

@RestController
@RequestMapping("/materia/alumno")
public class MateriaAlumnoController implements IMateriaAlumnoController 
{
	@Autowired
	MateriaAlumnoService materiaAlumnoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody MateriaAlumno materia) 
	{
		materiaAlumnoService.asignarMateria(materia);
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<MateriaAlumno> list() 
	{
		return materiaAlumnoService.list();
	}
	
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public MateriaAlumno selectByID(@PathVariable("id") long id) 
	{
		return materiaAlumnoService.findByID(id);
	}
	
	@RequestMapping(value = "/find/codigo/{codigo}", method = RequestMethod.GET)
	public List<MateriaAlumno> selectByCodigoMateria(@PathVariable("codigo") String codigoMateria) 
	{
		return materiaAlumnoService.findByCodigoMateria(codigoMateria);
	}
	
	@RequestMapping(value = "/find/ci/{ci}", method = RequestMethod.GET)
	public List<MateriaAlumno> selectByCIAlumno(@PathVariable("ci") int ciAlumno) 
	{
		return materiaAlumnoService.findByCIAlumno(ciAlumno);
	}
	
	@RequestMapping(value = "/find/matricula/{matricula}", method = RequestMethod.GET)
	public List<MateriaAlumno> selectByMatriculaAlumno(@PathVariable("matricula") String matricula) 
	{
		return materiaAlumnoService.findByMatriculaAlumno(matricula);
	}
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id) 
	{
		materiaAlumnoService.delete(id);
	}
}
