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
public class UsuarioPelicula {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuarioCine;
	@ManyToOne(fetch=FetchType.LAZY)//lazy trae solo una parte
	@JoinColumn(name="dni")//parte comun de dos conjuntos
	private Usuario usuario;
	@ManyToOne(fetch=FetchType.LAZY)//lazy trae solo una parte
	@JoinColumn(name="id")//parte comun de dos conjuntos
	private Pelicula cine;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaDeCompra;
	
	public UsuarioPelicula() {
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

	public Pelicula getCine() {
		return cine;
	}

	public void setCine(Pelicula cine) {
		this.cine = cine;
	}

	public LocalDate getFechaDeCompran() {
		return fechaDeCompra;
	}

	public void setFechaDeompra (LocalDate fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}
}
