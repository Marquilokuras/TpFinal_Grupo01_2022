package ar.edu.unju.edm.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Usuario;

@Service
public interface IUsuarioService {
	public void guardarUsuario(@Valid Usuario usuarioparaguardar);
	public void modificarUsuario(Usuario usuario);
	public void eliminarUsuario(Long dni) throws Exception;
	public List<Usuario> mostrarUsuarios();
	public List<Usuario> mostrarUsuariosInactivos();
	public Usuario buscarUsuario(Long dni) throws Exception;
	public Usuario encontrarConDni(String usuario) throws Exception;
}