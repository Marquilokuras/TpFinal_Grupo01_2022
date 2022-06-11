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
import ar.edu.unju.edm.model.UsuarioCine;
import ar.edu.unju.edm.service.ICineService;
import ar.edu.unju.edm.service.IUsuarioCineService;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class UsuarioCineController {

	private static final Log EMILIO=LogFactory.getLog(UsuarioCineController.class);

	@Autowired
	UsuarioCine nuevoUsuarioCine;
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	ICineService cineService;
	
	@Autowired
	IUsuarioCineService usuarioCineService;
	
	@GetMapping("/inscripcion")
	public ModelAndView addInscripcion() {
		ModelAndView vista = new ModelAndView("cargarInscripcion");
		vista.addObject("usuarioCine", usuarioCineService.nuevoUsuarioCine());
		vista.addObject("usuarios", usuarioService.mostrarUsuarios());
		//vista.addObject("cines", cineService.mostrarCine());
		vista.addObject("editMode", false);
		return vista;
	}
	
	@PostMapping("/guardarInscripcion")
	public ModelAndView saveInscripcion(@Valid @ModelAttribute("usuarioCine") UsuarioCine inscripcionparaguardar, BindingResult resultado) {  
		ModelAndView vista = new ModelAndView();
		if(resultado.hasErrors()) {
			EMILIO.fatal("Error de Validacion");
			vista.addObject("usuarioCine",inscripcionparaguardar);
			vista.addObject("editMode",false);
			vista.setViewName("cargarInscripcion");
			return vista;
		}try { 
			usuarioCineService.guardarUsuarioCine(inscripcionparaguardar);
		}catch(Exception error){ //si no sale por aqui
			vista.addObject("formUsuarioErrorMessage", error.getMessage());
			vista.addObject("usuarioCine",inscripcionparaguardar);
			vista.addObject("editMode",false);
			vista.setViewName("cargarInscripcion");
			return vista;
		}
		vista.addObject("formUsuarioErrorMessage", "Usuario Guardado Correctamente");
		vista.addObject("usuarioCine", usuarioCineService.nuevoUsuarioCine());
		vista.addObject("editMode",false);
		vista.setViewName("cargarInscripcion");
		return vista;
	}
	
}
