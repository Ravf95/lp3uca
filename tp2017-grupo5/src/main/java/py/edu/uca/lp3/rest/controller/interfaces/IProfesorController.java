package py.edu.uca.lp3.rest.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.edu.uca.lp3.domain.Profesor;

//@RestController
//@RequestMapping("/profesor")
public interface IProfesorController 
{
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public Profesor selectByID(@PathVariable("id") long id);
	
	@RequestMapping(value = "/find/ci/{ci}", method = RequestMethod.GET)
	public Profesor selectByCI(@PathVariable("ci") int ci);
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<Profesor> list();
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody Profesor profesor);
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id);
	
	@RequestMapping(value = "/remove/ci/{ci}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("ci")  int ci);
}
