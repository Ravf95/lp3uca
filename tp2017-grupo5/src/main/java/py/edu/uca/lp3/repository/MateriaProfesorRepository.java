package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.MateriaProfesor;

@RepositoryRestResource(collectionResourceRel = "materiaprofesor", path = "materiaprofesor")
public interface MateriaProfesorRepository extends CrudRepository<MateriaProfesor, Long>
{
	public List<MateriaProfesor> findBycodigo(@Param("codigo") String codigoMateria);
	
	public List<MateriaProfesor> findFirstByci(@Param("ci") int ci);
}
