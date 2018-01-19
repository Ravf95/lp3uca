package py.edu.uca.lp3.service.interfaces;

import java.util.List;

public interface IMensajeService<T>
{
	public void save(T mensaje);
	public List<T> findByCIEmisor(String ci);
	public List<T> findByCIReceptor(String ci);
	public List<T> findByRolR(String rol);
	public T findByID(long id);
	public List<T> findByFecha(String fecha);
	public List<T> findAll();
	public void delete(long id);
}