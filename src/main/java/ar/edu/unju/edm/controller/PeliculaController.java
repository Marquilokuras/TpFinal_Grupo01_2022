package ar.edu.unju.edm.controller;

import java.util.Base64;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
		AGUSTINA.info("ingresando al metodo: AÑADIR PELICULA");
		ModelAndView vista = new ModelAndView("cargarPelicula");
		vista.addObject("pelicula", nuevaPelicula);
		vista.addObject("editMode", false);
		AGUSTINA.info("saliendo al metodo: AÑADIR PELICULA");
		return vista;
	}
	
	@PostMapping(value="/guardarPelicula", consumes = "multipart/form-data")
	public String saveMovie(@Valid @ModelAttribute("pelicula")Pelicula peliculaparaguardar, BindingResult resultado, @RequestParam("file") MultipartFile file, Model model) {
    
		AGUSTINA.info("Ingresando al metodo GUARDAR PELICULA");
		
		if(resultado.hasErrors()) {
			AGUSTINA.fatal("Error en el metodo GUARDAR PELICULA");
			model.addAttribute("editMode", false);
			model.addAttribute("pelicula", peliculaparaguardar);
			//model.addAttribute("editMode", false);
			return "cargarPelicula";
		}
		
		try {
			byte[] content = file.getBytes();
			String base64 = Base64.getEncoder().encodeToString(content);
			peliculaparaguardar.setImagen(base64);
			peliculaService.guardarPelicula(peliculaparaguardar);
		}catch(Exception error) {
			model.addAttribute("formPeliculaErrorMessage", error.getMessage());
			model.addAttribute("pelicula", peliculaparaguardar);
			//model.addAttribute("editMode", false);
			AGUSTINA.error("No se pudo guardar la pelicula");
			model.addAttribute("editMode", false);
			return "cargarPelicula";
		}
		
		model.addAttribute("formPeliculaErrorMessage", "Pelicula Guardada Correctamente");
		model.addAttribute("pelicula", nuevaPelicula);

		//model.addAttribute("editMode", false);
		AGUSTINA.info("saliendo del metodo: GUARDAR PELICULA");
		model.addAttribute("editMode", false);
		return "cargarPelicula";
	}
	
	// listar pelicula
	@GetMapping("/listadoPelicula")
	public ModelAndView showMovie() {
		ModelAndView vista = new ModelAndView("listadoPelicula");
		vista.addObject("listaPelicula", peliculaService.listadoPelicula());
		return vista;
	}
	
	@GetMapping("/listadoPeliculaCliente")
	public ModelAndView showMovieCliente() {
		ModelAndView vista = new ModelAndView("listadoPeliculaCliente");
		vista.addObject("listaPelicula", peliculaService.listadoPelicula());
		return vista;
	}
	
		//modificar  pelicula
	@RequestMapping("/editPelicula/{idPelicula}")
	public ModelAndView editMovie(Model model,@PathVariable (name="idPelicula") Long idPelicula)throws Exception {	
		Pelicula peliculaEncontrada = new Pelicula();
		peliculaEncontrada = peliculaService.buscarPelicula(idPelicula);		
		ModelAndView modelView = new ModelAndView("cargarPelicula");
		modelView.addObject("pelicula", peliculaEncontrada);
		 AGUSTINA.info("saliendo del metodo: editMovie "+ peliculaEncontrada.getNombrePelicula());
		modelView.addObject("editMode", true);
		return modelView;
	}
	
	
	//actualizar pelicula
	@PostMapping(value= "/editarPelicula", consumes = "multipart/form-data")
	public ModelAndView saveEditMovie(@Valid @ModelAttribute ("pelicula") Pelicula peliculaparamodificar, BindingResult result,  @RequestParam("file") MultipartFile file) {  
		if(result.hasErrors()) {
			AGUSTINA.fatal("Error de validacion");
			ModelAndView vista = new ModelAndView("cargarPelicula");
			vista.addObject("pelicula", peliculaparamodificar);
			vista.addObject("editMode",true);
			return vista;
		}
		try {
			byte[] content = file.getBytes();
			String base64 = Base64.getEncoder().encodeToString(content);
			peliculaparamodificar.setImagen(base64);
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
			vista.addObject("listaPelicula", peliculaService.listadoPelicula());	
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
				AGUSTINA.info("ingresando al metodo eliminar");
				try {
					AGUSTINA.info("ingresando al metodo eliminartryyyyyyyyyyy");
					peliculaService.eliminarPelicula(idPelicula);
				}catch(Exception error){
					AGUSTINA.error("encontrando: eliminarpelicula");
					model.addAttribute("formPeliculaErrorMessage", error.getMessage());
					return "redirect:/otraPelicula";
				}
				AGUSTINA.info("saliendo al metodo eliminar");
			    return "redirect:/listadoPelicula";
			}
	}