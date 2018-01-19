package py.edu.uca.lp3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.Alumno;
import py.edu.uca.lp3.domain.Materia;
import py.edu.uca.lp3.domain.Nota;
import py.edu.uca.lp3.domain.PoliciaNacional;
import py.edu.uca.lp3.domain.Profesor;
import py.edu.uca.lp3.repository.AlumnoRepository;
import py.edu.uca.lp3.repository.MateriaAlumnoRepository;
import py.edu.uca.lp3.repository.MateriaProfesorRepository;
import py.edu.uca.lp3.repository.MateriaRepository;
import py.edu.uca.lp3.repository.NotaRepository;
import py.edu.uca.lp3.repository.PoliciaNacionalRepository;
import py.edu.uca.lp3.repository.ProfesorRepository;
import py.edu.uca.lp3.service.interfaces.INotaService;

@Service
public class NotaService implements INotaService 
{
	@Autowired
	PoliciaNacionalRepository pnRepository;
	
	@Autowired
	NotaRepository notaRepository;
	
	@Autowired
	MateriaRepository materiaRepository;
	
	@Autowired
	MateriaAlumnoRepository materiaAlumnoRepository;
	
	@Autowired
	MateriaProfesorRepository materiaProfesorRepository;
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Autowired
	ProfesorRepository profesorRepository;

	public void asignarNota(Nota nota) 
	{
		Materia materia;
		materia = materiaRepository.findBycodigo(nota.getCodigo());
		
		if (materia == null)
		{
			System.out.print("Materia: no existe.");
			return;
		}
		
		Alumno alumno;
		alumno = alumnoRepository.findFirstBymatricula(nota.getMatriculaAlumno());
		
		if (alumno == null)
		{
			System.out.print("Alumno: no existe.");
			return;
		}
		
		Profesor profesor;
		profesor = profesorRepository.findFirstByci(nota.getCiProfesor());
		
		if (profesor == null)
		{
			System.out.print("Profesor: no existe.");
			return;
		}
		
		notaRepository.save(nota);
	}
	
	public List<Nota> findAll() 
	{
		Nota nota;
		Alumno alumno;
		Materia materia;
		Profesor profesor;
		PoliciaNacional personaDocumentadaAlumno;
		PoliciaNacional personaDocumentadaProfesor;
		
		List<Nota> list;
		Iterator<Nota> iterator;
		
		list = new ArrayList<>();
		iterator = notaRepository.findAll().iterator();
		
		while (iterator.hasNext())
		{
			nota = iterator.next();
			materia = materiaRepository.findBycodigo(nota.getCodigo());
			
			if (materia == null)
				continue;
			
			alumno = alumnoRepository.findFirstBymatricula(nota.getMatriculaAlumno());
			
			if (alumno == null)
				continue;
			
			profesor = profesorRepository.findFirstByci(nota.getCiProfesor());
			
			if (profesor == null)
				continue;
			
			personaDocumentadaAlumno = pnRepository.findFirstByci(alumno.getCi());
			
			if (personaDocumentadaAlumno == null)
				continue;
			
			personaDocumentadaProfesor = pnRepository.findFirstByci(profesor.getCi());
			
			if (personaDocumentadaProfesor == null)
				continue;
			
			nota.setNombreAlumno(personaDocumentadaAlumno.getNombres());
			nota.setApellidoAlumno(personaDocumentadaAlumno.getApellidos());
			nota.setNombreProfesor(personaDocumentadaProfesor.getNombres());
			nota.setApellidoProfesor(personaDocumentadaProfesor.getApellidos());
			nota.setNombreMateria(materia.getNombre());
			
			list.add(nota);
		}
		
		return list;
	}
	
	public Nota findByID(long id) 
	{
		Nota nota;
		nota = notaRepository.findOne(id);
		
		if (nota == null)
			return null;
		
		Alumno alumno;
		alumno = alumnoRepository.findFirstBymatricula(nota.getMatriculaAlumno());
		
		if (alumno == null)
			return null;
		
		Materia materia;
		materia = materiaRepository.findBycodigo(nota.getCodigo());
		
		if (materia == null)
			return null;
		
		Profesor profesor;
		profesor = profesorRepository.findFirstByci(nota.getCiProfesor());
		
		if (profesor == null)
			return null;
		
		PoliciaNacional personaDocumentadaAlumno;
		personaDocumentadaAlumno = pnRepository.findFirstByci(alumno.getCi());
		
		if (personaDocumentadaAlumno == null)
			return null;
		
		PoliciaNacional personaDocumentadaProfesor;
		personaDocumentadaProfesor = pnRepository.findFirstByci(profesor.getCi());
		
		if (personaDocumentadaProfesor == null)
			return null;
		
		nota.setNombreAlumno(personaDocumentadaAlumno.getNombres());
		nota.setApellidoAlumno(personaDocumentadaAlumno.getApellidos());
		nota.setNombreProfesor(personaDocumentadaProfesor.getNombres());
		nota.setApellidoProfesor(personaDocumentadaProfesor.getApellidos());
		nota.setNombreMateria(materia.getNombre());
		
		return nota;
	}
	
