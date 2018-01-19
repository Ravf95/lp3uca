package py.edu.uca.lp3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.Alumno;
import py.edu.uca.lp3.domain.MEC;
import py.edu.uca.lp3.domain.Persona;
import py.edu.uca.lp3.domain.PoliciaNacional;
import py.edu.uca.lp3.repository.AlumnoRepository;
import py.edu.uca.lp3.repository.MECRepository;
import py.edu.uca.lp3.repository.PersonaRepository;
import py.edu.uca.lp3.repository.PoliciaNacionalRepository;
import py.edu.uca.lp3.service.interfaces.IAlumnoService;

@Service
public class AlumnoService implements IAlumnoService
{
	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	MECRepository mecRepository;
	
	@Autowired
	PoliciaNacionalRepository pnRepository;
	
	public Alumno findByID(long id)
	{
		Alumno alumno;
		alumno = alumnoRepository.findOne(id);
		
		if (alumno == null)
		{
			System.out.print("Alumno: no existe.");
			return null;
		}
		
		int ci;
		PoliciaNacional pn;
		
		ci = alumno.getCi();
		pn = pnRepository.findFirstByci(ci);
		
		if (pn == null)
		{
			System.out.print("PN: no existe.");
			return null;
		}
		
		alumno.setNombres(pn.getNombres());
		alumno.setApellidos(pn.getApellidos());
		
		return alumno;
	}
	
	public Alumno findByCI(int ci)
	{
		Alumno alumno;
		alumno = alumnoRepository.findFirstByci(ci);
		
		if (alumno == null)
		{
			System.out.print("Alumno: no existe.");
			return null;
		}
		
		PoliciaNacional pn;
		pn = pnRepository.findFirstByci(ci);
		
		if (pn == null)
		{
			System.out.print("PN: no existe.");
			return null;
		}
		
		alumno.setNombres(pn.getNombres());
		alumno.setApellidos(pn.getApellidos());
		
		return alumno;
	}
	
	public Alumno findByMatricula(String matricula)
	{
		Alumno alumno;
		alumno = alumnoRepository.findFirstBymatricula(matricula);
		
		if (alumno == null)
		{
			System.out.print("Alumno: no existe.");
			return null;
		}
		
		int ci;
		PoliciaNacional pn;
		
		ci = alumno.getCi();
		pn = pnRepository.findFirstByci(ci);
		
		if (pn == null)
		{
			System.out.print("PN: no existe.");
			return null;
		}
		
		alumno.setNombres(pn.getNombres());
		alumno.setApellidos(pn.getApellidos());
		
		return alumno;
	}
	
	public List<Alumno> findAll()
	{
		List<Alumno> list;
		Iterator<Alumno> iterator;
		
		int ci;
		Alumno alumno;
		PoliciaNacional pn;
		
		list = new ArrayList<>();
		iterator = alumnoRepository.findAll().iterator();
		
		while (iterator.hasNext())
		{
			alumno = iterator.next();
			ci = alumno.getCi();
			pn = pnRepository.findFirstByci(ci);
			
			if (pn == null)
			{
				System.out.print("PN: no existe " + ci + ".");
				continue;
			}
			
			alumno.setNombres(pn.getNombres());
			alumno.setApellidos(pn.getApellidos());
			list.add(alumno);
		}
		
		return list;
	}
	
	public void save(Alumno alumno)
	{
		int ci;
		MEC mec;
		Persona persona;
		
		ci = alumno.getCi();
		
		if (alumnoRepository.findFirstByci(ci) != null)
		{
			System.out.print("Alumno: ya existe " + ci + ".");
			return;
		}
		
		if (alumnoRepository.findFirstBymatricula(alumno.getMatricula()) != null)
		{
			System.out.print("Alumno: ya existe " + alumno.getMatricula() + ".");
			return;
		}
		
		persona = personaRepository.findFirstByci(ci);
		
		if (persona == null)
		{
			System.out.print("Persona: no existe.");
			return;
		}
		
		if (persona.getRol().compareToIgnoreCase("Estudiante") != 0)
		{
			System.out.print("Persona: no tiene rol de Estudiante.");
			return;
		}
		
		mec = mecRepository.findFirstByci(ci);
		
		if (mec == null)
		{
			System.out.print("MEC: no existe el alumno con ci " + ci + ".");
			return;
		}
		
		if (mec.getTituloSecundario() == null)
		{
			System.out.print("MEC: el alumno con ci " + ci + " no termino la secundaria.");
			return;
		}
		
		alumnoRepository.save(alumno);
	}
	
	public void delete(long id)
	{
		if (alumnoRepository.findOne(id) != null)
			alumnoRepository.delete(id);
		else
			System.out.print("Alumno: no existe.");
	}
	
	public void delete(int ci)
	{
		if (alumnoRepository.findFirstByci(ci) != null)
			alumnoRepository.deleteByci(ci);
		else
			System.out.print("Alumno: no existe.");
	}
	
	public void delete(String matricula)
	{
		if (alumnoRepository.findFirstBymatricula(matricula) != null)
			alumnoRepository.deleteBymatricula(matricula);
		else
			System.out.print("Alumno: no existe.");
	}
}
