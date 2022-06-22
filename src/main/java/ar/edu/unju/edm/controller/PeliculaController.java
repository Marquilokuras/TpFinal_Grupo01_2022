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
	
	@GetMapping("/otraPelicula")
	public ModelAndView addUser() {
		ModelAndView vista = new ModelAndView("cargarPelicula");
	
		vista.addObject("pelicula", nuevaPelicula);
		vista.addObject("editMode", false);
		return vista;
	}
	
	@PostMapping(value="/guardarPelicula", consumes = "multipart/form-data")
	public String saveMovie(@Valid @ModelAttribute("pelicula")Pelicula peliculaparaguardar, BindingResult resultado, @RequestParam("file") MultipartFile file, Model model) {
		AGUSTINA.info("Ingresando al metodo GUARDAR PELICULA");
		
		if(resultado.hasErrors()) {
			AGUSTINA.fatal("Error en el meotodo GUARDAR PELICULA");
			
			model.addAttribute("pelicula", peliculaparaguardar);
			return "cargarPelicula";
		}
		
		try {
			byte[] content = file.getBytes();
			String base64 = Base64.getEncoder().encodeToString(content);
			peliculaparaguardar.setImagen(base64);
			//peliculaparaguardar.setEstadoPelicula(true);
			peliculaService.guardarPelicula(peliculaparaguardar);
		}catch(Exception error) {
			model.addAttribute("formPeliculaErrorMessage", error.getMessage());
			model.addAttribute("pelicula", nuevaPelicula);
			return "cargarPelicula";
		}
		
		model.addAttribute("formPeliculaErrorMessage", "Pelicula Guardada Correctamente");
		model.addAttribute("pelicula", peliculaparaguardar);
		
		return "cargarPelicula";
	}
	
	@GetMapping("/editarPelicula/{idPelicula}")

	public ModelAndView editMovie(Model model,@PathVariable (name="idPelicula") Long idPelicula)throws Exception {	
		Pelicula peliculaEncontrada = new Pelicula();
		
		try {
			peliculaEncontrada = peliculaService.buscarPelicula(idPelicula);
		}catch(Exception error){
			model.addAttribute("formPeliculaErrorMessage", error.getMessage());
		}
		
		ModelAndView modelView = new ModelAndView("cargarPelicula");
		modelView.addObject("pelicula", peliculaEncontrada);
		modelView.addObject("editMode", true);
		return modelView;
	}
	
	@PostMapping("/editarPelicula")
	public ModelAndView postEditMovie(@ModelAttribute ("pelicula") Pelicula peliculaparamodificar) {  
		peliculaService.modificarPelicula(peliculaparamodificar);
		ModelAndView vista = new ModelAndView("listadoPelicula");
		vista.addObject("listaPelicula", peliculaService.mostrarPeliculas());
		vista.addObject("formPeliculaErrorMessage", "Pelicula Guardado Correctamente");
		return vista;
	}
	
	
	
	
}
