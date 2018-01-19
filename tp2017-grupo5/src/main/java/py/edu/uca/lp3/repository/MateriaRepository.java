package py.edu.uca.lp3.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.Materia;

@RepositoryRestResource(collectionResourceRel = "materia", path = "materia")
public interface MateriaRepository extends CrudRepository<Materia, Long>
{
	public Materia findBycodigo(@Param("codigo") String codigo);
	
	@Transactional
	public void deleteBycodigo(@Param("codigo") String codigoMateria);
}
