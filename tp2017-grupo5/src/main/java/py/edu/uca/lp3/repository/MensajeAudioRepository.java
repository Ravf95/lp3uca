package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import py.edu.uca.lp3.domain.MensajeAudio;

@RepositoryRestResource(collectionResourceRel = "mensaje", path = "mensaje")
public interface MensajeAudioRepository extends CrudRepository<MensajeAudio, Long>
{
	public List<MensajeAudio> findByemisor(@Param("emisor") String emisor);
	public List<MensajeAudio> findByreceptor(@Param("receptor") String receptor);
	public List<MensajeAudio> findByfecha(@Param("fecha") String fecha);
}