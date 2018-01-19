package py.edu.uca.lp3.rest.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RestController
//@RequestMapping("/mensaje")
public interface IMensajeController<T1, T2> 
{
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody T2 mensaje);
	
	@RequestMapping(value = "/find/enviados/ci/{ci}", method = RequestMethod.GET)
	public List<T1> selectByCIEmisor(@PathVariable("ci") int ci);
	
	@RequestMapping(value = "/find/recibidos/ci/{ci}", method = RequestMethod.GET)
	public List<T1> selectByCIReceptor(@PathVariable("ci") int ci);
	
	@RequestMapping(value = "/find/rol/{rol}", method = RequestMethod.GET)
	public List<T1> selectByRol(@PathVariable("rol") String rol);
	
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public T1 selectByID(@PathVariable("id") long id);
	
	@RequestMapping(value = "/find/fecha/{fecha}", method = RequestMethod.GET)
	public List<T1> selectByFecha(@PathVariable("fecha") String fecha);
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<T1> list();
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(long id);
}
