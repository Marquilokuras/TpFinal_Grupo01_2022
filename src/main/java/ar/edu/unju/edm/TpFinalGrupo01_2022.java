package ar.edu.unju.edm;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;

@SpringBootApplication
public class TpFinalGrupo01_2022 implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TpFinalGrupo01_2022.class, args);
	}	
	@Autowired
	Usuario usuario;
	@Autowired
	IUsuarioService usuarioService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		usuario.setDni((long)45109295);
		usuario.setApellido("Valeriano");
		usuario.setContrasena("hola123");
		usuario.setEmail("emival03@gmail.com");
		usuario.setFechaNacimiento(LocalDate.now());
		usuario.setGenero("femenino");
		usuario.setNombre("Agus");
		usuario.setTelefono(388405091);
		usuario.setTipo("ADMIN");
		
		usuarioService.guardarUsuario(usuario);
	}

}

