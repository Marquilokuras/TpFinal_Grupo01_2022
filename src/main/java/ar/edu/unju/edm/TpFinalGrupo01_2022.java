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
	/*
	 implements CommandLineRunner
	 @Autowired
	Usuario usuario;
	@Autowired
	IUsuarioService usuarioService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		usuario.setDni((long) 45467888);
		usuario.setNombre("leonardo");
		usuario.setApellido("soruco");
		usuario.setContrasena("leo15");
		usuario.setFechaNacimiento(LocalDate.now());
		usuario.setEmail("emi.l.m.ta@gmail.com");
		usuario.setGenero("masculino");
		usuario.setTelefono(388442832);
		usuario.setTipo("ADMIN");
		usuarioService.guardarUsuario(usuario);
	}*/
}