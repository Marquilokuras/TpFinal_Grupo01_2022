package ar.edu.unju.edm.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.UsuarioCurso;

@Service
public interface IUsuarioCursoService {
	public List<UsuarioCurso>mostrarUsuarioCurso();
	public void eliminarUsuarioCurso(Integer idUsuarioCurso) throws Exception;
	public void modificarUsuarioCurso(UsuarioCurso usuarioCurso);
	public UsuarioCurso buscarUsuarioCurso(Integer idUsuarioCurso) throws Exception;
	public void guardarUsuarioCurso(@Valid UsuarioCurso usuarioCursoparaguardar);
	public UsuarioCurso nuevoUsuarioCurso();
}


