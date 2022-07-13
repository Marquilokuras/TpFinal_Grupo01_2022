package ar.edu.unju.edm.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer idComentario;
    @NotEmpty
	private String texto;
	@NotNull
	private Integer valoracion;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private Usuario usuario;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPelicula")
	private Pelicula pelicula;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaComen;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Info() {
		// TODO Auto-generated constructor stub
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Integer getValoracion() {
		return valoracion;
	}
	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}
	public LocalDate getFechaComen() {
		return fechaComen;
	}
	public void setFechaComen(LocalDate fechaComen) {
		this.fechaComen = fechaComen;
	}

	public Integer getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Integer idComentario) {
		this.idComentario = idComentario;
	}
	
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
}