package py.edu.uca.lp3.service.interfaces;

import java.util.List;

import py.edu.uca.lp3.domain.MEC;

public interface IMECService 
{
	public MEC findByID(long id);
	public MEC findByCI(int ci);
	public List<MEC> findAll();
	public void save(MEC persona);
	public void delete(long id);
	public void delete(int ci);
	public boolean checkTituloUniversitarioByID(long id);
	public boolean checkTituloUniversitarioByCI(int ci);
	public boolean checkTituloSercundarioByID(long id);
	public boolean checkTituloSercundarioByCI(int ci);
	public List<MEC> listByTituloSecundario(String tituloSecundario);
	public List<MEC> listByTituloUniversitario(String tituloUniversitario);
}
