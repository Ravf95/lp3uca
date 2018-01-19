package py.edu.uca.lp3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.MensajeTexto;
import py.edu.uca.lp3.domain.PoliciaNacional;
import py.edu.uca.lp3.repository.MensajeTextoRepository;
import py.edu.uca.lp3.repository.PoliciaNacionalRepository;
import py.edu.uca.lp3.service.interfaces.IMensajeService;

@Service
public class MensajeTextoService implements IMensajeService<MensajeTexto>
{
	@Autowired
	private MensajeTextoRepository mensajeTextoRepository;
	
	@Autowired
	private PoliciaNacionalRepository pnRepository;
	
	public void save(MensajeTexto mensaje)
	{	
		if (!StringUtils.isNumber(mensaje.getEmisor()))
		{
			System.out.print("Mensaje Texto: Ingresa el CI del Emisor.");
			return;
		}
		
		int ci;
		PoliciaNacional personaDocumentada;

		ci = Integer.parseInt(mensaje.getEmisor());
		personaDocumentada = pnRepository.findFirstByci(ci);
		
		if (personaDocumentada == null)
		{
			System.out.print("PN: El CI del emisor no existe.");
			return ;
		}
		
		if (StringUtils.isNumber(mensaje.getReceptor()))
		{
			ci = Integer.parseInt(mensaje.getReceptor());
			personaDocumentada = pnRepository.findFirstByci(ci);
			
			if (personaDocumentada == null)
			{
				System.out.print("PN: El CI del recptor no existe.");
				return;
			}		
		}
		
		mensajeTextoRepository.save(mensaje);
	}
	
	public List<MensajeTexto> findByCIEmisor(String ci)
	{
		if (!StringUtils.isNumber(ci))
			return null;
		
		List<MensajeTexto> list;
		Iterator<MensajeTexto> iteratorTexto;
		
		list = new ArrayList<>();
		iteratorTexto = mensajeTextoRepository.findByemisor(ci).iterator();
		
		while (iteratorTexto.hasNext())
		{
			list.add(iteratorTexto.next());
		}
		
		return list;
	}
	
	public List<MensajeTexto> findByCIReceptor(String ci)
	{
		if (!StringUtils.isNumber(ci))
			return null;
		
		List<MensajeTexto> list;
		Iterator<MensajeTexto> iteratorTexto;
		
		list = new ArrayList<>();
		iteratorTexto = mensajeTextoRepository.findByreceptor(ci).iterator();
		
		while (iteratorTexto.hasNext())
		{
			list.add(iteratorTexto.next());
		}
		
		return list;
	}
	
	public List<MensajeTexto> findByRolR(String rol)
	{
		if (StringUtils.isNumber(rol))
			return null;
		
		List<MensajeTexto> list;
		Iterator<MensajeTexto> iteratorTexto;
		
		list = new ArrayList<>();
		iteratorTexto = mensajeTextoRepository.findByreceptor(rol).iterator();
		
		while (iteratorTexto.hasNext())
		{
			list.add(iteratorTexto.next());
		}
		
		return list;
	}
	
	public MensajeTexto findByID(long id)
	{
		return mensajeTextoRepository.findOne(id);
	}
	
	public List<MensajeTexto> findByFecha(String fecha)
	{
		List<MensajeTexto> list;
		Iterator<MensajeTexto> iteratorTexto;
		
		list = new ArrayList<>();
		iteratorTexto = mensajeTextoRepository.findByfecha(fecha).iterator();
		
		while (iteratorTexto.hasNext())
		{
			list.add(iteratorTexto.next());
		}
		
		return list;
	}
	
	public List<MensajeTexto> findAll()
	{
		List<MensajeTexto> list;
		Iterator<MensajeTexto> iteratorTexto;
		
		list = new ArrayList<>();
		iteratorTexto = mensajeTextoRepository.findAll().iterator();
		
		while (iteratorTexto.hasNext())
		{
			list.add(iteratorTexto.next());
		}
		
		return list;
	}
	
	public void delete(long id)
	{
		if (mensajeTextoRepository.findOne(id) != null)
			mensajeTextoRepository.delete(id);
		else
			System.out.print("Mensaje Texto: no existe.");
	}
}
