package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.edm.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{


		public List<Usuario> findByEstado(Boolean estado);

}