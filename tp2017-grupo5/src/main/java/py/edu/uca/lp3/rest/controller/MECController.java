package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.MEC;
import py.edu.uca.lp3.rest.controller.interfaces.IMECController;
import py.edu.uca.lp3.service.MECService;

@RestController
@RequestMapping("/mec")
public class MECController implements IMECController{
	@Autowired
	MECService mecService;
	
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public MEC selectByID(@PathVariable("id") long id) {
		return mecService.findByID(id);
	}
	
	@RequestMapping(value = "/find/ci/{ci}", method = RequestMethod.GET)
	public MEC selectByCI(@PathVariable("ci") int ci) {
		return mecService.findByCI(ci);
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<MEC> list(){
		return mecService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody MEC persona){
		mecService.save(persona);
	}
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id){
		mecService.delete(id);
	}
	
	@RequestMapping(value = "/remove/ci/{ci}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("ci") int ci){
		mecService.delete(ci);
	}
	
	@RequestMapping(value = "/titulo/universitario/id/{id}", method = RequestMethod.GET)
	public boolean checkTituloUniversitarioByID(@PathVariable("id") long id){
		return mecService.checkTituloUniversitarioByID(id);
	}
	
	@RequestMapping(value = "/titulo/universitario/ci/{ci}", method = RequestMethod.GET)
	public boolean checkTituloUniversitarioByCI(@PathVariable("ci") int ci) {
		return mecService.checkTituloUniversitarioByCI(ci);
	}
	
	@RequestMapping(value = "/titulo/secundario/id/{id}", method = RequestMethod.GET)
	public boolean checkTituloSercundarioByID(@PathVariable("id") long id) {
		return mecService.checkTituloSercundarioByID(id);
	}
	
	@RequestMapping(value = "/titulo/secundario/ci/{ci}", method = RequestMethod.GET)
	public boolean checkTituloSercundarioByCI(@PathVariable("ci") int ci) {
		return mecService.checkTituloSercundarioByCI(ci);
	}
	
	@RequestMapping(value = "/find/titulo/secundario/{titulo}", method = RequestMethod.GET)
	public List<MEC> listTituloSecundario(@PathVariable("titulo") String tituloSecundario){
		return mecService.listByTituloSecundario(tituloSecundario);
	}
	
	@RequestMapping(value = "/find/titulo/universitario/{titulo}", method = RequestMethod.GET)
	public List<MEC> listTituloUniversitario(@PathVariable("titulo") String tituloUniversitario){
		return mecService.listByTituloUniversitario(tituloUniversitario);
	}
}
