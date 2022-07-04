package ar.edu.unju.edm;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;



@SpringBootApplication

public class TpFinalGrupo01_2022 implements CommandLineRunner {



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
	usuario.setDni((long)45109291);
	usuario.setNombre("Emilia");
	usuario.setApellido("Valeriano");
	usuario.setContrasena("hola123");
	usuario.setFechaNacimiento(LocalDate.now());
	usuario.setEmail("emivaleriano03@gmail.com");
	usuario.setTelefono((int)388501425);
	usuario.setGenero("Fememnino");
	usuarioService.guardarUsuario(usuario);
	
}

}
