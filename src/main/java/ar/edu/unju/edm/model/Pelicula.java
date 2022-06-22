package ar.edu.unju.edm.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity //sirve para conectar con PeliculaRepository
public class Pelicula {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPelicula;
	
	@NotEmpty
	private String nombrePelicula;
	
	@Column(name="descripcionPelicula")
	@NotEmpty
	private String descripcionPelicula;
	
	@NotNull
	@Min(value=0,message="El duracion en horas debe ser mayor que 0")
	@Max(value=857,message="El duracion en horas debe ser menor que 857")
	private Integer duracionPelicula;
	
	@NotEmpty
	private String generoPelicula;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaEstreno;
	
	private LocalTime horario1;
	
	private LocalTime horario2;
	
	private LocalTime horario3;
	
	//portada
	@Lob
	private String imagen;
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	private Boolean estadoPelicula;
	
	public Pelicula() {
		// TODO Auto-generated constructor stub
	}

	public String getNombrePelicula() {
		return nombrePelicula;
	}

	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}

	public String getDescripcionPelicula() {
		return descripcionPelicula;
	}

	public void setDescripcionPelicula(String descripcionPelicula) {
		this.descripcionPelicula = descripcionPelicula;
	}

	public Integer getDuracionPelicula() {
		return duracionPelicula;
	}

	public void setDuracionPelicula(Integer duracionPelicula) {
		this.duracionPelicula = duracionPelicula;
	}

	public Long getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Long idPelicula) {
		this.idPelicula = idPelicula;
	}

	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getGeneroPelicula() {
		return generoPelicula;
	}

	public void setGeneroPelicula(String generoPelicula) {
		this.generoPelicula = generoPelicula;
	}

	public LocalTime getHorario1() {
		return horario1;
	}

	public void setHorario1(LocalTime horario1) {
		this.horario1 = horario1;
	}

	public LocalTime getHorario2() {
		return horario2;
	}

	public void setHorario2(LocalTime horario2) {
		this.horario2 = horario2;
	}

	public LocalTime getHorario3() {
		return horario3;
	}

	public void setHorario3(LocalTime horario3) {
		this.horario3 = horario3;
	}

	public Boolean getEstadoPelicula() {
		return estadoPelicula;
	}

	public void setEstadoPelicula(Boolean estadoPelicula) {
		this.estadoPelicula = estadoPelicula;
	}

	
}
