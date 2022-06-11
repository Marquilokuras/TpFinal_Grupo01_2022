package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
<<<<<<< HEAD

=======
>>>>>>> branch 'Marcos.Quinteros' of https://github.com/Marquilokuras/TpFinal_Grupo01_2022.git
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PrincipalController {
	@GetMapping({"/","/index","/home"})
	public String getIndex(){
		
		return "/index";
	}
	
}
