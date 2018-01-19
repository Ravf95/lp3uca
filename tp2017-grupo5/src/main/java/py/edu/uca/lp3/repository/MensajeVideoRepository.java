package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import py.edu.uca.lp3.domain.MensajeVideo;

@RepositoryRestResource(collectionResourceRel = "mensaje", path = "mensaje")
public interface MensajeVideoRepository extends CrudRepository<MensajeVideo, Long>
{
	public List<MensajeVideo> findByemisor(@Param("emisor") String emisor);
	public List<MensajeVideo> findByreceptor(@Param("receptor") String receptor);
	public List<MensajeVideo> findByfecha(@Param("fecha") String fecha);
}
