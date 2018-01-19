package py.edu.uca.lp3.repository;

import java.util.List;

import py.edu.uca.lp3.domain.Persona;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "persona", path = "persona")
public interface PersonaRepository extends CrudRepository<Persona, Long>
{
	Persona findFirstByci(@Param("ci") int ci);
	
	@Transactional
	void deleteByci(@Param("ci") int ci);
	
	List <Persona> findByrolLike(@Param("rol") String rol);
}