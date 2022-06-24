package ar.edu.unju.edm;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;

@SpringBootApplication
public class TpFinalGrupo01_2022 {
	
	public static void main(String[] args) {
		SpringApplication.run(TpFinalGrupo01_2022.class, args);
	}
	/*@Autowired
	Usuario usuario;
	@Autowired
	IUsuarioService usuarioService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		usuario.setDni((long) 44949820);
		usuario.setNombre("agustina");
		usuario.setApellido("maraz");
		usuario.setContrasena("hola123");
		usuario.setFechaNacimiento(LocalDate.now());
		usuario.setEmail("agustinamaraz5@gmail.com");
		
		usuarioService.guardarUsuario(usuario);
	}*/
	
}
