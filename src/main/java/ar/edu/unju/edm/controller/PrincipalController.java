package ar.edu.unju.edm.controller;



import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class PrincipalController implements ErrorController{
	
	//Declaraciondevariablepararedirigirelerror
		private static final String PATH="/error";
	
	@GetMapping({"/index","/home"})
	public String getIndex(){
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
		System.out.println(userDetail.getUsername());
		return "index";
	}
	
	
	
	@GetMapping({"/registroAdmin"})
	public String getRegistro(){
		
		return "registroAdmin";
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