package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo_mant 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipo_mant;
	
	@Column( nullable=false)
	private String nombre;
    
	private String descripcion;

	private Date fecha_creacion;

	private String status_mant;

	public Integer getId_tipo_mant() {
		return id_tipo_mant;
	}

	public void setId_tipo_mant(Integer id_tipo_mant) {
		this.id_tipo_mant = id_tipo_mant;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getStatus_mant() {
		return status_mant;
	}

	public void setStatus_mant(String status_mant) {
		this.status_mant = status_mant;
	}
	
	
}
