package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.Nota;
import py.edu.uca.lp3.rest.controller.interfaces.INotaController;
import py.edu.uca.lp3.service.NotaService;

@RestController
@RequestMapping("/nota")
public class NotaController implements INotaController
{
	@Autowired
	NotaService notaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@RequestBody Nota nota) 
	{
		notaService.asignarNota(nota);
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<Nota> list() 
	{
		return notaService.findAll();
	}
	
	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public Nota selectByID(@PathVariable("id") long id) 
	{
		return notaService.findByID(id);
	}
	
	@RequestMapping(value = "/find/matricula/{matricula}", method = RequestMethod.GET)
	public List<Nota> selectByMatricula(@PathVariable("matricula") String matricula) 
	{
		return notaService.findByMatricula(matricula);
	}
	
	@RequestMapping(value = "/find/codigo/{codigo}", method = RequestMethod.GET)
	public List<Nota> selectByCodigoMateria(@PathVariable("codigo") String codigoMateria) 
	{
		return notaService.findByCodigoMateria(codigoMateria);
	}
	
	@RequestMapping(value = "/find/fecha/{fecha}", method = RequestMethod.GET)
	public List<Nota> selectByfecha(@PathVariable("fecha") String fecha)
	{
		return notaService.findByFecha(fecha);
	}
	
	@RequestMapping(value = "/remove/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id) 
	{
		notaService.delete(id);
	}
}
