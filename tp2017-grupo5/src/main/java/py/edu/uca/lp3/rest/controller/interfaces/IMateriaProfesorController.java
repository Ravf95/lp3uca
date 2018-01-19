package py.edu.uca.lp3.rest.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.edu.uca.lp3.domain.MateriaProfesor;

//@RestController
//@RequestMapping("/materia/profesor")
public interface IMateriaProfesorController 
{
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody MateriaProfesor materia);
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<MateriaProfesor> list();
	
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public MateriaProfesor selectByID(@PathVariable("id") long id);
	
	@RequestMapping(value = "/find/codigo/{codigo}", method = RequestMethod.GET)
	public List<MateriaProfesor> selectByCodigoMateria(@PathVariable("codigo") String codigoMateria);
	
	@RequestMapping(value = "/find/ci/{ci}", method = RequestMethod.GET)
	public List<MateriaProfesor> selectByCIProfesor(@PathVariable("ci") int ciProfesor);
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id);
}
