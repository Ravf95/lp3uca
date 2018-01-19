package py.edu.uca.lp3.domain;

import javax.persistence.Entity;
import py.edu.uca.lp3.domain.base.BaseMateria;

@Entity
public class MateriaProfesor extends BaseMateria
{
	private int ci;
	
	@javax.persistence.Transient
	private String nombreProfesor; // se obtiene de PN con el ci de la tabla profesor
	
	@javax.persistence.Transient
	private String apellidoProfesor;  // se obtiene de PN con el ci de la tabla profesor
	
	@javax.persistence.Transient
	private String nombreMateria; // se obtiene de materias;

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
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
}
