package ar.edu.unju.edm.until;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ar.edu.unju.edm.model.Info;

@Component
public class ListaComentarioValoracion  {
	private List <Info> listado = new ArrayList<>();
	
	public ListaComentarioValoracion() {
		// TODO Auto-generated constructor stub
	}

	public List<Info> getListado() {
		return listado;
	}

	public void setListado(List<Info> listado) {
		this.listado = listado;
	}
	
}