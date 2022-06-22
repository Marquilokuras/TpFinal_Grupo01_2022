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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Pelicula;
import ar.edu.unju.edm.service.IPeliculaService;

@Controller
public class PeliculaController {
	private static final Log AGUSTINA=LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	Pelicula nuevaPelicula;
	
	
	@Autowired
	IPeliculaService peliculaService;
	
	//cargar pelicula
	@GetMapping("/otraPelicula")
	public ModelAndView addMovie() {
		AGUSTINA.info("ingresando al metodo: nuevapelicula");
		ModelAndView vista = new ModelAndView("cargarPelicula");
		vista.addObject("pelicula", nuevaPelicula);
		vista.addObject("editMode", false);
		return vista;
	}
	
	//guardar pelicula
	@PostMapping("/guardarPelicula")
	public String saveMovie(@Valid @ModelAttribute("pelicula")Pelicula peliculaparaguardar, BindingResult resultado, Model model) {
		AGUSTINA.info("Ingresando al metodo GUARDAR PELICULA");
		
		if(resultado.hasErrors()) {
			AGUSTINA.fatal("Error en el meotodo GUARDAR PELICULA");
			
			model.addAttribute("pelicula", peliculaparaguardar);
			model.addAttribute("editMode", false);
			return "cargarPelicula";
		}
		
		try {
			peliculaService.guardarPelicula(peliculaparaguardar);
		}catch(Exception error) {
			model.addAttribute("formPeliculaErrorMessage", error.getMessage());
			model.addAttribute("pelicula", nuevaPelicula);
			model.addAttribute("editMode", false);
			AGUSTINA.error("saliendo del metodo: GUARDAR PELICULA");
			return "cargarPelicula";
		}
		
		model.addAttribute("formPeliculaErrorMessage", "Pelicula Guardada Correctamente");
		model.addAttribute("pelicula", nuevaPelicula);
		model.addAttribute("editMode", false);
		AGUSTINA.error("saliendo del metodo: GUARDAR PELICULA");
		return "cargarPelicula";
	}
	
	// listar pelicula
		@GetMapping({"/listarPelicula"})	
		public ModelAndView listMovie() {
			ModelAndView vista = new ModelAndView("ListaPelicula");
			if(peliculaService.listarPelicula().size()!=0) {
				vista.addObject("listapelicula", peliculaService.listarPelicula());
				AGUSTINA.info("ingresando al metodo: listapeliculas "+peliculaService.listarPelicula().size());
			}
			return vista;
			}
	
		
		//modificar  ppelicula
	@RequestMapping("/editPelicula/{idPelicula}")
	public ModelAndView editMovie(Model model,@PathVariable (name="idPelicula") Long idPelicula)throws Exception {	
		Pelicula peliculaEncontrada = new Pelicula();
		peliculaEncontrada = peliculaService.buscarPelicula(idPelicula);		
		ModelAndView modelView = new ModelAndView("cargarPelicula");
		modelView.addObject("pelicula", peliculaEncontrada);
		 AGUSTINA.error("saliendo del metodo: editMovie "+ peliculaEncontrada.getNombrePelicula());
		modelView.addObject("editMode", true);
		return modelView;
	}
	
	
	//actualizar pelicula
	@PostMapping("/editarPelicula")
	public ModelAndView saveEditMovie(@Valid @ModelAttribute ("pelicula") Pelicula peliculaparamodificar, BindingResult result) {  
		if(result.hasErrors()) {
			AGUSTINA.fatal("Error de validacion");
			ModelAndView vista = new ModelAndView("cargarPelicula");
			vista.addObject("pelicula", peliculaparamodificar);
			vista.addObject("editMode",true);
			return vista;
		}
		try {
			peliculaService.modificarPelicula(peliculaparamodificar);
		}catch(Exception error){
			ModelAndView vista = new ModelAndView("cargarPelicula");
			vista.addObject("formPeliculaErrorMessage", error.getMessage());
			vista.addObject("pelicula", peliculaparamodificar);
			vista.addObject("editMode",true);
			AGUSTINA.error("saliendo del metodo: editarPelicula");
			return vista;
		}
			ModelAndView vista = new ModelAndView("listadoPelicula");
			vista.addObject("listaPelicula", peliculaService.listarPelicula());	
			vista.addObject("formPeliculaErrorMessage","Pelicula modificada Correctamente");
		return vista;
	}
		
		/*ModelAndView vista = new ModelAndView("listadoPelicula");
		vista.addObject("listaPelicula", peliculaService.mostrarPeliculas());
		vista.addObject("formPeliculaErrorMessage", "Pelicula Guardado Correctamente");
		return vista;*/
	
	// eliminar pelicula
			@RequestMapping("/deleteMovie/{idPelicula}")
			public String deleteMovie(@PathVariable(name="idPelicula") Long idPelicula, Model model) {
				try {
					peliculaService.eliminarPelicula(idPelicula);
				}catch(Exception error){
					AGUSTINA.error("encontrando: eliminarpelicula");
					model.addAttribute("formPeliculaErrorMessage", error.getMessage());
					return "redirect:/otraPelicula";
				}
			
			    return "redirect:/listarPelicula";
			}
	}
	
	
	
	

