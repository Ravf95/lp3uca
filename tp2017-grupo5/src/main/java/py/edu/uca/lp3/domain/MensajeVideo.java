package py.edu.uca.lp3.domain;

import javax.persistence.Entity;

import py.edu.uca.lp3.domain.base.BaseMensaje;

@Entity
public class MensajeVideo extends BaseMensaje 
{
	String mensaje;

	public MensajeVideo()
	{
		super.setTipo("Video");
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
