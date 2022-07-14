package ar.edu.unju.edm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.edm.model.Compra;

@Repository
public interface CompraRepository extends CrudRepository <Compra, Integer> {
	

}
