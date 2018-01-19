package py.edu.uca.lp3.domain;

import javax.persistence.Entity;

import py.edu.uca.lp3.domain.base.BasePersona;

@Entity
public class Profesor extends BasePersona
{
	@javax.persistence.Transient
	private String titulo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	
}
