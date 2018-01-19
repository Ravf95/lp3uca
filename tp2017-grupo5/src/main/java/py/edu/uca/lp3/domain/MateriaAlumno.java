package py.edu.uca.lp3.domain;

import javax.persistence.Entity;
import py.edu.uca.lp3.domain.base.BaseMateria;

@Entity
public class MateriaAlumno extends BaseMateria
{
	private String matriculaAlumno;

	@javax.persistence.Transient
	private String nombreAlumno; // se obtiene de PN con el ci de la tabla alumno
	
	@javax.persistence.Transient
	private String apellidoAlumno; // se obtiene de PN con el ci de la tabla alumno
	
	@javax.persistence.Transient
	private String carreraAlumno; // se obtiene de alumno
	
	@javax.persistence.Transient
	private String nombreMateria; // se obtiene de materias

	public String getMatriculaAlumno() {
		return matriculaAlumno;
	}

	public void setMatriculaAlumno(String matriculaAlumno) {
		this.matriculaAlumno = matriculaAlumno;
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

	public String getCarreraAlumno() {
		return carreraAlumno;
	}

	public void setCarreraAlumno(String carreraAlumno) {
		this.carreraAlumno = carreraAlumno;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
}
