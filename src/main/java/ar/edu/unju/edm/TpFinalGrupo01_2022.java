package ar.edu.unju.edm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import ar.edu.unju.edm.model.Usuario;
//import ar.edu.unju.edm.service.IUsuarioService;

@SpringBootApplication
public class TpFinalGrupo01_2022 implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TpFinalGrupo01_2022.class, args);
	}

	/*@Autowired
	Usuario usuario;
	@Autowired
	IUsuarioService usuarioService;*/
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*usuario.setDni(45085907);
		usuario.setNombre("Marcos");
		usuario.setApellido("Quinteros");
		usuario.setContrasena("hola123");
		usuario.setFechaNacimiento(LocalDate.now());
		usuario.setEmail("marcos.quinteros2003@gmail.com");
		usuarioService.guardarUsuario(usuario);*/
	}

}
