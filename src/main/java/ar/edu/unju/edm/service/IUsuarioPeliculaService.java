package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.UsuarioPelicula;
@Service
public interface IUsuarioPeliculaService {
	public UsuarioPelicula nuevoUsuarioPelicula();
	public void guardarUsuarioPelicula(UsuarioPelicula usuariocine);
	public void eliminarUsuarioCine(Integer id) throws Exception;
	public void modificarUsuarioCine(UsuarioPelicula usuariocine);
	public List<UsuarioPelicula> listadoComentario(); 
	public UsuarioPelicula buscarUsuarioCine(Integer id) throws Exception; 

}
