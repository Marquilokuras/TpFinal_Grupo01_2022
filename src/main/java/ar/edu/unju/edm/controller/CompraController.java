package ar.edu.unju.edm.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Compra;
import ar.edu.unju.edm.service.ICompraService;
import ar.edu.unju.edm.service.IPeliculaService;
import ar.edu.unju.edm.service.IUsuarioService;
@Controller
public class CompraController {
	private static final Log EMILIA = LogFactory.getLog(CompraController.class);

	@Autowired
	Compra nuevaCompra;

	@Autowired
	ICompraService compraService;

	@Autowired
	IUsuarioService usuarioservice;

	@Autowired
	IPeliculaService peliculaservice;

	@GetMapping("/cargarCompra")
		public ModelAndView addCompra() throws NumberFormatException, Exception {
		
		ModelAndView view = new ModelAndView("cargarCompra");
		view.addObject("unaCompra", compraService.nuevaCompra());
//		view.addObject("usuarios", usuarioservice.mostrarUsuarios());
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
		System.out.println(userDetail.getUsername());
		view.addObject("usuarioEnSesion",usuarioservice.buscarUsuario(Long.parseLong(userDetail.getUsername())));
		System.out.println(usuarioservice.buscarUsuario(Long.parseLong(userDetail.getUsername())).getApellido());
		view.addObject("peliculas", peliculaservice.listadoPelicula());
		return view;
		}

	@PostMapping("/guardarCompra")
	public ModelAndView saveCompra(@Valid @ModelAttribute("unaCompra") Compra compraNueva, BindingResult resultado) {
		ModelAndView view = new ModelAndView();
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
		EMILIA.info("ENTRANDO AL METODO GUARDAR COMPRAAAAA");
		if(resultado.hasErrors()) {
			EMILIA.info("EEEEEEEEEEEEEEEEEEEEEEEEEE");
			view.setViewName("cargarCompra");
			view.addObject("unacompra", compraNueva);
			return view;
		}
		try {
			EMILIA.info("ENTRANDO AL TRYYYYYYYYYYYY");
			compraNueva.setUsuario(usuarioservice.buscarUsuario(Long.parseLong(userDetail.getUsername())));
			compraService.guardarCompra(compraNueva);
			
		}catch(Exception e) {
			EMILIA.info("AAAAAAAAAAAAAAAAAAAA");
			view.addObject("formCompraErrorMessage", e.getMessage());
			view.addObject("unaCompra", compraService.nuevaCompra());
			EMILIA.error("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
			view.setViewName("cargarCompra");
			return view;
		}
			view.addObject("formCompraErrorMessage", "COMPRA REALIZADA CON EXITO!");
			view.addObject("unaCompra", compraService.nuevaCompra());
			view.setViewName("cargarCompra");
			return view;
	}

	@GetMapping("/listadoCompra")	
	public ModelAndView showCompra() {
		ModelAndView vista = new ModelAndView("listadoCompra");		
		vista.addObject("listaCompra", compraService.mostrarCompra());		
		return vista;
	}


}
