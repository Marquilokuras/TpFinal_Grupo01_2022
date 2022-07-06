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

//spublic class TpFinalGrupo01_2022 {


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
	/*
	
=======
	usuario.setDni((long)44949820);
	usuario.setNombre("Agustina");
	usuario.setApellido("Maraz");
	usuario.setContrasena("hola123");
	usuario.setFechaNacimiento(LocalDate.now());
	usuario.setEmail("agustinamaraz5@gmail.com");
	usuario.setTelefono((int)388505659);
	usuario.setGenero("Femenino");
	usuarioService.guardarUsuario(usuario);
>>>>>>> branch 'master' of https://github.com/Marquilokuras/TpFinal_Grupo01_2022.git
}
*/
	
}
}
