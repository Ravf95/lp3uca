package py.edu.uca.lp3.rest.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.edu.uca.lp3.domain.Alumno;

//@RestController
//@RequestMapping("/alumno")
public interface IAlumnoController 
{
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public Alumno selectByID(@PathVariable("id") long id);
	
	@RequestMapping(value = "/find/ci/{ci}", method = RequestMethod.GET)
	public Alumno selectByCI(@PathVariable("ci") int ci);
	
	@RequestMapping(value = "/find/matricula/{matricula}", method = RequestMethod.GET)
	public Alumno selectByMatricula(@PathVariable("matricula") String matricula);
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<Alumno> list();
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody Alumno alumno);
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id);
	
	@RequestMapping(value = "/remove/ci/{ci}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("ci") int ci);
	
	@RequestMapping(value = "/remove/matricula/{matricula}", method = RequestMethod.GET)
	public void delete(@PathVariable("matricula") String matricula);
}
