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
	
	@GetMapping({"/compra"})	
	public ModelAndView addCompra() {
		EMILIA.info("ingresando al metodo NUEVA COMPRAAAA");
		ModelAndView vista = new ModelAndView("cargarCompra");
		vista.addObject("usuariopelicula", usuariopeliculaservice.nuevoUsuarioCine() );
		vista.addObject("usuarios", usuarioservice.mostrarUsuarios() );
		vista.addObject("peliculas", peliculaservice.listadoPelicula() );
		vista.addObject("editMode",false);
		EMILIA.info("SALIENDO DEL METODO NUEVA COMPRAAA");
		return vista;
	}
	
	
	@PostMapping("/guardarCompra")
	public ModelAndView saveCompra(@Valid @ModelAttribute ("usuariopelicula") UsuarioPelicula compraparaguardar, BindingResult result) {
		EMILIA.fatal("INGRESANDO AL METODO GUARDAR COMPRAAAAAAAAA");
		ModelAndView vista=new ModelAndView ();
		if(result.hasErrors()) {
			EMILIA.fatal("Error EN METODO GUARDAR COMPRAAAAAAAAA");
			vista.addObject("usuariopelicula", compraparaguardar);
			vista.addObject("editMode", false);
			vista.setViewName("cargarCompra");
			return vista;
		}
			try {
				usuariopeliculaservice.guardarUsuarioCine(compraparaguardar);
			} catch(Exception e) {
				vista.addObject("formCompraErrorMessage", e.getMessage());
				vista.addObject("usuariopelicula", compraparaguardar);
				EMILIA.error("saliendo del metodo: GUARDAR COMPRAAAAAAAAAAAAAAAA");
				vista.addObject("editMode", false);
				vista.setViewName("cargarCompra");
				return vista;
			}
		
			vista.addObject("formCompraErrorMessage", "COMPRAA guardado correctamente");
			vista.addObject("usuariopelicula", usuariopeliculaservice.nuevoUsuarioCine());
			vista.addObject("editMode", false);
			vista.setViewName("cargarCompra");
			return vista;

	}
	
	@GetMapping({"/comentario"})	
	public ModelAndView addComentario() {
		EMILIA.info("ingresando al metodo: Nuevo comentario");
		ModelAndView vista1 = new ModelAndView("cargarComentario");
		vista1.addObject("usuariopelicula", usuariopeliculaservice.nuevoUsuarioCine() );
		vista1.addObject("usuarios", usuarioservice.mostrarUsuarios() );
		vista1.addObject("peliculas", peliculaservice.listadoPelicula() );
		vista1.addObject("editMode",false);
		return vista1;
	}
	
	@PostMapping("/guardarComentario")
	public ModelAndView saveComentario(@Valid @ModelAttribute ("usuariopelicula") UsuarioPelicula comentarioparaguardar, BindingResult result) {
		ModelAndView vista1=new ModelAndView ();
		if(result.hasErrors()) {
			EMILIA.fatal("Error de validacion");
			vista1.addObject("usuariopelicula", comentarioparaguardar);
			vista1.addObject("editMode", false);
			vista1.setViewName("cargarComentario");
			return vista1;
		}
			try {
				usuariopeliculaservice.guardarUsuarioCine(comentarioparaguardar);
			} catch(Exception e) {
				vista1.addObject("formUsuarioErrorMessage", e.getMessage());
				vista1.addObject("usuariopelicula", comentarioparaguardar);
				EMILIA.error("saliendo del metodo: eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				vista1.addObject("editMode", false);
				vista1.setViewName("cargarComentario");
				return vista1;
			}
	}
	
	
	@GetMapping({"/valoracion"})	
	public ModelAndView addValoracion() {
		EMILIA.info("ingresando al metodo: Nueva valoracion");
		ModelAndView vista = new ModelAndView("cargarValoracion");
		vista.addObject("usuariopelicula", usuariopeliculaservice.nuevoUsuarioCine() );
		vista.addObject("usuarios", usuarioservice.mostrarUsuarios() );
		vista.addObject("peliculas", peliculaservice.listadoPelicula() );
		vista.addObject("editMode",false);
		return vista;
	}
	
	@PostMapping("/guardarValoracion")
	public ModelAndView saveValoracion(@Valid @ModelAttribute ("usuariopelicula") UsuarioPelicula compraparaguardar, BindingResult result) {
		ModelAndView vista=new ModelAndView ();
		if(result.hasErrors()) {
			EMILIA.fatal("Error de validacion");
			vista.addObject("usuariopelicula", compraparaguardar);
			vista.addObject("editMode", false);
			vista.setViewName("cargarValoracion");
			return vista;
		}
			try {
				usuariopeliculaservice.guardarUsuarioCine(compraparaguardar);
			} catch(Exception e) {
				vista.addObject("formUsuarioErrorMessage", e.getMessage());
				vista.addObject("usuariopelicula", compraparaguardar);
				EMILIA.error("saliendo del metodo: eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				vista.addObject("editMode", false);
				vista.setViewName("cargarValoracion");
				return vista;
			}
		
			vista.addObject("formUsuarioErrorMessage", "Valoracion guardado correctamente");
			vista.addObject("unUsuario", usuariopeliculaservice.nuevoUsuarioCine());
			vista.addObject("editMode", false);
			vista.setViewName("cargarValoracion");
			return vista;
	}
	
}
