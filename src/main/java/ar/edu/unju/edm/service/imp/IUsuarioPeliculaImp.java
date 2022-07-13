package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.UsuarioPelicula;
import ar.edu.unju.edm.repository.UsuarioPeliculaRepository;
import ar.edu.unju.edm.service.IUsuarioPeliculaService;
import ar.edu.unju.edm.until.ListadoUsuarioPelicula;

@Service
public class IUsuarioPeliculaImp implements IUsuarioPeliculaService{
	
	@Autowired
	ListadoUsuarioPelicula lista;
 
	@Autowired
	UsuarioPelicula usuariopelicula;
	
	@Autowired 
	UsuarioPeliculaRepository usuarioPelicularepository;

		@Override
		public UsuarioPelicula nuevoUsuarioCine() {
			// TODO Auto-generated method stub
			return usuariopelicula;
		}

		@Override
		public void guardarUsuarioCine(UsuarioPelicula usuariocine) {
			// TODO Auto-generated method stub
			
			usuarioPelicularepository.save (usuariocine);
		}

		@Override
		public void eliminarUsuarioCine(Integer id) throws Exception {
			// TODO Auto-generated method stub
			UsuarioPelicula auxiliar =new UsuarioPelicula();
			auxiliar=buscarUsuarioCine(id);
			auxiliar.setEstado(false);
			usuarioPelicularepository.save(auxiliar);
		}

		@Override
		public void modificarUsuarioCine(UsuarioPelicula usuariocine) {
			// TODO Auto-generated method stub
			usuarioPelicularepository.save(usuariocine);
		}

		@Override
		public List<UsuarioPelicula> listadoUsuariosCine() {
			// TODO Auto-generated method stub
			List<UsuarioPelicula> auxiliar = new ArrayList<>();
			List<UsuarioPelicula> auxiliar2 = new ArrayList<>();
			auxiliar=(List<UsuarioPelicula>) usuarioPelicularepository.findAll();
			for(int i = 0 ;i<auxiliar.size();i++) {
				if (auxiliar.get(i).getEstado()==true) {
					auxiliar2.add(auxiliar.get(i));
				}
			}	
			return auxiliar2;
		}

		@Override
		public UsuarioPelicula buscarUsuarioCine(Integer id) throws Exception {
			// TODO Auto-generated method stub
			UsuarioPelicula peliEncontrado =new UsuarioPelicula();
			for(int i =0 ; i<lista.getListado().size();i++) {
				//SANTI.error("recorriendo:Aaaaaaaaa"+id);
				if(lista.getListado().get(i).getIdUsuarioPelicula().equals(peliEncontrado)) {
					peliEncontrado= lista.getListado().get(i);
				}
			}
			peliEncontrado=usuarioPelicularepository.findById(id).orElseThrow(()->new Exception("USUARIO NO ENCONTRADOOOOOO"));
			return peliEncontrado;
			}

}
