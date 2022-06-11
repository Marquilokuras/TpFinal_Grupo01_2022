package ar.edu.unju.edm.service.imp;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.UsuarioCurso;
import ar.edu.unju.edm.repository.UsuarioCursoRepository;
import ar.edu.unju.edm.service.IUsuarioCursoService;

@Service
public class IUsuarioCursoImp implements IUsuarioCursoService{

	@Autowired
	UsuarioCurso usuariocurso;
	
	@Autowired
	UsuarioCursoRepository usuarioCursoRepository;
	
	@Override
	public List<UsuarioCurso> mostrarUsuarioCurso() {
		// TODO Auto-generated method stub
		
		return (List<UsuarioCurso>) usuarioCursoRepository.findAll();
	}

	@Override
	public void eliminarUsuarioCurso(Integer idUsuarioCurso) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarUsuarioCurso(UsuarioCurso usuarioCurso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UsuarioCurso buscarUsuarioCurso(Integer idUsuarioCurso) throws Exception {
		// TODO Auto-generated method stub
		return usuarioCursoRepository.findById(idUsuarioCurso).orElseThrow(()->new Exception("UsuarioCurso No Encontrado"));
	}

	@Override
	public void guardarUsuarioCurso(@Valid UsuarioCurso usuarioCursoparaguardar) {
		// TODO Auto-generated method stub
		//usuarioCursoparaguardar.setEstado(true); 
		usuarioCursoRepository.save(usuarioCursoparaguardar);
	}

	@Override
	public UsuarioCurso nuevoUsuarioCurso() {
		// TODO Auto-generated method stub
		
		return usuariocurso;
	}

}
