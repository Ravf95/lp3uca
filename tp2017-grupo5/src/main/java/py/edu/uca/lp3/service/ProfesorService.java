package py.edu.uca.lp3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.MEC;
import py.edu.uca.lp3.domain.Persona;
import py.edu.uca.lp3.domain.PoliciaNacional;
import py.edu.uca.lp3.domain.Profesor;
import py.edu.uca.lp3.repository.MECRepository;
import py.edu.uca.lp3.repository.PersonaRepository;
import py.edu.uca.lp3.repository.PoliciaNacionalRepository;
import py.edu.uca.lp3.repository.ProfesorRepository;
import py.edu.uca.lp3.service.interfaces.IProfesorService;

@Service
public class ProfesorService implements IProfesorService
{
	@Autowired
	private PoliciaNacionalRepository pnRepository;

	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private MECRepository mecRepository;
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	public Profesor findByID(long id)
	{	
		if (profesorRepository.findOne(id) == null)
		{
			System.out.print("Profesor: no existe.");
			return null;
		}
		
		Profesor profesor;
		profesor = profesorRepository.findOne(id);
		
		profesor.setNombres(pnRepository.findFirstByci(profesor.getCi()).getNombres());
		profesor.setApellidos(pnRepository.findFirstByci(profesor.getCi()).getApellidos());
		profesor.setTitulo(mecRepository.findFirstByci(profesor.getCi()).getTitulo());		
		
		return profesor;
	}
	
	public Profesor findByCI(int ci)
	{
		Profesor profesor;

		if (profesorRepository.findFirstByci(ci) == null)
		{
			System.out.print("Profesor: no existe.");
			return null;
		}
		
		profesor = profesorRepository.findFirstByci(ci);
		profesor.setNombres(pnRepository.findFirstByci(profesor.getCi()).getNombres());
		profesor.setApellidos(pnRepository.findFirstByci(profesor.getCi()).getApellidos());
		profesor.setTitulo(mecRepository.findFirstByci(profesor.getCi()).getTitulo());
		
		return profesor;
	}
	
	public List<Profesor> findAll()
	{
		Profesor profesor;
		List<Profesor> list;
		Iterator<Profesor> iterator;
		
		list = new ArrayList<>();
		iterator = profesorRepository.findAll().iterator();
		
		while (iterator.hasNext())
		{
			profesor = iterator.next();
			profesor.setNombres(pnRepository.findFirstByci(profesor.getCi()).getNombres());
			profesor.setApellidos(pnRepository.findFirstByci(profesor.getCi()).getApellidos());
			profesor.setTitulo(mecRepository.findFirstByci(profesor.getCi()).getTitulo());
			list.add(profesor);
		}
		
		return list;
	}
	
	public void save(Profesor profesor)
	{
		int ci;
		Persona persona;
		
		ci = profesor.getCi();
		persona = personaRepository.findFirstByci(ci);
		
		if (persona == null)
		{
			System.out.print("Persona: no existe.");
			return;
		}
		
		PoliciaNacional personaDocumentada;
		personaDocumentada = pnRepository.findFirstByci(ci);
		
		if (personaDocumentada == null)
		{
			System.out.print("PN: no existe.");
			return;
		}
		
		if (persona.getRol().compareToIgnoreCase("Profesor") != 0)
		{
			System.out.print("Persona: no tiene rol de Profesor.");
			return;
		}
		
		MEC mec;
		mec = mecRepository.findFirstByci(ci);
		
		if (mec == null)
		{
			System.out.print("MEC: no existe.");
			return;
		}
		
		if (mec.getTitulo() == null)
		{
			System.out.print("MEC: no tiene titulo universitario.");
			return;
		}
		
		profesorRepository.save(profesor);
	}
	
	public void delete(long id)
	{
		if (profesorRepository.findOne(id) != null)
			profesorRepository.delete(id);
		else
			System.out.print("Profesor: no existe.");
	}
	
	public void delete(int ci)
	{
		if (profesorRepository.findFirstByci(ci) != null)
			profesorRepository.deleteByci(ci);
		else
			System.out.print("Profesor: no existe.");
	}
}