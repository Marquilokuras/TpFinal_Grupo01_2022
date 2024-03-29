package ar.edu.unju.edm.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Info;
import ar.edu.unju.edm.repository.ComentarioValoracion;
import ar.edu.unju.edm.service.ComentarioValoracionService;

@Service
public class IComentarioValoracionServiceImp implements ComentarioValoracionService{
    @Autowired 
    Info info;
    @Autowired
    ComentarioValoracion comentarioValoracionRepository; 
	@Override
	public Info nuevaInfo() {
		// TODO Auto-generated method stub
		return info;
	}

	@Override
	public void guardarInfo(Info info) {
		// TODO Auto-generated method stub
		comentarioValoracionRepository.save(info);
	}


	
	@Override
	public List<Info> mostrarInfo() {
		// TODO Auto-generated method stub
		return (List<Info>) comentarioValoracionRepository.findAll();
	}
	
	@Override
	public void modificarComentario(Info comentario) {
		// TODO Auto-generated method stub
		comentario.setEstadoComentario(true);
		  
		comentarioValoracionRepository.save(comentario);
	}
	
	@Override
	public Info buscarInfo(Integer idComentario) throws Exception {
		// TODO Auto-generated method stub
		Info comentarioEncontrado = new Info();
		
		comentarioEncontrado=comentarioValoracionRepository.findById(idComentario).orElseThrow(()->new Exception("Comentario No Encontrado"));
		return comentarioEncontrado;
	}

}