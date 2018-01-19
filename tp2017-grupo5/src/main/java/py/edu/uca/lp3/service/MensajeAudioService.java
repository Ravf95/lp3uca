package py.edu.uca.lp3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.MensajeAudio;
import py.edu.uca.lp3.domain.PoliciaNacional;
import py.edu.uca.lp3.repository.MensajeAudioRepository;
import py.edu.uca.lp3.repository.PoliciaNacionalRepository;
import py.edu.uca.lp3.service.interfaces.IMensajeService;

@Service
public class MensajeAudioService implements IMensajeService<MensajeAudio>
{
	@Autowired
	private MensajeAudioRepository mensajeAudioRepository;
	
	@Autowired
	private PoliciaNacionalRepository pnRepository;
	
	public void save(MensajeAudio mensaje)
	{	
		if (!StringUtils.isNumber(mensaje.getEmisor()))
		{
			System.out.print("Mensaje Audio: Ingresa el CI del Emisor.");
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
		
		mensajeAudioRepository.save(mensaje);
	}
	
	public List<MensajeAudio> findByCIEmisor(String ci)
	{
		if (!StringUtils.isNumber(ci))
			return null;
		
		List<MensajeAudio> list;
		Iterator<MensajeAudio> iteratorAudio;
		
		list = new ArrayList<>();
		iteratorAudio = mensajeAudioRepository.findByemisor(ci).iterator();
		
		while (iteratorAudio.hasNext())
		{
			list.add(iteratorAudio.next());
		}
		
		return list;
	}
	
	public List<MensajeAudio> findByCIReceptor(String ci)
	{
		if (!StringUtils.isNumber(ci))
			return null;
		
		List<MensajeAudio> list;
		Iterator<MensajeAudio> iteratorAudio;
		
		list = new ArrayList<>();
		iteratorAudio = mensajeAudioRepository.findByreceptor(ci).iterator();
		
		while (iteratorAudio.hasNext())
		{
			list.add(iteratorAudio.next());
		}
		
		return list;
	}
	
	public List<MensajeAudio> findByRolR(String rol)
	{
		if (StringUtils.isNumber(rol))
			return null;
		
		List<MensajeAudio> list;
		Iterator<MensajeAudio> iteratorAudio;
		
		list = new ArrayList<>();
		iteratorAudio = mensajeAudioRepository.findByreceptor(rol).iterator();
		
		while (iteratorAudio.hasNext())
		{
			list.add(iteratorAudio.next());
		}
		
		return list;
	}
	
	public MensajeAudio findByID(long id)
	{
		return mensajeAudioRepository.findOne(id);
	}
	
	public List<MensajeAudio> findByFecha(String fecha)
	{
		List<MensajeAudio> list;
		Iterator<MensajeAudio> iteratorAudio;
		
		list = new ArrayList<>();
		iteratorAudio = mensajeAudioRepository.findByfecha(fecha).iterator();
		
		while (iteratorAudio.hasNext())
		{
			list.add(iteratorAudio.next());
		}
		
		return list;
	}
	
	public List<MensajeAudio> findAll()
	{
		List<MensajeAudio> list;
		Iterator<MensajeAudio> iteratorAudio;
		
		list = new ArrayList<>();
		iteratorAudio = mensajeAudioRepository.findAll().iterator();
		
		while (iteratorAudio.hasNext())
		{
			list.add(iteratorAudio.next());
		}
		
		return list;
	}
	
	public void delete(long id)
	{
		if (mensajeAudioRepository.findOne(id) != null)
			mensajeAudioRepository.delete(id);
		else
			System.out.print("Mensaje Audio: no existe.");
	}
}
