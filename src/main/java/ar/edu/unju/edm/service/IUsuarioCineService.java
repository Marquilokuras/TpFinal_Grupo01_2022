package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.UsuarioCine;
@Service
public interface IUsuarioCineService {
	public UsuarioCine nuevoUsuarioCine();
	public void guardarUsuarioCine(UsuarioCine usuariocine);
	public void eliminarUsuarioCine(Integer id) throws Exception;
	public void modificarUsuarioCine(UsuarioCine usuariocine);
	public List<UsuarioCine> listadoUsuariosCine(); 
	public UsuarioCine buscarUsuarioCine(Integer id) throws Exception; 

}
