package py.edu.uca.lp3.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.MensajeAudio;
import py.edu.uca.lp3.domain.MensajeImagen;
import py.edu.uca.lp3.domain.MensajeTexto;
import py.edu.uca.lp3.domain.MensajeVideo;
import py.edu.uca.lp3.service.MensajeAudioService;
import py.edu.uca.lp3.service.MensajeImagenService;
import py.edu.uca.lp3.service.MensajeTextoService;
import py.edu.uca.lp3.service.MensajeVideoService;

@RestController
@RequestMapping("/mensaje")
public class MensajeController
{
	@Autowired
	MensajeTextoService msjTextoService;
	
	@Autowired
	MensajeAudioService msjAudioService;
	
	@Autowired
	MensajeVideoService msjVideoService;
	
	@Autowired
	MensajeImagenService msjImagenService;
	
	@RequestMapping(value = "/texto", method = RequestMethod.POST)
	public void add(@RequestBody MensajeTexto mensaje) 
	{
		msjTextoService.save(mensaje);
	}

	@RequestMapping(value = "/audio", method = RequestMethod.POST)
	public void add(@RequestBody MensajeAudio mensaje) 
	{
		msjAudioService.save(mensaje);
	}
	
	@RequestMapping(value = "/video", method = RequestMethod.POST)
	public void add(@RequestBody MensajeVideo mensaje) 
	{
		msjVideoService.save(mensaje);
	}
	
	@RequestMapping(value = "/imagen", method = RequestMethod.POST)
	public void add(@RequestBody MensajeImagen mensaje) 
	{
		msjImagenService.save(mensaje);
	}	
	
	@RequestMapping(value = "/find/enviados/ci/{ci}", method = RequestMethod.GET)
	public List<Object> selectByCIEmisor(@PathVariable("ci") String ci) 
	{
		List<Object> list;
		list = new ArrayList<>();
		
		list.add(msjTextoService.findByCIEmisor(ci));
		list.add(msjAudioService.findByCIEmisor(ci));
		list.add(msjVideoService.findByCIEmisor(ci));
		list.add(msjImagenService.findByCIEmisor(ci));
		
		return list;
	}
	
	@RequestMapping(value = "/find/recibidos/ci/{ci}", method = RequestMethod.GET)
	public List<Object> selectByCIReceptor(@PathVariable("ci") String ci) 
	{
		List<Object> list;
		list = new ArrayList<>();
		
		list.add(msjTextoService.findByCIReceptor(ci));
		list.add(msjAudioService.findByCIReceptor(ci));
		list.add(msjVideoService.findByCIReceptor(ci));
		list.add(msjImagenService.findByCIReceptor(ci));
		
		return list;
	}
	
	@RequestMapping(value = "/find/rol/{rol}", method = RequestMethod.GET)
	public List<Object> selectByRol(@PathVariable("rol") String rol) 
	{
		List<Object> list;
		list = new ArrayList<>();
		
		list.add(msjTextoService.findByRolR(rol));
		list.add(msjAudioService.findByRolR(rol));
		list.add(msjVideoService.findByRolR(rol));
		list.add(msjImagenService.findByRolR(rol));
		
		return list;
	}
	
	@RequestMapping(value = "/texto/find/id/{id}", method = RequestMethod.GET)
	public Object selectByIDT(@PathVariable("id") long id) 
	{
		return msjTextoService.findByID(id);
	}
	
	@RequestMapping(value = "/audio/find/id/{id}", method = RequestMethod.GET)
	public Object selectByIDA(@PathVariable("id") long id) 
	{
		return msjAudioService.findByID(id);
	}
	
	@RequestMapping(value = "/imagen/find/id/{id}", method = RequestMethod.GET)
	public Object selectByIDI(@PathVariable("id") long id) 
	{
		return msjImagenService.findByID(id);
	}	

	@RequestMapping(value = "/video/find/id/{id}", method = RequestMethod.GET)
	public Object selectByIDV(@PathVariable("id") long id) 
	{
		return msjVideoService.findByID(id);
	}	
	
	@RequestMapping(value = "/find/fecha/{fecha}", method = RequestMethod.GET)
	public List<Object> selectByFecha(@PathVariable("fecha") String fecha) 
	{
		List<Object> list;
		list = new ArrayList<>();
		
		list.add(msjTextoService.findByFecha(fecha));
		list.add(msjAudioService.findByFecha(fecha));
		list.add(msjVideoService.findByFecha(fecha));
		list.add(msjImagenService.findByFecha(fecha));
		
		return list;
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<Object> list() 
	{
		List<Object> list;
		list = new ArrayList<>();
		
		list.add(msjTextoService.findAll());
		list.add(msjAudioService.findAll());
		list.add(msjVideoService.findAll());
		list.add(msjImagenService.findAll());
		
		return list;
	}
	
	@RequestMapping(value = "/texto/find", method = RequestMethod.GET)
	public List<MensajeTexto> listT()
	{
		return msjTextoService.findAll();
	}
	
	@RequestMapping(value = "/imagen/find", method = RequestMethod.GET)
	public List<MensajeImagen> listI()
	{
		return msjImagenService.findAll();
	}

	@RequestMapping(value = "/audio/find", method = RequestMethod.GET)
	public List<MensajeAudio> listA()
	{
		return msjAudioService.findAll();
	}
	
	@RequestMapping(value = "/video/find", method = RequestMethod.GET)
	public List<MensajeVideo> listV()
	{
		return msjVideoService.findAll();
	}
	
	@RequestMapping(value = "/texto/remove/id/{id}", method = RequestMethod.DELETE)
	public void deleteT(@PathVariable("id") long id) 
	{
		msjTextoService.delete(id);
	}
	
	@RequestMapping(value = "/audio/remove/id/{id}", method = RequestMethod.DELETE)
	public void deleteA(@PathVariable("id") long id) 
	{
		msjAudioService.delete(id);
	}
	
	@RequestMapping(value = "/imagen/remove/id/{id}", method = RequestMethod.DELETE)
	public void deleteI(@PathVariable("id") long id) 
	{
		msjImagenService.delete(id);
	}
	
	@RequestMapping(value = "/video/remove/id/{id}", method = RequestMethod.DELETE)
	public void deleteV(@PathVariable("id") long id) 
	{
		msjVideoService.delete(id);
	}
}
