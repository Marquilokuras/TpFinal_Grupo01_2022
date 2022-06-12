package ar.edu.unju.edm.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Cine;

@Service
public interface ICineService {
	public List<Cine>mostrarCines();
	public void eliminarCine(Integer idCine) throws Exception;
	public void modificarCine(Cine cine);
	public Cine buscarCine(Long idCine) throws Exception;
	public void guardarCine(@Valid Cine cineparaguardar);
}
