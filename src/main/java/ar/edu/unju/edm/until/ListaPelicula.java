package ar.edu.unju.edm.until;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.edm.model.Pelicula;

@Component 
public class ListaPelicula {
	private List<Pelicula> listado = new ArrayList<>();
	
	//Constructor por defecto
	public ListaPelicula() {
		// TODO Auto-generated constructor stub
	}

	//Getter and Setters
	public List<Pelicula> getListado() {
		return listado;
	}

	public void setListado(List<Pelicula> listado) {
		this.listado = listado;
	}
	
}
