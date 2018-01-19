package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.Alumno;
import py.edu.uca.lp3.rest.controller.interfaces.IAlumnoController;
import py.edu.uca.lp3.service.AlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController implements IAlumnoController
{
	@Autowired
	AlumnoService alumnoService;
	
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public Alumno selectByID(@PathVariable("id") long id) 
	{
		return alumnoService.findByID(id);
	}
	
	@RequestMapping(value = "/find/ci/{ci}", method = RequestMethod.GET)
	public Alumno selectByCI(@PathVariable("ci") int ci) 
	{
		return alumnoService.findByCI(ci);
	}
	
	@RequestMapping(value = "/find/matricula/{matricula}", method = RequestMethod.GET)
	public Alumno selectByMatricula(@PathVariable("matricula") String matricula) 
	{
		return alumnoService.findByMatricula(matricula);
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<Alumno> list()
	{
		return alumnoService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody Alumno alumno) 
	{
		alumnoService.save(alumno);
	}
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id) 
	{
		alumnoService.delete(id);
	}
	
	@RequestMapping(value = "/remove/ci/{ci}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("ci") int ci) 
	{
		alumnoService.delete(ci);
	}
	
	@RequestMapping(value = "/remove/matricula/{matricula}", method = RequestMethod.GET)
	public void delete(@PathVariable("matricula") String matricula) 
	{
		alumnoService.delete(matricula);
	}
}
