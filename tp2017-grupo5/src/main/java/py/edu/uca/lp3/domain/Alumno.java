package py.edu.uca.lp3.domain;

import javax.persistence.Entity;
import py.edu.uca.lp3.domain.base.BasePersona;

@Entity
public class Alumno extends BasePersona
{
	private String matricula;
	private String carrera;
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getCarrera() {
		return carrera;
	}
	
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
} 