	public List<Nota> findByMatricula(String matricula) 
	{
		Alumno alumno;
		alumno = alumnoRepository.findFirstBymatricula(matricula);
		
		if (alumno == null)
			return null;
		
		PoliciaNacional personaDocumentadaAlumno;
		personaDocumentadaAlumno = pnRepository.findFirstByci(alumno.getCi());
		
		if (personaDocumentadaAlumno == null)
			return null;
		
		Nota nota;
		Materia materia;
		Profesor profesor;
		PoliciaNacional personaDocumentadaProfesor;
		
		List<Nota> list;
		Iterator<Nota> iterator;
		
		list = new ArrayList<>();
		iterator = notaRepository.findBymatriculaAlumno(matricula).iterator();
		
		while (iterator.hasNext())
		{
			nota = iterator.next();
			materia = materiaRepository.findBycodigo(nota.getCodigo());
			
			if (materia == null)
				continue;
			
			profesor = profesorRepository.findFirstByci(nota.getCiProfesor());
			
			if (profesor == null)
				continue;
			
			personaDocumentadaProfesor = pnRepository.findFirstByci(profesor.getCi());
			
			if (personaDocumentadaProfesor == null)
				continue;
			
			nota.setNombreAlumno(personaDocumentadaAlumno.getNombres());
			nota.setApellidoAlumno(personaDocumentadaAlumno.getApellidos());
			nota.setNombreProfesor(personaDocumentadaProfesor.getNombres());
			nota.setApellidoProfesor(personaDocumentadaProfesor.getApellidos());
			nota.setNombreMateria(materia.getNombre());
			
			list.add(nota);
		}
		
		return list;
	}
	
	public List<Nota> findByCodigoMateria(String codigoMateria) 
	{
		Materia materia;
		materia = materiaRepository.findBycodigo(codigoMateria);
		
		if (materia == null)
			return null;
		
		Nota nota;
		Alumno alumno;
		Profesor profesor;
		PoliciaNacional personaDocumentadaAlumno;
		PoliciaNacional personaDocumentadaProfesor;
		
		List<Nota> list;
		Iterator<Nota> iterator;
		
		list = new ArrayList<>();
		iterator = notaRepository.findBycodigo(codigoMateria).iterator();
		
		while (iterator.hasNext())
		{
			nota = iterator.next();
			alumno = alumnoRepository.findFirstBymatricula(nota.getMatriculaAlumno());
			
			if (alumno == null)
				continue;
			
			profesor = profesorRepository.findFirstByci(nota.getCiProfesor());
			
			if (profesor == null)
				continue;
			
			personaDocumentadaAlumno = pnRepository.findFirstByci(alumno.getCi());
			
			if (personaDocumentadaAlumno == null)
				continue;
			
			personaDocumentadaProfesor = pnRepository.findFirstByci(profesor.getCi());
			
			if (personaDocumentadaProfesor == null)
				continue;
			
			nota.setNombreAlumno(personaDocumentadaAlumno.getNombres());
			nota.setApellidoAlumno(personaDocumentadaAlumno.getApellidos());
			nota.setNombreProfesor(personaDocumentadaProfesor.getNombres());
			nota.setApellidoProfesor(personaDocumentadaProfesor.getApellidos());
			nota.setNombreMateria(materia.getNombre());
			
			list.add(nota);
		}
		
		return list;
	}
	
	public List<Nota> findByFecha(String fecha)
	{
		Nota nota;
		Alumno alumno;
		Materia materia;
		Profesor profesor;
		PoliciaNacional personaDocumentadaAlumno;
		PoliciaNacional personaDocumentadaProfesor;
		
		List<Nota> list;
		Iterator<Nota> iterator;
		
		list = new ArrayList<>();
		iterator = notaRepository.findByfecha(fecha).iterator();
		
		while (iterator.hasNext())
		{
			nota = iterator.next();
			materia = materiaRepository.findBycodigo(nota.getCodigo());
			
			if (materia == null)
				continue;
			
			alumno = alumnoRepository.findFirstBymatricula(nota.getMatriculaAlumno());
			
			if (alumno == null)
				continue;
			
			profesor = profesorRepository.findFirstByci(nota.getCiProfesor());
			
			if (profesor == null)
				continue;
			
			personaDocumentadaAlumno = pnRepository.findFirstByci(alumno.getCi());
			
			if (personaDocumentadaAlumno == null)
				continue;
			
			personaDocumentadaProfesor = pnRepository.findFirstByci(profesor.getCi());
			
			if (personaDocumentadaProfesor == null)
				continue;
			
			nota.setNombreAlumno(personaDocumentadaAlumno.getNombres());
			nota.setApellidoAlumno(personaDocumentadaAlumno.getApellidos());
			nota.setNombreProfesor(personaDocumentadaProfesor.getNombres());
			nota.setApellidoProfesor(personaDocumentadaProfesor.getApellidos());
			nota.setNombreMateria(materia.getNombre());
			
			list.add(nota);
		}
		
		return list;
	}
	
	public void delete(long id) 
	{
		if (notaRepository.findOne(id) != null)
			notaRepository.delete(id);
		else
			System.out.print("Nota: no existe el id.");
	}
}
