package ar.edu.unju.edm.until;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.edm.model.Compra;

@Component
public class ListaCompra {
	 private List<Compra> listado = new ArrayList<>() ;
     public ListaCompra() {
		// TODO Auto-generated constructor stub
	}
	public List<Compra> getListado() {
		return listado;
	}
	public void setListado(List<Compra> listado) {
		this.listado = listado;
	}
     
}
