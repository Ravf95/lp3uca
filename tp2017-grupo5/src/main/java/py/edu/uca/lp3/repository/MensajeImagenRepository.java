package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import py.edu.uca.lp3.domain.MensajeImagen;

@RepositoryRestResource(collectionResourceRel = "mensaje", path = "mensaje")
public interface MensajeImagenRepository extends CrudRepository<MensajeImagen, Long>
{
	public List<MensajeImagen> findByemisor(@Param("emisor") String emisor);
	public List<MensajeImagen> findByreceptor(@Param("receptor") String receptor);
	public List<MensajeImagen> findByfecha(@Param("fecha") String fecha);
}
