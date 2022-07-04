package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Pelicula;

@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula,Long>{
	public List<Pelicula> findByEstadoPelicula(Boolean estadoPelicula);
}
