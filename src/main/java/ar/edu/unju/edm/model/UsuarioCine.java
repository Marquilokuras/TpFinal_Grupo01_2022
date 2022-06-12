package ar.edu.unju.edm.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component					//mapeo del modelo relacional hibernate
@Entity
public class UsuarioCine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuarioCine;
	@ManyToOne(fetch=FetchType.LAZY)//lazy trae solo una parte
	@JoinColumn(name="dni")//parte comun de dos conjuntos
	private Usuario usuario;
	@ManyToOne(fetch=FetchType.LAZY)//lazy trae solo una parte
	@JoinColumn(name="idCine")//parte comun de dos conjuntos
	private Cine cine;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaDeInscripcion;
	
	public UsuarioCine() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdUsuarioCine() {
		return idUsuarioCine;
	}

	public void setIdUsuarioCine(Integer idUsuarioCine) {
		this.idUsuarioCine = idUsuarioCine;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	public LocalDate getFechaDeInscripcion() {
		return fechaDeInscripcion;
	}

	public void setFechaDeInscripcion(LocalDate fechaDeInscripcion) {
		this.fechaDeInscripcion = fechaDeInscripcion;
	}
}
