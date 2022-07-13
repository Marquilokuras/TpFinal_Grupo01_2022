package ar.edu.unju.edm.until;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.edm.model.Pelicula;
import ar.edu.unju.edm.model.UsuarioPelicula;

@Component
public class ListadoUsuarioPelicula {
	 private List<UsuarioPelicula> listado = new ArrayList<>() ;
     public ListadoUsuarioPelicula() {
		// TODO Auto-generated constructor stub
	}
	public List<UsuarioPelicula> getListado() {
		return listado;
	}
	public void setListado(List<UsuarioPelicula> listado) {
		this.listado = listado;
	}
     
}
