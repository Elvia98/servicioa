package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actividad_mant 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_actividad_mant;
	
	private String nombre_act;
    
	private String descripcion;

	private Date fecha_creacion;

	private String status_actividad;

	private Integer tipo_mant_id;

	public Integer getId_actividad_mant() {
		return id_actividad_mant;
	}

	public void setId_actividad_mant(Integer id_actividad_mant) {
		this.id_actividad_mant = id_actividad_mant;
	}

	public String getNombre_act() {
		return nombre_act;
	}

	public void setNombre_act(String nombre_act) {
		this.nombre_act = nombre_act;
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

	public String getStatus_actividad() {
		return status_actividad;
	}

	public void setStatus_actividad(String status_actividad) {
		this.status_actividad = status_actividad;
	}

	public Integer getTipo_mant_id() {
		return tipo_mant_id;
	}

	public void setTipo_mant_id(Integer tipo_mant_id) {
		this.tipo_mant_id = tipo_mant_id;
	}
	
}
