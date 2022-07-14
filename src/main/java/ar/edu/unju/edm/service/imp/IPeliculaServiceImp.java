package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;
//import javax.validation.Valid;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import ar.edu.unju.edm.controller.PeliculaController;
import ar.edu.unju.edm.model.Pelicula;
import ar.edu.unju.edm.repository.PeliculaRepository;
import ar.edu.unju.edm.service.IPeliculaService;
import ar.edu.unju.edm.until.ListaPelicula;

@Service
public class IPeliculaServiceImp implements IPeliculaService{
	//private static final Log AGUSTINA = LogFactory.getLog(PeliculaController.class);
	@Autowired
	ListaPelicula lista;
	@Autowired
	PeliculaRepository peliculaRepository;
	

	@Override
	public void guardarPelicula(Pelicula peliculaparaguardar) {
		// TODO Auto-generated method stub
		//System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"+peliculaparaguardar.getNombrePelicula());
		// TODO Auto-generated method stub
		peliculaparaguardar.setEstadoPelicula(true);
		peliculaRepository.save(peliculaparaguardar);
	}

	@Override
	public void modificarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		pelicula.setEstadoPelicula(true);
		  
		peliculaRepository.save(pelicula);
	}

	@Override
	public void eliminarPelicula(Long idPelicula) throws Exception {
		// TODO Auto-generated method stub
		Pelicula auxiliar = new Pelicula();
		auxiliar = buscarPelicula(idPelicula) ;
		auxiliar.setEstadoPelicula(false);
		peliculaRepository.save(auxiliar);
	}

	@Override
	public Pelicula buscarPelicula(Long idPelicula) throws Exception {
		// TODO Auto-generated method stub
		Pelicula peliculaEncontrada = new Pelicula();
		
		peliculaEncontrada=peliculaRepository.findById(idPelicula).orElseThrow(()->new Exception("Pelicula No Encontrado"));
		return peliculaEncontrada;
	}

	@Override
	public List<Pelicula> listadoPelicula() {
		// TODO Auto-generated method stub
		
		List<Pelicula> auxiliar = new ArrayList<>();
		List<Pelicula> auxiliar2 = new ArrayList<>();
		
		auxiliar=(List<Pelicula>) peliculaRepository.findAll();
		for(int i=0;i<auxiliar.size();i++) {
			if(auxiliar.get(i).getEstadoPelicula()==true) {
				auxiliar2.add(auxiliar.get(i));
			}
		}
		
		return auxiliar2;
	}

	
}
