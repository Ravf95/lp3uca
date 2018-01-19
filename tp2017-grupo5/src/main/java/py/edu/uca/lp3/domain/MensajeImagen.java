package py.edu.uca.lp3.domain;

import javax.persistence.Entity;

import py.edu.uca.lp3.domain.base.BaseMensaje;

@Entity
public class MensajeImagen extends BaseMensaje 
{
	String mensaje;

	public MensajeImagen()
	{
		super.setTipo("Imagen");
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
