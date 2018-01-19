package py.edu.uca.lp3.domain;

import javax.persistence.Entity;
import py.edu.uca.lp3.domain.base.BaseInstituto;

@Entity
public class MEC extends BaseInstituto
{
	private short year;
	private String titulo;
	private int nResolucion;
	private String fechaResolucion;
	private String tituloSecundario;

	@javax.persistence.Transient
	private String nombres;
	
	@javax.persistence.Transient
	private String apellidos;
	
	@javax.persistence.Transient
	private String rol;
	
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public short getYear() {
		return year;
	}
	
	public void setYear(short year) {
		this.year = year;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getnResolucion() {
		return nResolucion;
	}
	
	public void setnResolucion(int nResolucion) {
		this.nResolucion = nResolucion;
	}
	
	public String getFechaResolucion() {
		return fechaResolucion;
	}
	
	public void setFechaResolucion(String fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}
	
	public String getTituloSecundario() {
		return tituloSecundario;
	}
	
	public void setTituloSecundario(String tituloSecundario) {
		this.tituloSecundario = tituloSecundario;
	}
}
