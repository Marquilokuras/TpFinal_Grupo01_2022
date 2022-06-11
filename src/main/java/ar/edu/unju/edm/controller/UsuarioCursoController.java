package ar.edu.unju.edm.controller;

import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.edm.model.UsuarioCurso;
import ar.edu.unju.edm.service.ICursoService;
import ar.edu.unju.edm.service.IUsuarioCursoService;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class UsuarioCursoController {

	private static final Log EMILIO=LogFactory.getLog(UsuarioCursoController.class);

	@Autowired
	UsuarioCurso nuevoUsuarioCurso;
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	ICursoService cursosService;
	
	@Autowired
	IUsuarioCursoService usuarioCursoService;
	
	@GetMapping("/inscripcion")
	public ModelAndView addInscripcion() {
		ModelAndView vista = new ModelAndView("cargarInscripcion");
		vista.addObject("usuarioCurso", usuarioCursoService.nuevoUsuarioCurso());
		vista.addObject("usuarios", usuarioService.mostrarUsuarios());
		vista.addObject("cursos", cursosService.mostrarCursos());
		vista.addObject("editMode", false);
		return vista;
	}
	
	@PostMapping("/guardarInscripcion")
	public ModelAndView saveInscripcion(@Valid @ModelAttribute("usuarioCurso") UsuarioCurso inscripcionparaguardar, BindingResult resultado) {  
		ModelAndView vista = new ModelAndView();
		if(resultado.hasErrors()) {
			EMILIO.fatal("Error de Validacion");
			vista.addObject("usuarioCurso",inscripcionparaguardar);
			vista.addObject("editMode",false);
			vista.setViewName("cargarInscripcion");
			return vista;
		}try { 
			usuarioCursoService.guardarUsuarioCurso(inscripcionparaguardar);
		}catch(Exception error){ //si no sale por aqui
			vista.addObject("formUsuarioErrorMessage", error.getMessage());
			vista.addObject("usuarioCurso",inscripcionparaguardar);
			vista.addObject("editMode",false);
			vista.setViewName("cargarInscripcion");
			return vista;
		}
		vista.addObject("formUsuarioErrorMessage", "Usuario Guardado Correctamente");
		vista.addObject("usuarioCurso", usuarioCursoService.nuevoUsuarioCurso());
		vista.addObject("editMode",false);
		vista.setViewName("cargarInscripcion");
		return vista;
	}
	
	
	
}
