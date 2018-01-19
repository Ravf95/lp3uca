package py.edu.uca.lp3.domain;

import javax.persistence.Entity;
import py.edu.uca.lp3.domain.base.BaseMateria;

@Entity
public class Nota extends BaseMateria
{
	private int ciProfesor;
	private String matriculaAlumno;
	private short notaAlumnoMateria;
	private String fecha;
	
	@javax.persistence.Transient
	private String nombreProfesor; // se obtiene de PN con el ci de la tabla profesor
	
	@javax.persistence.Transient
	private String apellidoProfesor; // se obtiene de PN con el ci de la tabla profesor
	
	// validacion de la materia que enseña el profesor
	@javax.persistence.Transient
	private String nombreMateria; // se obtiene de materiasProfesor
	
	// validacion de si el alumno esta cursando la materia
	@javax.persistence.Transient
	private String nombreAlumno; // se obtiene de alumno
	
	@javax.persistence.Transient
	private String apellidoAlumno; // se obtiene de alumno

	public int getCiProfesor() {
		return ciProfesor;
	}
	
	public void setCiProfesor(int ciProfesor) {
		this.ciProfesor = ciProfesor;
	}
	
	public String getMatriculaAlumno() {
		return matriculaAlumno;
	}
	
	public void setMatriculaAlumno(String matriculaAlumno) {
		this.matriculaAlumno = matriculaAlumno;
	}
	
	public short getNotaAlumnoMateria() {
		return notaAlumnoMateria;
	}
	
	public void setNotaAlumnoMateria(short notaAlumnoMateria) {
		this.notaAlumnoMateria = notaAlumnoMateria;
	}
	
	public String getNombreProfesor() {
		return nombreProfesor;
	}
	
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}
	
	public String getApellidoProfesor() {
		return apellidoProfesor;
	}
	
	public void setApellidoProfesor(String apellidoProfesor) {
		this.apellidoProfesor = apellidoProfesor;
	}
	
	public String getNombreMateria() {
		return nombreMateria;
	}
	
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	
	public String getApellidoAlumno() {
		return apellidoAlumno;
	}
	
	public void setApellidoAlumno(String apellidoAlumno) {
		this.apellidoAlumno = apellidoAlumno;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
