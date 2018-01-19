package py.edu.uca.lp3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.MensajeVideo;
import py.edu.uca.lp3.domain.PoliciaNacional;
import py.edu.uca.lp3.repository.MensajeVideoRepository;
import py.edu.uca.lp3.repository.PoliciaNacionalRepository;
import py.edu.uca.lp3.service.interfaces.IMensajeService;

@Service
public class MensajeVideoService implements IMensajeService<MensajeVideo>
{
	@Autowired
	private MensajeVideoRepository mensajeVideoRepository;
	
	@Autowired
	private PoliciaNacionalRepository pnRepository;
	
	public void save(MensajeVideo mensaje)
	{	
		if (!StringUtils.isNumber(mensaje.getEmisor()))
		{
			System.out.print("Mensaje Video: Ingresa el CI del Emisor.");
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
		
		mensajeVideoRepository.save(mensaje);
	}
	
	public List<MensajeVideo> findByCIEmisor(String ci)
	{
		if (!StringUtils.isNumber(ci))
			return null;
		
		List<MensajeVideo> list;
		Iterator<MensajeVideo> iteratorVideo;
		
		list = new ArrayList<>();
		iteratorVideo = mensajeVideoRepository.findByemisor(ci).iterator();
		
		while (iteratorVideo.hasNext())
		{
			list.add(iteratorVideo.next());
		}
		
		return list;
	}
	
	public List<MensajeVideo> findByCIReceptor(String ci)
	{
		if (!StringUtils.isNumber(ci))
			return null;
		
		List<MensajeVideo> list;
		Iterator<MensajeVideo> iteratorVideo;
		
		list = new ArrayList<>();
		iteratorVideo = mensajeVideoRepository.findByreceptor(ci).iterator();
		
		while (iteratorVideo.hasNext())
		{
			list.add(iteratorVideo.next());
		}
		
		return list;
	}
	
	public List<MensajeVideo> findByRolR(String rol)
	{
		if (StringUtils.isNumber(rol))
			return null;
		
		List<MensajeVideo> list;
		Iterator<MensajeVideo> iteratorVideo;
		
		list = new ArrayList<>();
		iteratorVideo = mensajeVideoRepository.findByreceptor(rol).iterator();
		
		while (iteratorVideo.hasNext())
		{
			list.add(iteratorVideo.next());
		}
		
		return list;
	}
	
	public MensajeVideo findByID(long id)
	{
		return mensajeVideoRepository.findOne(id);
	}
	
	public List<MensajeVideo> findByFecha(String fecha)
	{
		List<MensajeVideo> list;
		Iterator<MensajeVideo> iteratorVideo;
		
		list = new ArrayList<>();
		iteratorVideo = mensajeVideoRepository.findByfecha(fecha).iterator();
		
		while (iteratorVideo.hasNext())
		{
			list.add(iteratorVideo.next());
		}
		
		return list;
	}
	
	public List<MensajeVideo> findAll()
	{
		List<MensajeVideo> list;
		Iterator<MensajeVideo> iteratorVideo;
		
		list = new ArrayList<>();
		iteratorVideo = mensajeVideoRepository.findAll().iterator();
		
		while (iteratorVideo.hasNext())
		{
			list.add(iteratorVideo.next());
		}
		
		return list;
	}
	
	public void delete(long id)
	{
		if (mensajeVideoRepository.findOne(id) != null)
			mensajeVideoRepository.delete(id);
		else
			System.out.print("Mensaje Video: error");
	}
}
