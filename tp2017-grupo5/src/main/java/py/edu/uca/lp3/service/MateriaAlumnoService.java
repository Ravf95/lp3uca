package py.edu.uca.lp3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.Alumno;
import py.edu.uca.lp3.domain.Materia;
import py.edu.uca.lp3.domain.MateriaAlumno;
import py.edu.uca.lp3.domain.PoliciaNacional;
import py.edu.uca.lp3.repository.AlumnoRepository;
import py.edu.uca.lp3.repository.MateriaAlumnoRepository;
import py.edu.uca.lp3.repository.MateriaRepository;
import py.edu.uca.lp3.repository.PoliciaNacionalRepository;
import py.edu.uca.lp3.service.interfaces.IMateriaAlumnoService;

@Service
public class MateriaAlumnoService implements IMateriaAlumnoService
{
	@Autowired
	MateriaAlumnoRepository materiaAlumnoRepository;
	
	@Autowired
	PoliciaNacionalRepository pnRepository;
	
	@Autowired
	MateriaRepository materiaRepository;
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	public void asignarMateria(MateriaAlumno materia) 
	{
		Alumno alumno;
		String matricula;
		
		matricula = materia.getMatriculaAlumno();
		alumno = alumnoRepository.findFirstBymatricula(matricula);
		
		if (alumno == null)
		{
			System.out.print("Alumno: no existe " + materia.getMatriculaAlumno() + ".");
			return;
		}
		
		int ci;
		ci = alumno.getCi();
		
		if (pnRepository.findFirstByci(ci) == null)
		{
			System.out.print("PN: no existe " + ci + ".");
			return;
		}
		
		if (materiaRepository.findBycodigo(materia.getCodigo()) == null)
		{
			System.out.print("Materia: no existe " + materia.getCodigo() + ".");
			return;
		}
		
		materiaAlumnoRepository.save(materia);
	}
	
	public MateriaAlumno findByID(long id) 
	{
		Alumno alumno;
		Materia materia;
		MateriaAlumno materiaAlumno;
		PoliciaNacional personaDocumentada;
		
		materiaAlumno = materiaAlumnoRepository.findOne(id);
		
		if (materiaAlumno == null)
		{
			System.out.print("Materia: no existe");
			return null;
		}
		
		alumno = alumnoRepository.findFirstBymatricula(materiaAlumno.getMatriculaAlumno());
		personaDocumentada = pnRepository.findFirstByci(alumno.getCi());		

		if (personaDocumentada == null)
		{
			System.out.print("Alumno: El CI del alumno no existe.");
			return null;
		}
		
		materia = materiaRepository.findBycodigo(materiaAlumno.getCodigo());

		if (materia == null)
		{
			System.out.print("Materia: no existe.");
			return null;
		}
		
		materiaAlumno.setNombreAlumno(personaDocumentada.getNombres());
		materiaAlumno.setApellidoAlumno(personaDocumentada.getApellidos());
		materiaAlumno.setCarreraAlumno(alumno.getCarrera());
		materiaAlumno.setNombreMateria(materia.getNombre());
		
		return materiaAlumno;
	}
	
	public List<MateriaAlumno> list() 
	{
		Alumno alumno;
		Materia materia;
		MateriaAlumno materiaAlumno;
		PoliciaNacional personaDocumentada;
		
		List<MateriaAlumno> list;
		Iterator<MateriaAlumno> iterator;
		
		list = new ArrayList<>();
		iterator = materiaAlumnoRepository.findAll().iterator();
		
		while (iterator.hasNext())
		{
			materiaAlumno = iterator.next();
			
			alumno = alumnoRepository.findFirstBymatricula(materiaAlumno.getMatriculaAlumno());
			personaDocumentada = pnRepository.findFirstByci(alumno.getCi());
			
			if (personaDocumentada == null)
			{
				System.out.print("PN: El CI del alumno no existe.");
				continue;
			}
			
			materia = materiaRepository.findBycodigo(materiaAlumno.getCodigo());
			
			if (materia == null)
			{
				System.out.print("Materia: no existe.");
				continue;
			}
			
			materiaAlumno.setNombreAlumno(personaDocumentada.getNombres());
			materiaAlumno.setApellidoAlumno(personaDocumentada.getApellidos());
			materiaAlumno.setCarreraAlumno(alumno.getCarrera());
			materiaAlumno.setNombreMateria(materia.getNombre());
			
			list.add(materiaAlumno);
		}
		
		return list;
	}
	
