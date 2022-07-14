package ar.edu.unju.edm.model;

import java.time.LocalDate;
import java.util.List;

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
public class Compra {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCompra;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPelicula")
	private Pelicula pelicula;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaDeCompra;
	
	
	public Integer getIdCompra() {
		return idCompra;
	}


	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}


	public Compra() {
		// TODO Auto-generated constructor stub
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula= pelicula;
	}

	public LocalDate getFechaDeCompra() {
		return fechaDeCompra;
	}

	public void setFechaDeCompra (LocalDate fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}


	public void save(Compra compra) {
		// TODO Auto-generated method stub
		
	}


	public List<Compra> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	


}
