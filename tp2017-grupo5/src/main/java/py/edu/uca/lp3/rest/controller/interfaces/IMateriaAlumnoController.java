package py.edu.uca.lp3.rest.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.edu.uca.lp3.domain.MateriaAlumno;

//@RestController
//@RequestMapping("/materia/alumno")
public interface IMateriaAlumnoController 
{
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody MateriaAlumno materia);
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<MateriaAlumno> list();
	
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public MateriaAlumno selectByID(@PathVariable("id") long id);
	
	@RequestMapping(value = "/find/codigo/{codigo}", method = RequestMethod.GET)
	public List<MateriaAlumno> selectByCodigoMateria(@PathVariable("codigo") String codigoMateria);
	
	@RequestMapping(value = "/find/ci/{ci}", method = RequestMethod.GET)
	public List<MateriaAlumno> selectByCIAlumno(@PathVariable("ci") int ciAlumno);
	
	@RequestMapping(value = "/find/matricula/{matricula}", method = RequestMethod.GET)
	public List<MateriaAlumno> selectByMatriculaAlumno(@PathVariable("matricula") String matricula);
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id);
}
