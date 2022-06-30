package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.UsuarioCine;
import ar.edu.unju.edm.repository.UsuarioCineRepository;
import ar.edu.unju.edm.service.IUsuarioCineService;

@Service
public class IUsuarioCineImp implements IUsuarioCineService{
	@Autowired
	UsuarioCine usuariocine;
	@Autowired 
	UsuarioCineRepository usuariocinerepository;

		@Override
		public UsuarioCine nuevoUsuarioCine() {
			// TODO Auto-generated method stub
			return usuariocine;
		}

		@Override
		public void guardarUsuarioCine(UsuarioCine usuariocine) {
			// TODO Auto-generated method stub
			usuariocinerepository.save (usuariocine);
		}

		@Override
		public void eliminarUsuarioCine(Integer id) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void modificarUsuarioCine(UsuarioCine usuariocine) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<UsuarioCine> listadoUsuariosCine() {
			// TODO Auto-generated method stub
			return (List<UsuarioCine>) usuariocinerepository.findAll();
		}

		@Override
		public UsuarioCine buscarUsuarioCine(Integer id) throws Exception {
			// TODO Auto-generated method stub
			return usuariocinerepository.findById(id).orElseThrow(()-> new Exception("UsuarioCine no encontrado"));
		}

}
