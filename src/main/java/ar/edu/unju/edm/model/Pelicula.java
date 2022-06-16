package ar.edu.unju.edm.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaEstreno;
	@NotNull
	@Min(value=1,message="El duracion debe ser mayor que 1")
	@Max(value=99999,message="El duracion debe ser menor que 99999")
	private Integer cupo;
	@NotNull
	@Min(value=1,message="El duracion debe ser mayor que 1")
	@Max(value=99999,message="El duracion debe ser menor que 99999")
	private Double costo;
	@Min(value=1,message="El valoracion debe ser mayor que 1")
	@Max(value=5,message="El valoracion debe ser menor que 5")
	private Integer valoracion;
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

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	public Boolean getEstadoPelicula() {
		return estadoPelicula;
	}

	public void setEstadoCurso(Boolean estadoPelicula) {
		this.estadoPelicula = estadoPelicula;
	}
}
