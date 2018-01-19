package py.edu.uca.lp3.rest.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.edu.uca.lp3.domain.PoliciaNacional;

// @RestController
// @RequestMapping("/pn")
public interface IPoliciaNacionalController 
{
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public PoliciaNacional selectById(@PathVariable("id") long id);
	
	@RequestMapping(value = "/find/ci/{ci}", method = RequestMethod.GET)
	public PoliciaNacional selectByCI(@PathVariable("ci") int ci);
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody PoliciaNacional pn);
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id);
	
	@RequestMapping(value = "/remove/ci/{ci}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("ci") int ci);
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<PoliciaNacional> list();
}
