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
import ar.edu.unju.edm.service.IPeliculaService;
import ar.edu.unju.edm.service.IUsuarioCineService;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class UsuarioCineController {
private static final Log EMILIA = LogFactory.getLog(UsuarioController.class);

	@Autowired 
	IUsuarioCineService usuariocineservice;
	
	@Autowired
	IUsuarioService usuarioservice;
	
	@Autowired
	IPeliculaService peliculaservice;
	
	@GetMapping({"/cargarCompra"})	
	public ModelAndView addCompra() {
		EMILIA.info("ingresando al metodo: Nuevo usuario");
		ModelAndView vista = new ModelAndView("cargarCompra");
		vista.addObject("usuariocine", usuariocineservice.nuevoUsuarioCine() );
		vista.addObject("usuarios", usuarioservice.mostrarUsuarios() );
		vista.addObject("pelicula", peliculaservice.listadoPelicula() );
		vista.addObject("editMode",false);
		return vista;
	}
	@PostMapping("/guardarCompra")
	public ModelAndView saveCompra(@Valid @ModelAttribute ("usuariocine") UsuarioCine compraparaguardar, BindingResult result) {
		ModelAndView vista=new ModelAndView ();
		if(result.hasErrors()) {
			EMILIA.fatal("Error de validacion");
			vista.addObject("usuariocine", compraparaguardar);
			vista.addObject("editMode", false);
			vista.setViewName("cargarCompra");
			return vista;
		}
			try {
				usuariocineservice.guardarUsuarioCine(compraparaguardar);
			} catch(Exception e) {
				vista.addObject("formUsuarioErrorMessage", e.getMessage());
				vista.addObject("usuariocine", compraparaguardar);
				vista.addObject("editMode", false);
				vista.setViewName("cargarCompra");
				return vista;
			}
		
			vista.addObject("formUsuarioErrorMessage", "Usuario guardado correctamente");
			vista.addObject("usuariocine", usuariocineservice.nuevoUsuarioCine());
			vista.addObject("editMode", false);
			vista.setViewName("cargarCompra");
			return vista;

		
	}
}
