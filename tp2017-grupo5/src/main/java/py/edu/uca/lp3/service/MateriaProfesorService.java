package py.edu.uca.lp3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.Profesor;
import py.edu.uca.lp3.domain.Materia;
import py.edu.uca.lp3.domain.MateriaProfesor;
import py.edu.uca.lp3.domain.PoliciaNacional;
import py.edu.uca.lp3.repository.MateriaProfesorRepository;
import py.edu.uca.lp3.repository.MateriaRepository;
import py.edu.uca.lp3.repository.PoliciaNacionalRepository;
import py.edu.uca.lp3.repository.ProfesorRepository;
import py.edu.uca.lp3.service.interfaces.IMateriaProfesorService;

@Service
public class MateriaProfesorService implements IMateriaProfesorService
{
	@Autowired
	MateriaProfesorRepository materiaProfesorRepository;
	
	@Autowired
	PoliciaNacionalRepository pnRepository;
	
	@Autowired
	MateriaRepository materiaRepository;
	
	@Autowired
	ProfesorRepository profesorRepository;
	
	public void asignarMateria(MateriaProfesor materia) 
	{
		int ci;
		ci = materia.getCi();
		
		if (pnRepository.findFirstByci(ci) == null)
		{
			System.out.print("PN: no existe.");
			return;
		}
		
		if (materiaRepository.findBycodigo(materia.getCodigo()) == null)
		{
			System.out.print("Materia: no existe.");
			return;
		}
		
		materiaProfesorRepository.save(materia);
	}
	
	public MateriaProfesor findByID(long id) 
	{
		MateriaProfesor materiaProfesor;
		materiaProfesor = materiaProfesorRepository.findOne(id);
		
		if (materiaProfesor == null)
		{
			System.out.print("Materia Profesor: no existe.");
			return null;
		}
		
		Profesor profesor;		
		profesor = profesorRepository.findFirstByci(materiaProfesor.getCi());

		if (profesor == null)
		{
			System.out.print("Profesor: no existe.");
			return null;
		}
		
		PoliciaNacional personaDocumentada;
		personaDocumentada = pnRepository.findFirstByci(profesor.getCi());		

		if (personaDocumentada == null)
		{
			System.out.print("PN: no existe.");
			return null;
		}
		
		Materia materia;
		materia = materiaRepository.findBycodigo(materiaProfesor.getCodigo());

		if (materia == null)
		{
			System.out.print("Materia: no existe.");
			return null;
		}
		
		materiaProfesor.setNombreProfesor(personaDocumentada.getNombres());
		materiaProfesor.setApellidoProfesor(personaDocumentada.getApellidos());
		materiaProfesor.setNombreMateria(materia.getNombre());
		
		return materiaProfesor;
	}
	
	public List<MateriaProfesor> list() 
	{
		Profesor profesor;
		Materia materia;
		MateriaProfesor materiaProfesor;
		PoliciaNacional personaDocumentada;
		
		List<MateriaProfesor> list;
		Iterator<MateriaProfesor> iterator;
		
		list = new ArrayList<>();
		iterator = materiaProfesorRepository.findAll().iterator();
		
		while (iterator.hasNext())
		{
			materiaProfesor = iterator.next();
			profesor = profesorRepository.findFirstByci(materiaProfesor.getCi());

			if (profesor == null)
				continue;

			personaDocumentada = pnRepository.findFirstByci(profesor.getCi());
			
			if (personaDocumentada == null)
				continue;
			
			materia = materiaRepository.findBycodigo(materiaProfesor.getCodigo());
			
			if (materia == null)
				continue;
			
			materiaProfesor.setNombreProfesor(personaDocumentada.getNombres());
			materiaProfesor.setApellidoProfesor(personaDocumentada.getApellidos());
			materiaProfesor.setNombreMateria(materia.getNombre());
	
			list.add(materiaProfesor);
		}
		
		return list;
	}
	
	public List<MateriaProfesor> findByCodigoMateria(String codigoMateria) 
	{
		Profesor profesor;
		Materia materia;
		MateriaProfesor materiaProfesor;
		PoliciaNacional personaDocumentada;
		
		List<MateriaProfesor> list;
		Iterator<MateriaProfesor> iterator;
		
		list = new ArrayList<>();
		iterator = materiaProfesorRepository.findBycodigo(codigoMateria).iterator();
		
		while (iterator.hasNext())
		{
			materiaProfesor = iterator.next();
			
			profesor = profesorRepository.findFirstByci(materiaProfesor.getCi());
			personaDocumentada = pnRepository.findFirstByci(profesor.getCi());
			
			if (personaDocumentada == null)
				continue;
			
			materia = materiaRepository.findBycodigo(materiaProfesor.getCodigo());
			
			if (materia == null)
				continue;
			
			materiaProfesor.setNombreProfesor(personaDocumentada.getNombres());
			materiaProfesor.setApellidoProfesor(personaDocumentada.getApellidos());
			materiaProfesor.setNombreMateria(materia.getNombre());
			
			list.add(materiaProfesor);			
		}
		
		return list;
	}
	
	public List<MateriaProfesor> findByCIProfesor(int ciProfesor) 
	{
		PoliciaNacional personaDocumentada;
		personaDocumentada = pnRepository.findFirstByci(ciProfesor);
		
		if (personaDocumentada == null)
			return null;
		
		Profesor profesor;
		profesor = profesorRepository.findFirstByci(ciProfesor);
		
		if (profesor == null)
			return null;

		Materia materia;
		MateriaProfesor materiaProfesor;
		
		List<MateriaProfesor> list;
		Iterator<MateriaProfesor> iterator;
		
		list = new ArrayList<>();
		iterator = materiaProfesorRepository.findFirstByci(profesor.getCi()).iterator();
		
		while (iterator.hasNext())
		{
			materiaProfesor = iterator.next();
			materia = materiaRepository.findBycodigo(materiaProfesor.getCodigo());
			
			if (materia == null)
				continue;
			
			materiaProfesor.setNombreProfesor(personaDocumentada.getNombres());
			materiaProfesor.setApellidoProfesor(personaDocumentada.getApellidos());
			materiaProfesor.setNombreMateria(materia.getNombre());
			
			list.add(materiaProfesor);			
		}
		
		return list;
	}
	
	public void delete(long id)
	{
		if (materiaProfesorRepository.findOne(id) != null)
			materiaProfesorRepository.delete(id);
		else
			System.out.print("Materia Profesor: no existe.");
	}
}