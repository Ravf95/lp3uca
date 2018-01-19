package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.MateriaAlumno;

@RepositoryRestResource(collectionResourceRel = "materiaalumno", path = "materiaalumno")
public interface MateriaAlumnoRepository extends CrudRepository<MateriaAlumno, Long>
{
	public List<MateriaAlumno> findBymatriculaAlumno(@Param("matriculaAlumno") String matriculaAlumno);
	public List<MateriaAlumno> findBycodigo(@Param("codigo") String codigoMateria);
}
