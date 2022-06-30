package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.repository.UsuarioRepository;

@Service
public class LoginService implements UserDetailsService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//busqueda del usuario
		Usuario usuarioEncontrado = usuarioRepository.findById(Long.parseLong(dni)).orElseThrow(()->new UsernameNotFoundException("Usuario Invalido"));
		
		//definir autorizaciones
		List <GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipo());
		tipos.add(grantedAuthority);
		
		//definir el usuario en sesion

		UserDetails usuarioEnSesion = new User(dni,usuarioEncontrado.getContrasena(),tipos);
		
		return usuarioEnSesion;
	}
	
}
