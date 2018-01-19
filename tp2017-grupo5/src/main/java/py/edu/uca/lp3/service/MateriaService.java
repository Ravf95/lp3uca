package py.edu.uca.lp3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.Materia;
import py.edu.uca.lp3.repository.MateriaRepository;
import py.edu.uca.lp3.service.interfaces.IMateriaService;

@Service
public class MateriaService implements IMateriaService 
{
	@Autowired
	MateriaRepository materiaRepository;
	
	public Materia findByID(long id) 
	{
		return materiaRepository.findOne(id);
	}
	
	public Materia findByCodigoMateria(String materia) 
	{
		return materiaRepository.findBycodigo(materia);
	}
	
	public List<Materia> findAll() 
	{
		List<Materia> list;
		Iterator<Materia> iterator;
		
		list = new ArrayList<>();
		iterator = materiaRepository.findAll().iterator();
		
		while (iterator.hasNext())
		{
			list.add(iterator.next());
		}
		
		return list;
	}
	
	public void save(Materia materia) 
	{
		if (materiaRepository.findBycodigo(materia.getCodigo()) != null)
		{
			System.out.print("Materia: ya existe.");
			return;
		}
		
		materiaRepository.save(materia);
	}
	
	public void delete(long id) 
	{
		if (materiaRepository.findOne(id) != null)
			materiaRepository.delete(id);
		else
			System.out.print("Materia: no existe.");
	}
	
	public void delete(String codigoMateria) 
	{
		if (materiaRepository.findBycodigo(codigoMateria) != null)
			materiaRepository.deleteBycodigo(codigoMateria);
		else
			System.out.print("Materia: no existe.");
	}	
}
