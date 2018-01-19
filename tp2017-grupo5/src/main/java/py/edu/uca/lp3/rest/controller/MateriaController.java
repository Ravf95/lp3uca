package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.Materia;
import py.edu.uca.lp3.rest.controller.interfaces.IMateriaController;
import py.edu.uca.lp3.service.MateriaService;

@RestController
@RequestMapping("/materia")
public class MateriaController implements IMateriaController 
{
	@Autowired
	MateriaService materiaService;
	
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public Materia selectByID(@PathVariable("id") long id) 
	{
		return materiaService.findByID(id);
	}
	
	@RequestMapping(value = "/find/codigo/{codigo}", method = RequestMethod.GET)
	public Materia selectByCodigoMateria(@PathVariable("codigo") String materia) 
	{
		return materiaService.findByCodigoMateria(materia);
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<Materia> list() 
	{
		return materiaService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody Materia materia) 
	{
		materiaService.save(materia);
	}
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id) 
	{
		materiaService.delete(id);
	}
	
	@RequestMapping(value = "/remove/codigo/{codigo}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("codigo") String codigoMateria) 
	{
		materiaService.delete(codigoMateria);
	}
}
