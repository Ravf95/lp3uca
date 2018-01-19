package py.edu.uca.lp3.rest.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.edu.uca.lp3.domain.Materia;

//@RestController
//@RequestMapping("/materia")
public interface IMateriaController 
{
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public Materia selectByID(@PathVariable("id") long id);
	
	@RequestMapping(value = "/find/codigo/{codigo}", method = RequestMethod.GET)
	public Materia selectByCodigoMateria(@PathVariable("codigo") String materia);
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<Materia> list();
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody Materia materia);
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id);
	
	@RequestMapping(value = "/remove/codigo/{codigo}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("codigo") String codigoMateria);
}
