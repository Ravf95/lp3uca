package py.edu.uca.lp3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.MEC;
import py.edu.uca.lp3.domain.Persona;
import py.edu.uca.lp3.domain.PoliciaNacional;
import py.edu.uca.lp3.repository.MECRepository;
import py.edu.uca.lp3.repository.PersonaRepository;
import py.edu.uca.lp3.repository.PoliciaNacionalRepository;
import py.edu.uca.lp3.service.interfaces.IMECService;

@Service
public class MECService implements IMECService
{
	@Autowired
	MECRepository mecRepository;
	
	@Autowired
	PoliciaNacionalRepository pnRepository;
	
	@Autowired
	PersonaRepository personaRepository;
	
	public MEC findByID(long id)
	{
		int ci;
		MEC persona;
		persona = mecRepository.findOne(id);
		
		if (persona == null)
		{
			System.out.print("MEC: no existe la persona.");
			return null;
		}
		
		ci = persona.getCi();
		
		PoliciaNacional personaDocumentada;
		personaDocumentada = pnRepository.findFirstByci(ci);
		
		if (personaDocumentada == null)
		{
			System.out.print("PN: la persona no existe.");
			return null;
		}
		
		Persona p1;
		p1 = personaRepository.findFirstByci(ci);
		
		if (p1 == null)
		{
			System.out.print("Persona: no existe.");
			return null;
		}
		
		persona.setNombres(personaDocumentada.getNombres());
		persona.setApellidos(personaDocumentada.getApellidos());
		persona.setRol(p1.getRol());
		
		return persona;
	}
	
	public MEC findByCI(int ci)
	{
		MEC persona;
		persona = mecRepository.findFirstByci(ci);
		
		if (persona == null)
		{
			System.out.print("MEC: no existe la persona");
			return null;
		}
		
		PoliciaNacional personaDocumentada;
		personaDocumentada = pnRepository.findFirstByci(ci);
		
		if (personaDocumentada == null)
		{
			System.out.print("PN: la persona no existe.");
			return null;
		}
		
		Persona p1;
		p1 = personaRepository.findFirstByci(ci);
		
		if (p1 == null)
		{
			System.out.print("Persona: no existe.");
			return null;
		}
		
		persona.setNombres(personaDocumentada.getNombres());
		persona.setApellidos(personaDocumentada.getApellidos());
		persona.setRol(p1.getRol());
		
		return persona;
	}
	
	public List<MEC> findAll()
	{
		int ci;
		List<MEC> list;
		Iterator<MEC> iterator;
		
		Persona p1;
		MEC persona;
		PoliciaNacional personaDocumentada;
		
		list = new ArrayList<>();
		iterator = mecRepository.findAll().iterator();
	
		while (iterator.hasNext())
		{
			persona = iterator.next();
			ci = persona.getCi();
			personaDocumentada = pnRepository.findFirstByci(ci);
			
			if (personaDocumentada == null)
			{
				System.out.print("PN: no existe " + ci + ".");
				continue;
			}
			
			p1 = personaRepository.findFirstByci(ci);
			
			if (p1 == null)
			{
				System.out.print("Persona: no existe " + ci + ".");
				continue;
			}
			
			persona.setNombres(personaDocumentada.getNombres());
			persona.setApellidos(personaDocumentada.getApellidos());
			persona.setRol(p1.getRol());
			
			list.add(persona);
		}
		
		return list;
	}
	
	public void save(MEC persona)
	{
		int ci;
		ci = persona.getCi();
		
		if (pnRepository.findFirstByci(ci) == null)
		{
			System.out.print("PN: no existe " + ci + ".");
			return;
		}
		
		mecRepository.save(persona);
	}
	
	public void delete(long id)
	{
		MEC persona;
		persona = mecRepository.findOne(id);
	
		if (persona == null)
			return;		
		
		mecRepository.delete(id);
	}
	
	public void delete(int ci)
	{
		MEC persona;
		persona = mecRepository.findFirstByci(ci);
	
		if (persona == null)
		{
			System.out.print("MEC: no existe la persona.");;
			return;	
		}
		
		mecRepository.deleteByci(ci);
	}
	
	public boolean checkTituloUniversitarioByID(long id)
	{
		String titulo;
		titulo = mecRepository.findOne(id).getTitulo();
		
		if (titulo != null)
			return true;
		
		return false;	
	}
	
	public boolean checkTituloUniversitarioByCI(int ci)
	{
		String titulo;
		titulo = mecRepository.findFirstByci(ci).getTitulo();
		
		if(titulo != null) {
			return true;
		}
		return false;
	}
	
	public boolean checkTituloSercundarioByID(long id)
	{
		String titulosecundario;
		titulosecundario = mecRepository.findOne(id).getTituloSecundario();
		
		if(titulosecundario != null) {
			return true;
		}
		return false;
	}
	
	public boolean checkTituloSercundarioByCI(int ci)
	{
		String titulosecundario;
		titulosecundario = mecRepository.findFirstByci(ci).getTituloSecundario();
		
		if(titulosecundario != null) {
			return true;
		}
		return false;
	}
	
	public List<MEC> listByTituloSecundario(String tituloSecundario)
	{
		if (mecRepository.findBytituloSecundario(tituloSecundario) == null)
			return null;
		
		int ci;
		MEC persona;
		List<MEC> list;
		Iterator<MEC> iterator;
		
		list = new ArrayList<>();
		iterator = mecRepository.findBytituloSecundario(tituloSecundario).iterator();
	
		while (iterator.hasNext())
		{
			persona = iterator.next();
			ci = persona.getCi();
			
			persona.setNombres(pnRepository.findFirstByci(ci).getNombres());
			persona.setApellidos(pnRepository.findFirstByci(ci).getApellidos());
			persona.setRol(personaRepository.findFirstByci(ci).getRol());
			
			list.add(persona);
		}
		
		return list;
	}
	
	public List<MEC> listByTituloUniversitario(String tituloUniversitario)
	{
		if (mecRepository.findBytitulo(tituloUniversitario) == null)
			return null;
		
		int ci;
		MEC persona;
		List<MEC> list;
		Iterator<MEC> iterator;
		
		list = new ArrayList<>();
		iterator = mecRepository.findBytitulo(tituloUniversitario).iterator();
	
		while (iterator.hasNext())
		{
			persona = iterator.next();
			ci = persona.getCi();
			
			persona.setNombres(pnRepository.findFirstByci(ci).getNombres());
			persona.setApellidos(pnRepository.findFirstByci(ci).getApellidos());
			persona.setRol(personaRepository.findFirstByci(ci).getRol());
			list.add(persona);
		}
		
		return list;
	}
}
