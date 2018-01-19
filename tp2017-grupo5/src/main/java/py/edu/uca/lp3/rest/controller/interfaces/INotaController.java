package py.edu.uca.lp3.rest.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.edu.uca.lp3.domain.Nota;

//@RestController
//@RequestMapping("/nota")
public interface INotaController
{
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody Nota nota);
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<Nota> list();
	
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public Nota selectByID(@PathVariable("id") long id);
	
	@RequestMapping(value = "/find/matricula/{matricula}", method = RequestMethod.GET)
	public List<Nota> selectByMatricula(@PathVariable("matricula") String matricula);
	
	@RequestMapping(value = "/find/codigo/{codigo}", method = RequestMethod.GET)
	public List<Nota> selectByCodigoMateria(@PathVariable("codigo") String codigoMateria);
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id);
}
