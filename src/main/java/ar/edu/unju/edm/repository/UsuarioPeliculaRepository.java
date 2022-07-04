package ar.edu.unju.edm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.edm.model.UsuarioPelicula;

@Repository
public interface UsuarioPeliculaRepository extends CrudRepository <UsuarioPelicula, Integer> {
	

}
