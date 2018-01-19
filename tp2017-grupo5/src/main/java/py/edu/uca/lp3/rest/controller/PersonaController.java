package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.Persona;
import py.edu.uca.lp3.rest.controller.interfaces.IPersonaController;
import py.edu.uca.lp3.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController implements IPersonaController
{
	@Autowired
	private PersonaService personaService;
	
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public Persona selectById(@PathVariable("id") long id)
	{
		return personaService.findByID(id);
	}
	
	@RequestMapping(value = "/find/ci/{ci}", method = RequestMethod.GET)
	public Persona selectByCI(@PathVariable("ci") int ci)
	{
		return personaService.findByCI(ci);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody Persona persona)
	{
		personaService.save(persona);
	}
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id)
	{
		personaService.delete(id);
	}
	
	@RequestMapping(value = "/remove/ci/{ci}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("ci") int ci)
	{
		personaService.delete(ci);
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<Persona> list()
	{
		return personaService.findAll();
	}
	
	@RequestMapping(value = "/find/rol/{rol}", method = RequestMethod.GET)
	public List<Persona> listByRol(@PathVariable("rol") String rol)
	{
		return personaService.findByRol(rol);
	}
}
