package py.edu.uca.lp3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.edu.uca.lp3.domain.MensajeImagen;
import py.edu.uca.lp3.domain.PoliciaNacional;
import py.edu.uca.lp3.repository.MensajeImagenRepository;
import py.edu.uca.lp3.repository.PoliciaNacionalRepository;
import py.edu.uca.lp3.service.interfaces.IMensajeService;

@Service
public class MensajeImagenService implements IMensajeService<MensajeImagen>
{
	@Autowired
	private MensajeImagenRepository mensajeImagenRepository;
	
	@Autowired
	private PoliciaNacionalRepository pnRepository;
	
	public void save(MensajeImagen mensaje)
	{	
		if (!StringUtils.isNumber(mensaje.getEmisor()))
		{
			System.out.print("Mensaje Imagen: Ingresa el CI del Emisor.");
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
		
		mensajeImagenRepository.save(mensaje);
	}
	
	public List<MensajeImagen> findByCIEmisor(String ci)
	{
		if (!StringUtils.isNumber(ci))
			return null;
		
		List<MensajeImagen> list;
		Iterator<MensajeImagen> iteratorImagen;
		
		list = new ArrayList<>();
		iteratorImagen = mensajeImagenRepository.findByemisor(ci).iterator();
		
		while (iteratorImagen.hasNext())
		{
			list.add(iteratorImagen.next());
		}
		
		return list;
	}
	
	public List<MensajeImagen> findByCIReceptor(String ci)
	{
		if (!StringUtils.isNumber(ci))
			return null;
		
		List<MensajeImagen> list;
		Iterator<MensajeImagen> iteratorImagen;
		
		list = new ArrayList<>();
		iteratorImagen = mensajeImagenRepository.findByreceptor(ci).iterator();
		
		while (iteratorImagen.hasNext())
		{
			list.add(iteratorImagen.next());
		}
		
		return list;
	}
	
	public List<MensajeImagen> findByRolR(String rol)
	{
		if (StringUtils.isNumber(rol))
			return null;
		
		List<MensajeImagen> list;
		Iterator<MensajeImagen> iteratorImagen;
		
		list = new ArrayList<>();
		iteratorImagen = mensajeImagenRepository.findByreceptor(rol).iterator();
		
		while (iteratorImagen.hasNext())
		{
			list.add(iteratorImagen.next());
		}
		
		return list;
	}
	
	public MensajeImagen findByID(long id)
	{
		return mensajeImagenRepository.findOne(id);
	}
	
	public List<MensajeImagen> findByFecha(String fecha)
	{
		List<MensajeImagen> list;
		Iterator<MensajeImagen> iteratorImagen;
		
		list = new ArrayList<>();
		iteratorImagen = mensajeImagenRepository.findByfecha(fecha).iterator();
		
		while (iteratorImagen.hasNext())
		{
			list.add(iteratorImagen.next());
		}
		
		return list;
	}
	
	public List<MensajeImagen> findAll()
	{
		List<MensajeImagen> list;
		Iterator<MensajeImagen> iteratorImagen;
		
		list = new ArrayList<>();
		iteratorImagen = mensajeImagenRepository.findAll().iterator();
		
		while (iteratorImagen.hasNext())
		{
			list.add(iteratorImagen.next());
		}
		
		return list;
	}
	
	public void delete(long id)
	{
		if (mensajeImagenRepository.findOne(id) != null)
			mensajeImagenRepository.delete(id);
		else
			System.out.print("Mensaje Imagen: no existe.");
	}
}
