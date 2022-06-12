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
@Entity
public class Cine {
	@NotEmpty
	private String nombreCine;
	@Column(name="descripcionCine")
	@NotEmpty
	private String descripcionCine;
	@NotNull
	@Min(value=0,message="El duracion en horas debe ser mayor que 0")
	@Max(value=857,message="El duracion en horas debe ser menor que 857")
	private Integer duracionCine;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCine;
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
	private Boolean estadoCurso;
	
	public Cine() {
		// TODO Auto-generated constructor stub
	}

	public String getNombreCine() {
		return nombreCine;
	}

	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}

	public String getDescripcionCine() {
		return descripcionCine;
	}

	public void setDescripcionCine(String descripcionCine) {
		this.descripcionCine = descripcionCine;
	}

	public Integer getDuracionCine() {
		return duracionCine;
	}

	public void setDuracionCine(Integer duracionCine) {
		this.duracionCine = duracionCine;
	}

	public Long getIdCine() {
		return idCine;
	}

	public void setIdCine(Long idCine) {
		this.idCine = idCine;
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

	public Boolean getEstadoCurso() {
		return estadoCurso;
	}

	public void setEstadoCurso(Boolean estadoCurso) {
		this.estadoCurso = estadoCurso;
	}
}
