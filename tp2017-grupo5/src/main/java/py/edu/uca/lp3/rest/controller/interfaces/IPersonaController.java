package py.edu.uca.lp3.rest.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.edu.uca.lp3.domain.Persona;

// @RestController
// @RequestMapping("/persona")
public interface IPersonaController 
{
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public Persona selectById(@PathVariable("id") long id);
	
	@RequestMapping(value = "/find/ci/{ci}", method = RequestMethod.GET)
	public Persona selectByCI(@PathVariable("ci") int ci);
	
	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody Persona persona);
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id);
	
	@RequestMapping(value = "/remove/ci/{ci}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("ci") int ci);
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<Persona> list();
	
	@RequestMapping(value = "/find/rol/{rol}", method = RequestMethod.GET)
	public List<Persona> listByRol(@PathVariable("rol") String rol);
}
