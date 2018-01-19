package py.edu.uca.lp3.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.Profesor;

@RepositoryRestResource(collectionResourceRel = "profesor", path = "profesor")
public interface ProfesorRepository extends CrudRepository<Profesor, Long>
{
	public Profesor findFirstByci(@Param("ci") int ci);
	
	@Transactional
	public void deleteByci(@Param("ci") int ci); // all
}
