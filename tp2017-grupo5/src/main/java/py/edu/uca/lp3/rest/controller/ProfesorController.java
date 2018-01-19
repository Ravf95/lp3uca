package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.Profesor;
import py.edu.uca.lp3.rest.controller.interfaces.IProfesorController;
import py.edu.uca.lp3.service.ProfesorService;

@RestController
@RequestMapping("/profesor")
public class ProfesorController implements IProfesorController 
{
	@Autowired
	private ProfesorService service;
	
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public Profesor selectByID(@PathVariable("id") long id)
	{
		return service.findByID(id);
	}
	
	@RequestMapping(value = "/find/ci/{ci}", method = RequestMethod.GET)
	public Profesor selectByCI(@PathVariable("ci") int ci)
	{
		return service.findByCI(ci);
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<Profesor> list()
	{
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody Profesor profesor)
	{
		service.save(profesor);
	}
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id)
	{
		service.delete(id);
	}
	
	@RequestMapping(value = "/remove/ci/{ci}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("ci")  int ci)
	{
		service.delete(ci);
	}
}
