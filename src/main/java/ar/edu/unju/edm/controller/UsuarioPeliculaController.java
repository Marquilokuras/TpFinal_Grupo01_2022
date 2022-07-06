package ar.edu.unju.edm.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.edm.model.UsuarioPelicula;
import ar.edu.unju.edm.service.IPeliculaService;
import ar.edu.unju.edm.service.IUsuarioPeliculaService;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class UsuarioPeliculaController {
private static final Log EMILIA = LogFactory.getLog(UsuarioPeliculaController.class);

	@Autowired 
	IUsuarioPeliculaService usuariopeliculaservice;
	
	@Autowired
	IUsuarioService usuarioservice;
	
	@Autowired
	IPeliculaService peliculaservice;
	
	@Autowired
	UsuarioPelicula nuevaCompra;
	
	@GetMapping("/otraCompra")	
	public ModelAndView addCompra() {
		EMILIA.info("ingresando al metodo:AÑADIR COMPRAAAAA");
		ModelAndView vista = new ModelAndView("cargarCompra");
		vista.addObject("usuariopelicula", usuariopeliculaservice.nuevoUsuarioCine() );
		vista.addObject("usuarios", usuarioservice.mostrarUsuarios() );
		vista.addObject("peliculas", peliculaservice.listadoPelicula() );
		vista.addObject("usuariopelicula", nuevaCompra);
		//vista.addObject("editMode",false);
		EMILIA.info("saliendo al metodo: AÑADIR compraaaaaaaa");
		return vista;
	}

	
	@PostMapping("/guardarCompra")
	public String saveCompra(@Valid @ModelAttribute ("usuariopelicula") UsuarioPelicula compraparaguardar, BindingResult result,Model model) {
		EMILIA.fatal("INGRESANDO AL METOOD GUARDAR COMPRA");
		//ModelAndView vista=new ModelAndView ();
		if(result.hasErrors()) {
			EMILIA.fatal("Error EN EL METODO GUARDAR COMPRA ");
			model.addAttribute("usuariopelicula", compraparaguardar);
			//vista.addObject("editMode", false);
			//vista.setViewName("cargarCompra");
			return "cargarCompra";
		}
			try {
				usuariopeliculaservice.guardarUsuarioCine(compraparaguardar);
			} catch(Exception e) {
				model.addAttribute("formCompraErrorMessage", e.getMessage());
				model.addAttribute("usuariopelicula", compraparaguardar);
				//model.addAttribute("editMode", false);
				EMILIA.error("NO SE PUDO GUARDAR LA COMMPRA");
				return "cargarCompra";
			}
		
			model.addAttribute("formCompraErrorMessage", "Compra realizada con EXITO!");
			model.addAttribute("usuariopelicula",nuevaCompra);
			//model.addAttribute("editMode", false);
			//vista.setViewName("cargarCompra");
			EMILIA.info("saliendo del metodo: GUARDAR COMPRAAAAAAAAAAAAAAAAAAAA");
			
			return "cargarCompra";
	}
	
	// listado compra
		@GetMapping("/listadoCompra")
		public ModelAndView listCompra() {
			ModelAndView vista = new ModelAndView("listadoCompra");
			EMILIA.info("ingresando al metodo: lisCompra "+usuariopeliculaservice.listadoUsuariosCine());
			vista.addObject("listaCompra", usuariopeliculaservice.listadoUsuariosCine());
			return vista;
		}
}

