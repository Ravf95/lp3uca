package py.edu.uca.lp3.repository;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.MEC;

@RepositoryRestResource(collectionResourceRel = "mec", path = "mec")
public interface MECRepository extends CrudRepository<MEC, Long>
{
	public MEC findFirstByci(@Param("ci") int ci);
	
	public List<MEC> findBytitulo(@Param("titulo") String titulo);
	public List<MEC> findBytituloSecundario(@Param("tituloSecundario") String tituloSecundario);
	
	@Transactional
	public void deleteByci(@Param("ci") int ci);
}
