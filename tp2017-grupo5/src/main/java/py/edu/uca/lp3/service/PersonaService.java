package py.edu.uca.lp3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.Persona;
import py.edu.uca.lp3.domain.PoliciaNacional;
import py.edu.uca.lp3.repository.PersonaRepository;
import py.edu.uca.lp3.repository.PoliciaNacionalRepository;
import py.edu.uca.lp3.service.interfaces.IPersonaService;

@Service
public class PersonaService implements IPersonaService
{
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private PoliciaNacionalRepository pnRepository;
	
	public Persona findByID(long id)
	{
		int ci;
		Persona persona;
		PoliciaNacional personaDocumentada;
		
		persona = personaRepository.findOne(id);
		
		if (persona == null)
		{
			System.out.print("Persona: no existe.");
			return null;
		}
		
		ci = persona.getCi();
		personaDocumentada = pnRepository.findFirstByci(ci);
		
		if (personaDocumentada == null)
		{
			System.out.print("PN: No existe.");
			return null;
		}
		
		persona.setNombres(personaDocumentada.getNombres());
		persona.setApellidos(personaDocumentada.getApellidos());
		
		return persona;
	}
	
	public Persona findByCI(int ci)
	{
		Persona persona;
		PoliciaNacional personaDocumentada;		
		persona = personaRepository.findFirstByci(ci);
		
		if (persona == null)
		{
			System.out.print("Persona: no existe.");
			return null;
		}
		
		personaDocumentada = pnRepository.findFirstByci(ci);
	
		if (personaDocumentada == null)
		{
			System.out.print("PN: No existe.");
			return null;
		}
		
		persona.setNombres(personaDocumentada.getNombres());
		persona.setApellidos(personaDocumentada.getApellidos());
		
		return persona;
	}
	
	public List<Persona> findAll()
	{
		int ci;
		Persona persona;
		List<Persona> list;
		Iterator<Persona> iterator;
		PoliciaNacional personaDocumentada;
		
		list = new ArrayList<>();
		iterator = personaRepository.findAll().iterator();
		
		while (iterator.hasNext())
		{
			persona = iterator.next();
			ci = persona.getCi();
			personaDocumentada = pnRepository.findFirstByci(ci);
			
			if (personaDocumentada == null)
			{
				System.out.print("PN: No existe " + ci + ".");
				return null;
			}
			
			persona.setNombres(personaDocumentada.getNombres());
			persona.setApellidos(personaDocumentada.getApellidos());
			
			list.add(persona);
		}
		
		return list;
	}
	
	public void save(Persona persona)
	{
		int ci;
		ci = persona.getCi();
		PoliciaNacional personaDocumentada;		
		
		personaDocumentada = pnRepository.findFirstByci(ci);
		
		if (personaDocumentada == null)
		{
			System.out.print("PN: No existe la persona " + ci + ".");
			return;
		}
		
		if (StringUtils.isNumber(persona.getRol()))
			return;
		
		personaRepository.save(persona);
	}
	
	public void delete(long id)
	{
		if (personaRepository.findOne(id) != null)
			personaRepository.delete(id);
		else
			System.out.print("Persona: no existe.");
	}
	
	public void delete(int ci)
	{
		if (personaRepository.findFirstByci(ci) != null)
			personaRepository.deleteByci(ci);
		else
			System.out.print("Persona: no existe.");
	}
	
	public List<Persona> findByRol(String rol)
	{
		int ci;
		Persona persona;
		List<Persona> list;
		Iterator<Persona> iterator;
		PoliciaNacional personaDocumentada;
		
		list = new ArrayList<>();
		iterator = personaRepository.findByrolLike(rol).iterator();
		
		while (iterator.hasNext())
		{
			persona = iterator.next();
			ci = persona.getCi();
			personaDocumentada = pnRepository.findFirstByci(ci);
			
			if (personaDocumentada == null)
			{
				System.out.print("PN: No existe la persona " + ci + ".");
				continue;
			}
			
			persona.setNombres(personaDocumentada.getNombres());
			persona.setApellidos(personaDocumentada.getApellidos());
			
			list.add(persona);
		}
		
		return list;
	}
}
