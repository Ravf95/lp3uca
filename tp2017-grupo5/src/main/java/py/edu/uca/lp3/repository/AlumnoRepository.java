package py.edu.uca.lp3.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.Alumno;

@RepositoryRestResource(collectionResourceRel = "alumno", path = "alumno")
public interface AlumnoRepository extends CrudRepository<Alumno, Long>
{
	Alumno findFirstByci(@Param("ci") int ci);
	
	public Alumno findFirstBymatricula(@Param("matricula") String matricula);
	
	@Transactional
	public void deleteByci(@Param("ci") int ci);
	
	@Transactional
	public void deleteBymatricula(@Param("matricula") String matricula);
}
