package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.UsuarioPelicula;
import ar.edu.unju.edm.repository.UsuarioPeliculaRepository;
import ar.edu.unju.edm.service.IUsuarioPeliculaService;

@Service
public class IUsuarioPeliculaImp implements IUsuarioPeliculaService{
	@Autowired
	UsuarioPelicula usuariopelicula;
	
	@Autowired 
	UsuarioPeliculaRepository usuariopelicularepository;

		@Override
		public UsuarioPelicula nuevoUsuarioPelicula() {
			// TODO Auto-generated method stub
			return usuariopelicula;
		}

		@Override
		public void guardarUsuarioPelicula(UsuarioPelicula usuariopelicula) {
			// TODO Auto-generated method stub
			usuariopelicularepository.save (usuariopelicula);
		}

		@Override
		public void eliminarUsuarioCine(Integer id) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void modificarUsuarioCine(UsuarioPelicula usuariocine) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<UsuarioPelicula> listadoUsuariosPelicula() {
			// TODO Auto-generated method stub
			return (List<UsuarioPelicula>) usuariopelicularepository.findAll();
		}

		@Override
		public UsuarioPelicula buscarUsuarioCine(Integer id) throws Exception {
			// TODO Auto-generated method stub
			return usuariopelicularepository.findById(id).orElseThrow(()-> new Exception("UsuarioCine no encontrado"));
		}

		@Override
		public List<UsuarioPelicula> listadoUsuariosPelicula() {
			// TODO Auto-generated method stub
			return null;
		}

}
