package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Compra;
import ar.edu.unju.edm.repository.CompraRepository;
import ar.edu.unju.edm.service.ICompraService;

@Service
public class ICompraServiceImp implements ICompraService{
	
	@Autowired 
    Compra compra;
 
    @Autowired
    CompraRepository compraRepository;

	@Override
	public Compra nuevaCompra() {
		// TODO Auto-generated method stub
		return compra;
	}

	@Override
	public void guardarCompra(Compra compra) {
		// TODO Auto-generated method stub
		compraRepository.save(compra);
	}

	@Override
	public List<Compra> mostrarCompra() {
		// TODO Auto-generated method stub
		return (List<Compra>) compraRepository.findAll();
	}

	
    
	
}