	public List<MateriaAlumno> findByCodigoMateria(String codigoMateria) 
	{
		Alumno alumno;
		Materia materia;
		MateriaAlumno materiaAlumno;
		PoliciaNacional personaDocumentada;
		
		List<MateriaAlumno> list;
		Iterator<MateriaAlumno> iterator;
		
		list = new ArrayList<>();
		iterator = materiaAlumnoRepository.findBycodigo(codigoMateria).iterator();
		
		while (iterator.hasNext())
		{
			materiaAlumno = iterator.next();
			
			alumno = alumnoRepository.findFirstBymatricula(materiaAlumno.getMatriculaAlumno());
			personaDocumentada = pnRepository.findFirstByci(alumno.getCi());
			
			if (personaDocumentada == null)
			{
				System.out.print("PN: El CI del alumno no existe.");
				continue;
			}
			
			materia = materiaRepository.findBycodigo(materiaAlumno.getCodigo());
			
			if (materia == null)
			{
				System.out.print("Materia: no existe.");
				continue;
			}
			
			materiaAlumno.setNombreAlumno(personaDocumentada.getNombres());
			materiaAlumno.setApellidoAlumno(personaDocumentada.getApellidos());
			materiaAlumno.setCarreraAlumno(alumno.getCarrera());
			materiaAlumno.setNombreMateria(materia.getNombre());
			
			list.add(materiaAlumno);			
		}
		
		return list;
	}
	
	public List<MateriaAlumno> findByCIAlumno(int ciAlumno) 
	{
		PoliciaNacional personaDocumentada;
		personaDocumentada = pnRepository.findFirstByci(ciAlumno);
		
		if (personaDocumentada == null)
		{
			System.out.print("PN: El CI del alumno no existe.");
			return null;
		}
		
		Alumno alumno;
		alumno = alumnoRepository.findFirstByci(ciAlumno);
		
		if (alumno == null)
		{
			System.out.print("Alumno: no existe.");
			return null;
		}
		
		Materia materia;
		MateriaAlumno materiaAlumno;
		
		List<MateriaAlumno> list;
		Iterator<MateriaAlumno> iterator;
		
		list = new ArrayList<>();
		iterator = materiaAlumnoRepository.findBymatriculaAlumno(alumno.getMatricula()).iterator();
		
		while (iterator.hasNext())
		{
			materiaAlumno = iterator.next();
			materia = materiaRepository.findBycodigo(materiaAlumno.getCodigo());
			
			if (materia == null)
			{
				System.out.print("Materia: no existe.");
				continue;
			}
			
			materiaAlumno.setNombreAlumno(personaDocumentada.getNombres());
			materiaAlumno.setApellidoAlumno(personaDocumentada.getApellidos());
			materiaAlumno.setCarreraAlumno(alumno.getCarrera());
			materiaAlumno.setNombreMateria(materia.getNombre());
			
			list.add(materiaAlumno);			
		}
		
		return list;
	}
	
	public List<MateriaAlumno> findByMatriculaAlumno(String matricula) 
	{
		Alumno alumno;
		alumno = alumnoRepository.findFirstBymatricula(matricula);
		
		if (alumno == null)
		{
			System.out.print("Alumno: no existe.");
			return null;
		}
		
		PoliciaNacional personaDocumentada;
		personaDocumentada = pnRepository.findFirstByci(alumno.getCi());
		
		if (personaDocumentada == null)
		{
			System.out.print("PN: no existe.");
			return null;
		}
		
		Materia materia;
		MateriaAlumno materiaAlumno;
		
		List<MateriaAlumno> list;
		Iterator<MateriaAlumno> iterator;
		
		list = new ArrayList<>();
		iterator = materiaAlumnoRepository.findBymatriculaAlumno(matricula).iterator();
		
		while (iterator.hasNext())
		{
			materiaAlumno = iterator.next();
			materia = materiaRepository.findBycodigo(materiaAlumno.getCodigo());
			
			if (materia == null)
			{
				System.out.print("Materia: no existe.");
				continue;
			}
			
			materiaAlumno.setNombreAlumno(personaDocumentada.getNombres());
			materiaAlumno.setApellidoAlumno(personaDocumentada.getApellidos());
			materiaAlumno.setCarreraAlumno(alumno.getCarrera());
			materiaAlumno.setNombreMateria(materia.getNombre());
			
			list.add(materiaAlumno);			
		}
		
		return list;
	}
	
	public void delete(long id) 
	{
		if (materiaAlumnoRepository.findOne(id) != null)
			materiaAlumnoRepository.delete(id);
		else
			System.out.print("Materia: no existe.");
	}
}
