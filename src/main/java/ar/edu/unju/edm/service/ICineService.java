package ar.edu.unju.edm.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Pelicula;

@Service
public interface ICineService {
	public List<Pelicula>mostrarCines();
	public void eliminarCine(Integer idCine) throws Exception;
	public void modificarCine(Pelicula cine);
	public Pelicula buscarCine(Long idCine) throws Exception;
	public void guardarCine(@Valid Pelicula cineparaguardar);
}
