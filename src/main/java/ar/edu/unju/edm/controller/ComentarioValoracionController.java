package ar.edu.unju.edm.controller;

import java.time.LocalDate;
import java.util.Base64;

import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.edm.model.Info;
import ar.edu.unju.edm.service.ComentarioValoracionService;
import ar.edu.unju.edm.service.IPeliculaService;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class ComentarioValoracionController {
    private static final Log EMILIA = LogFactory.getLog(ComentarioValoracionController.class);

	@Autowired
	Info nuevaInfo;
	
	@Autowired
	ComentarioValoracionService comentarioValoracionService;
	
	@Autowired
	IUsuarioService usuarioservice;
	
	@Autowired
	IPeliculaService peliculaservice;

	@GetMapping("/cargarInfo")
		public ModelAndView addInfo() throws NumberFormatException, Exception {
		
		ModelAndView view = new ModelAndView("cargarInfo");
		view.addObject("unaInfo", comentarioValoracionService.nuevaInfo());
	//	view.addObject("usuarios", usuarioservice.mostrarUsuarios());
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
	
	@PostMapping("/guardarInfo")
	public ModelAndView saveResenia(@Valid @ModelAttribute("unaInfo") Info infoNueva, BindingResult resultado) {
		ModelAndView view = new ModelAndView();
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
		EMILIA.info("Entrandooo");
		if(resultado.hasErrors()) {
			EMILIA.info("Antes de entrar al error");
			view.setViewName("cargarInfo");
			view.addObject("unainfo", infoNueva);
			return view;
		}
		try {
			EMILIA.info("entro al try");
			infoNueva.setUsuario(usuarioservice.buscarUsuario(Long.parseLong(userDetail.getUsername())));
			comentarioValoracionService.guardarInfo(infoNueva);
			infoNueva.setFechaComen(LocalDate.now());
			
		}catch(Exception e) {
			EMILIA.info("catch");
			view.addObject("formReseniaErrorMessage", e.getMessage());
			view.addObject("unaInfo", comentarioValoracionService.nuevaInfo());
			EMILIA.error("Saliendo");
			view.setViewName("cargarInfo");
			return view;
		}
			view.addObject("formReseniaErrorMessage", "Comentario guardado correctamente");
			view.addObject("unaInfo", comentarioValoracionService.nuevaInfo());
			view.setViewName("cargarInfo");
			return view;
	}
	
	
	//modificar comentario
		@RequestMapping("/editComentario/{idComentario}")
		public ModelAndView editComentario(Model model,@PathVariable (name="idComentario") Integer idComentario)throws Exception {	
			Info comentarioEncontrado = new Info();
			comentarioEncontrado = comentarioValoracionService.buscarInfo(idComentario);		
			ModelAndView modelView = new ModelAndView("cargarInfo");
			modelView.addObject("comentario", comentarioEncontrado);
			 EMILIA.info("saliendo del metodo: editComentario "+ comentarioEncontrado.getIdComentario());
			modelView.addObject("editMode", true);
			return modelView;
		}
		
		//actualizar comentario
		@PostMapping("/editComentario")
		public ModelAndView saveEditComentario(@Valid @ModelAttribute ("unaInfo") Info comentarioparamodificar, BindingResult result) {  
			if(result.hasErrors()) {
				EMILIA.fatal("Error de validacion");
				ModelAndView vista = new ModelAndView("cargarInfo");
				vista.addObject("unaInfo", comentarioparamodificar);
				vista.addObject("editMode",true);
				return vista;
			}
			try {
				comentarioValoracionService.modificarComentario(comentarioparamodificar);
			}catch(Exception error){
				ModelAndView vista = new ModelAndView("cargarInfo");
				vista.addObject("formInfoErrorMessage", error.getMessage());
				vista.addObject("unaInfo", comentarioparamodificar);
				vista.addObject("editMode",true);
				EMILIA.error("saliendo del metodo: editarComentario");
				return vista;
			}
				ModelAndView vista = new ModelAndView("listadoComentario");
				vista.addObject("listaPelicula", comentarioValoracionService.mostrarInfo());	
				vista.addObject("formInfoErrorMessage","Comentario modificado Correctamente");
			return vista;
		}
	
	@GetMapping("/listadoComentario")	
	public ModelAndView showCourses() {
		ModelAndView vista = new ModelAndView("listadoComentario");		
		vista.addObject("listaComentarioValoracion", comentarioValoracionService.mostrarInfo());		

		return vista;
	}
	
	
}