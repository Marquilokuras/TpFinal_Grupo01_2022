package ar.edu.unju.edm.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Pelicula;

@Service
public interface IPeliculaService {
	public void guardarPelicula(@Valid Pelicula peliculaparaguardar);
	public void modificarPelicula(Pelicula pelicula);
	public void eliminarPelicula(Long idPelicula) throws Exception;
	public Pelicula buscarPelicula(Long idPelicula) throws Exception;
	public List<Pelicula> listadoPelicula(); 
}
