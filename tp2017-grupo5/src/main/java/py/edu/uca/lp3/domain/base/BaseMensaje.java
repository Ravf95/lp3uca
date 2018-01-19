package py.edu.uca.lp3.domain.base;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseMensaje 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String fecha;
	private String emisor;
	private String receptor;
	
	@javax.persistence.Transient
	private String tipo;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getEmisor() {
		return emisor;
	}
	
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	
	public String getReceptor() {
		return receptor;
	}
	
	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
