package ar.edu.unju.edm.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Info;

@Service
public interface ComentarioValoracionService {
	public Info nuevaInfo();
	public void guardarInfo(Info info);
	public List<Info> mostrarInfo();
}