package ar.edu.unju.edm.controller;

import java.security.Principal;
import java.util.List;

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

import ar.edu.unju.edm.model.Usuario;
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
	
	public ModelAndView addVenta(Principal principal) throws Exception {
		Usuario existente = usuarioservice.buscarUsuario(principal.con);
		
	EMILIA.info("ingresando al metodo: venta");
		ModelAndView modelView = new ModelAndView("ticket");
		modelView.addObject("unTicket", usuariopeliculaservice.nuevoUsuarioPelicula());
		//modelView.addObject("usuarios", usuarioService.mostrarUsuario());
		modelView.addObject("usuarios", existente);
		modelView.addObject("pelicula", peliculaservice.listadoPelicula());
		return modelView;
	}
	
	@PostMapping("/guardarTicket")
	public ModelAndView saveInscripcion(@Valid @ModelAttribute("unTicket") UsuarioPelicula usuarioPeliculaNuevo, BindingResult resultado) {			
			// VERIFICACION DEL NOMBRE Y DNI	
		ModelAndView modelView = new ModelAndView();
		if (resultado.hasErrors()) {
			EMILIA.fatal("Error de validacion");			
			modelView.setViewName("ticket");
			modelView.addObject("unTicket", usuarioPeliculaNuevo);			
			return modelView;
		}		
		try {
			usuariopeliculaservice.guardarUsuarioPelicula(usuarioPeliculaNuevo);
		} catch (Exception e) {			
			modelView.addObject("formUsuarioErrorMessage", e.getMessage());
			modelView.addObject("unTicket", usuariopeliculaservice.nuevoUsuarioPelicula());
			EMILIA.error("saliendo del metodo: eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			modelView.setViewName("ticket");
			return modelView;		
		}		
		
		modelView.addObject("formUsuarioErrorMessage", "Usuario guardado correctamente");
		modelView.addObject("unTicket", usuariopeliculaservice.nuevoUsuarioPelicula());
		//modelView.setViewName("ticket");
		modelView.addObject("listaTickets", usuariopeliculaservice.listadoUsuariosPelicula());
		modelView.setViewName("listadoTickets");
		return modelView;
		}
	
	@GetMapping("/listadoTickets")	
	public ModelAndView showCourses() {
		ModelAndView vista = new ModelAndView("listadoTickets");		
		vista.addObject("listaTickets", usuariopeliculaservice.listadoUsuariosPelicula());		
		return vista;
	}
	
	/*@GetMapping({"/compra"})	
	public ModelAndView addCompra() {
		EMILIA.info("ingresando al metodo NUEVA COMPRAAAA");
		ModelAndView vista = new ModelAndView("cargarCompra");
		vista.addObject("usuariopelicula", usuariopeliculaservice.nuevoUsuarioCine() );
		vista.addObject("usuarios", usuarioservice.mostrarUsuarios() );
		vista.addObject("peliculas", peliculaservice.listadoPelicula() );
		vista.addObject("editMode",false);
		EMILIA.info("SALIENDO DEL METODO NUEVA COMPRAAA");
		return vista;
	}*/
	

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
				usuariopeliculaservice.guardarUsuarioPelicula(compraparaguardar);
			} catch(Exception e) {
				vista.addObject("formCompraErrorMessage", e.getMessage());
				vista.addObject("usuariopelicula", compraparaguardar);
				EMILIA.error("saliendo del metodo: GUARDAR COMPRAAAAAAAAAAAAAAAA");
				vista.addObject("editMode", false);
				vista.setViewName("cargarCompra");
				return vista;
			}
		
			vista.addObject("formCompraErrorMessage", "COMPRAA guardado correctamente");
			vista.addObject("usuariopelicula", usuariopeliculaservice.nuevoUsuarioPelicula());
			vista.addObject("editMode", false);
			vista.setViewName("cargarCompra");
			return vista;

	}
	
	@PostMapping("/guardarComentario")
	public ModelAndView saveComentario(@Valid @ModelAttribute ("usuariopelicula") UsuarioPelicula comentarioparaguardar, BindingResult result) {
		ModelAndView vista=new ModelAndView ();
		if(result.hasErrors()) {
			EMILIA.fatal("Error de validacion");
			vista.addObject("usuariopelicula", comentarioparaguardar);
			vista.addObject("editMode", false);
			vista.setViewName("cargarComentario");
			return vista;
		}
			try {
				usuariopeliculaservice.guardarUsuarioPelicula(compraparaguardar);
			} catch(Exception e) {
				vista.addObject("formUsuarioErrorMessage", e.getMessage());
				vista.addObject("usuariopelicula", compraparaguardar);
				EMILIA.error("saliendo del metodo: eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				vista.addObject("editMode", false);
				vista.setViewName("cargarComentario");
				return vista;
			}
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
				usuariopeliculaservice.guardarUsuarioPelicula(compraparaguardar);
			} catch(Exception e) {
				vista.addObject("formUsuarioErrorMessage", e.getMessage());
				vista.addObject("usuariopelicula", compraparaguardar);
				EMILIA.error("saliendo del metodo: eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				vista.addObject("editMode", false);
				vista.setViewName("cargarValoracion");
				return vista;
			}
		
			vista.addObject("formUsuarioErrorMessage", "Valoracion guardado correctamente");
			vista.addObject("unUsuario", usuariopeliculaservice.nuevoUsuarioPelicula());
			vista.addObject("editMode", false);
			vista.setViewName("cargarValoracion");
			return vista;
	}
	
}
