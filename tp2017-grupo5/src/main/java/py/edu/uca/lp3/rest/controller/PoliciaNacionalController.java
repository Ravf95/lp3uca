package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.PoliciaNacional;
import py.edu.uca.lp3.rest.controller.interfaces.IPoliciaNacionalController;
import py.edu.uca.lp3.service.PoliciaNacionalService;

@RestController
@RequestMapping("/pn")
public class PoliciaNacionalController implements IPoliciaNacionalController
{
	@Autowired
	private PoliciaNacionalService pnService;
	
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public PoliciaNacional selectById(@PathVariable("id") long id)
	{
		return pnService.findByID(id);
	}
	
	@RequestMapping(value = "/find/ci/{ci}", method = RequestMethod.GET)
	public PoliciaNacional selectByCI(@PathVariable("ci") int ci)
	{
		return pnService.findByCI(ci);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody PoliciaNacional pn)
	{
		pnService.save(pn);
	}
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id)
	{
		pnService.delete(id);
	}
	
	@RequestMapping(value = "/remove/ci/{ci}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("ci") int ci)
	{
		pnService.delete(ci);
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<PoliciaNacional> list()
	{
		return pnService.findAll();
	}
}
