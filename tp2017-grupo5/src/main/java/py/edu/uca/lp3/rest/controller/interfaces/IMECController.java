package py.edu.uca.lp3.rest.controller.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.edu.uca.lp3.domain.MEC;

//@RestController
//@RequestMapping("/mec")
public interface IMECController
{
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public MEC selectByID(@PathVariable("id") long id);
	
	@RequestMapping(value = "/find/ci/{ci}", method = RequestMethod.GET)
	public MEC selectByCI(@PathVariable("ci") int ci);
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<MEC> list();
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody MEC persona);
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id);
	
	@RequestMapping(value = "/remove/ci/{ci}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("ci") int ci);
	
	@RequestMapping(value = "/titulo/universitario/id/{id}", method = RequestMethod.GET)
	public boolean checkTituloUniversitarioByID(@PathVariable("id") long id);
	
	@RequestMapping(value = "/titulo/universitario/ci/{ci}", method = RequestMethod.GET)
	public boolean checkTituloUniversitarioByCI(@PathVariable("ci") int ci);
	
	@RequestMapping(value = "/titulo/secundario/id/{id}", method = RequestMethod.GET)
	public boolean checkTituloSercundarioByID(@PathVariable("id") long id);
	
	@RequestMapping(value = "/titulo/secundario/ci/{ci}", method = RequestMethod.GET)
	public boolean checkTituloSercundarioByCI(@PathVariable("ci") int ci);
	
	@RequestMapping(value = "/find/titulo/secundario/{titulo}", method = RequestMethod.GET)
	public List<MEC> listTituloSecundario(@PathVariable("titulo") String tituloSecundario);
	
	@RequestMapping(value = "/find/titulo/universitario/{titulo}", method = RequestMethod.GET)
	public List<MEC> listTituloUniversitario(@PathVariable("titulo") String tituloUniversitario);
}
