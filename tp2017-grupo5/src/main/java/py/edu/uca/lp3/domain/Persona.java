package py.edu.uca.lp3.domain;

import javax.persistence.Entity;

import py.edu.uca.lp3.domain.base.BasePersona;

@Entity
public class Persona extends BasePersona
{
	private String rol;

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}	
}
