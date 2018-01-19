package py.edu.uca.lp3.service.interfaces;

import java.util.List;
import py.edu.uca.lp3.domain.PoliciaNacional;

public interface IPoliciaNacionalService 
{
	public PoliciaNacional findByID(long id);
	public PoliciaNacional findByCI(int ci);
	public List<PoliciaNacional> findAll();
	public void save(PoliciaNacional persona);
	public void delete(long id);
	public void delete(int ci);
}