package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import py.edu.uca.lp3.domain.Nota;

@RepositoryRestResource(collectionResourceRel = "nota", path = "nota")
public interface NotaRepository extends CrudRepository<Nota, Long>
{
	public List<Nota> findBymatriculaAlumno (@Param("matriculaAlumno") String matriculaAlumno);
	public List<Nota> findBycodigo (@Param("codigo") String codigo);
	public List<Nota> findByfecha(@Param("fecha") String fecha);
}
