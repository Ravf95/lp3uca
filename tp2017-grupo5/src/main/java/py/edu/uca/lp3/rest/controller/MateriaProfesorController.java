package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.MateriaProfesor;
import py.edu.uca.lp3.rest.controller.interfaces.IMateriaProfesorController;
import py.edu.uca.lp3.service.MateriaProfesorService;

@RestController
@RequestMapping("/materia/profesor")
public class MateriaProfesorController implements IMateriaProfesorController  
{
	@Autowired
	MateriaProfesorService materiaProfesorService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody MateriaProfesor materia) 
	{
		materiaProfesorService.asignarMateria(materia);
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<MateriaProfesor> list() 
	{
		return materiaProfesorService.list();
	}
	
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public MateriaProfesor selectByID(@PathVariable("id") long id) 
	{
		return materiaProfesorService.findByID(id);
	}
	
	@RequestMapping(value = "/find/codigo/{codigo}", method = RequestMethod.GET)
	public List<MateriaProfesor> selectByCodigoMateria(@PathVariable("codigo") String codigoMateria) 
	{
		return materiaProfesorService.findByCodigoMateria(codigoMateria);
	}
	
	@RequestMapping(value = "/find/ci/{ci}", method = RequestMethod.GET)
	public List<MateriaProfesor> selectByCIProfesor(@PathVariable("ci") int ciProfesor) 
	{
		return materiaProfesorService.findByCIProfesor(ciProfesor);
	}
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id) 
	{
		materiaProfesorService.delete(id);
	}
}
