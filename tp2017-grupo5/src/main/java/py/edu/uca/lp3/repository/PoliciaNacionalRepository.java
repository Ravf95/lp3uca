package py.edu.uca.lp3.repository;

import py.edu.uca.lp3.domain.PoliciaNacional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "pn", path = "pn")
public interface PoliciaNacionalRepository extends CrudRepository<PoliciaNacional, Long>
{
	PoliciaNacional findFirstByci(@Param("ci") int ci);
	
	@Transactional
	void deleteByci(@Param("ci") int ci);
}