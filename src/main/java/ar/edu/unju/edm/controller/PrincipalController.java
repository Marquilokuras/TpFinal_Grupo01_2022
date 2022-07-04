package ar.edu.unju.edm.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class PrincipalController implements ErrorController{
	
	//Declaraciondevariablepararedirigirelerror
		private static final String PATH="/error";
	
	@GetMapping({"/index","/home"})
	public String getIndex(){
		
		return "index";
	}	
	
	@GetMapping({"/","/login","/ingreso"})
	public String getLogin(){
		
		return "login";
	}	
	
	//Valor que retorna en este caso el html error
		@RequestMapping(value=PATH)
		public String defaultErrorMessage() {
			return "error";
		}
		
		public static String getPath() {
			return PATH;
		}
}
