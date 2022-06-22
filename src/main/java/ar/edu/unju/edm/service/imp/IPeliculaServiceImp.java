package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Pelicula;
import ar.edu.unju.edm.repository.PeliculaRepository;
import ar.edu.unju.edm.service.IPeliculaService;
import ar.edu.unju.edm.until.ListaPelicula;

@Service
public class IPeliculaServiceImp implements IPeliculaService{
	
	@Autowired
	ListaPelicula lista;
	@Autowired
	PeliculaRepository peliculaRepository;
	
	@Override
	public void guardarPelicula(@Valid Pelicula peliculaparaguardar) {
		// TODO Auto-generated method stub
		
		peliculaRepository.save(peliculaparaguardar);
	}

	@Override
	public void modificarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPelicula(Long idPelicula) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pelicula buscarPelicula(Long idPelicula) throws Exception {
		// TODO Auto-generated method stub
		
		Pelicula peliculaEncontrada = new Pelicula();
		
		peliculaEncontrada = peliculaRepository.findById(idPelicula).orElseThrow(()->new Exception("Pelicula No Encontrada"));
		
		return null;
	}

	@Override
	public List<Pelicula> mostrarPeliculas() {
		// TODO Auto-generated method stub
		
		List<Pelicula> auxiliar = new ArrayList<>();
		
		auxiliar=(List<Pelicula>) peliculaRepository.findAll();
		
		return auxiliar;
	}

}
