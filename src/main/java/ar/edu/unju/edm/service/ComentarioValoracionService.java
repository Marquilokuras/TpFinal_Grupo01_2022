package ar.edu.unju.edm.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Info;
import ar.edu.unju.edm.model.Pelicula;

@Service
public interface ComentarioValoracionService {
	public Info nuevaInfo();
	
	public void guardarInfo(Info info);
	
	public List<Info> mostrarInfo();
	public void modificarComentario(Info comentario);
	public Info buscarInfo(Integer idComentario) throws Exception;
}