package ar.edu.unju.edm.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.UsuarioCine;

@Service
public interface IUsuarioCineService {
	public List<UsuarioCine>mostrarUsuarioCine();
	public void eliminarUsuarioCine(Integer idUsuarioCine) throws Exception;
	public void modificarUsuarioCine(UsuarioCine usuarioCine);
	public UsuarioCine buscarUsuarioCine(Integer idUsuarioCine) throws Exception;
	public void guardarUsuarioCine(@Valid UsuarioCine usuarioCineparaguardar);
	public UsuarioCine nuevoUsuarioCine();
}


