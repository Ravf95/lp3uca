package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import py.edu.uca.lp3.domain.MensajeTexto;

@RepositoryRestResource(collectionResourceRel = "mensaje", path = "mensaje")
public interface MensajeTextoRepository extends CrudRepository<MensajeTexto, Long>
{
	public List<MensajeTexto> findByemisor(@Param("emisor") String emisor);
	public List<MensajeTexto> findByreceptor(@Param("receptor") String receptor);
	public List<MensajeTexto> findByfecha(@Param("fecha") String fecha);
}