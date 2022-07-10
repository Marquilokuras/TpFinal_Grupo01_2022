package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import ar.edu.unju.edm.controller.UsuarioController;
import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.repository.UsuarioRepository;
import ar.edu.unju.edm.service.IUsuarioService;
import ar.edu.unju.edm.until.ListaUsuario;

@Service
public class IUsuarioServiceImp implements IUsuarioService {

	//private static final Log MARCOS = LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	ListaUsuario lista;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public void guardarUsuario(Usuario usuarioparaguardar) {
		// TODO Auto-generated method stub
		usuarioparaguardar.setEstado(true);
<<<<<<< HEAD

=======
		//usuarioparaguardar.setTipo("CLIENTE");

	//	lista.getListado().add(usuarioparaguardar); 
>>>>>>> branch 'Emilia__Valeriano' of https://github.com/Marquilokuras/TpFinal_Grupo01_2022.git
		String pw=usuarioparaguardar.getContrasena();
		BCryptPasswordEncoder coder = new BCryptPasswordEncoder(4); //clase de codificadores para incriptar datos
		usuarioparaguardar.setContrasena(coder.encode(pw));

		usuarioRepository.save(usuarioparaguardar);
	}

	@Override
	public List<Usuario> mostrarUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> auxiliar = new ArrayList<>();
		List<Usuario> auxiliar2 = new ArrayList<>();

		auxiliar=(List<Usuario>) usuarioRepository.findAll();
		for(int i=0;i<auxiliar.size();i++) {
			if(auxiliar.get(i).getEstado()==true) {
				auxiliar2.add(auxiliar.get(i));
			}
		}
		
		System.out.println("CANTIDAD DE USUARIOS ACTIVOS: "+auxiliar2.size());
		
		return auxiliar2;
	}
	
	@Override
	public List<Usuario> mostrarUsuariosInactivos() {
		// TODO Auto-generated method stub
		List<Usuario> auxiliar = new ArrayList<>();
		List<Usuario> auxiliar2 = new ArrayList<>();

		auxiliar=(List<Usuario>) usuarioRepository.findAll();
		for(int i=0;i<auxiliar.size();i++) {
			if(auxiliar.get(i).getEstado()==false) {
				auxiliar2.add(auxiliar.get(i));
			}
		}
		
		System.out.println("CANTIDAD DE USUARIOS INACTIVOS: "+auxiliar2.size());
		
		return auxiliar2;
	}
	
	@Override
	public void eliminarUsuario(Long dni) throws Exception {
		// TODO Auto-generated method stub
		Usuario auxiliar = new Usuario();
		auxiliar = buscarUsuario(dni) ;
		auxiliar.setEstado(false);
		usuarioRepository.save(auxiliar);
	}
	
	@Override
	public void modificarUsuario(Usuario usuario) {
		System.out.println("ingresando al metodo modificar usuario"+usuario.getEmail());
		
		// TODO Auto-generated method stub
		//usuario.setEstado(true);
	
		usuarioRepository.save(usuario);
		
		System.out.println("saliendo del metodo modificar usuario");
	}

	@Override
	public Usuario buscarUsuario(Long dni) throws Exception {
		// TODO Auto-generated method stub´
		Usuario usuarioEncontrado = new Usuario();
		
		/*for(int i=0;i<lista.getListado().size();i++) {
			if(lista.getListado().get(i).getDni().equals(id)) {
				auxiliar = lista.getListado().get(i);
			}
		}*/
		usuarioEncontrado=usuarioRepository.findById(dni).orElseThrow(()->new Exception("Usuario No Encontrado"));
		return usuarioEncontrado;
	}

	
}