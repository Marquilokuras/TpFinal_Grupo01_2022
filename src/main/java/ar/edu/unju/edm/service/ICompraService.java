package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Compra;
@Service
public interface ICompraService {
	public Compra nuevaCompra();
	public void guardarCompra(Compra compra);
	public List<Compra> mostrarCompra();

}
