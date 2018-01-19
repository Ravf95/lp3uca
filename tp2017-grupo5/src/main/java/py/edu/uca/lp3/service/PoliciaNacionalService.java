package py.edu.uca.lp3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.PoliciaNacional;
import py.edu.uca.lp3.repository.PoliciaNacionalRepository;
import py.edu.uca.lp3.service.interfaces.IPoliciaNacionalService;

@Service
public class PoliciaNacionalService implements IPoliciaNacionalService  
{
	@Autowired
	private PoliciaNacionalRepository pnRepository;
	
	public PoliciaNacional findByID(long id)
	{
		return pnRepository.findOne(id);
	}
	
	public PoliciaNacional findByCI(int ci)
	{
		return pnRepository.findFirstByci(ci);
	}
	
	public List<PoliciaNacional> findAll()
	{
		List<PoliciaNacional> list;
		Iterator<PoliciaNacional> iterator;
		
		list = new ArrayList<>();
		iterator = pnRepository.findAll().iterator();
		
		while (iterator.hasNext())
		{
			list.add(iterator.next());
		}
		
		return list;
	}
	
	public void save(PoliciaNacional persona)
	{
		pnRepository.save(persona);
	}
	
	public void delete(long id)
	{
		pnRepository.delete(id);
	}
	
	public void delete(int ci)
	{
		pnRepository.deleteByci(ci);
	}
}
