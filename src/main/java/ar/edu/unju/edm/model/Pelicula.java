package ar.edu.unju.edm.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Lob;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity //sirve para conectar con PeliculaRepository
@Table (name = "pelicula")
public class Pelicula {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name= "idPelicula")
	private Long idPelicula;
	@NotEmpty
	@Size(min=3, max=100, message="EL nombre debe tener 2 caracteres minimo, maximo 15")
	@NotEmpty(message="El nombre no puede estar vacio")
	
	//@Size(min=3, max=100, message="EL nombre debe tener 2 caracteres minimo, maximo 15")
	//@NotEmpty(message="El nombre no puede estar vacio")
	@NotBlank(message="El nombre no puede ser espacios en blanco")
	private String nombrePelicula;
	
	@NotBlank(message="La descripcion no puede ser espacios en blanco")
	@Column(name="descripcionPelicula")
	//@NotEmpty
	private String descripcionPelicula;
	
	//@NotNull
	@Min(value=0,message="El duracion en horas debe ser mayor que 0")
	@Max(value=857,message="El duracion en horas debe ser menor que 857")
	private Integer duracionPelicula;
  
	@NotEmpty
	private String generoPelicula;
	
	@Column (name = "fechaestreno")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaEstreno;
	
	private Boolean estadoPelicula;
	
	private LocalTime horario;

	//portada
	@Lob
	private String imagen;
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	@Column (name = "actoresPelicula")
	private String actoresPelicula;
	
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
	
	/*public LocalTime getHorario1() {
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
	}*/

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Boolean getEstadoPelicula() {
		return estadoPelicula;
	}

	public void setEstadoPelicula(Boolean estadoPelicula) {
		this.estadoPelicula = estadoPelicula;
	}

	public String getActoresPelicula() {
		return actoresPelicula;
	}

	public void setActoresPelicula(String actoresPelicula) {
		this.actoresPelicula = actoresPelicula;
	}
	
}

