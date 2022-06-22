package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo_solicitud_usuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipo_solicitud_usuario;
	
	@Column( nullable=false)
	private String tipo_solicitud;

	@Column( nullable=false)
	private Date fecha_creacion;

	@Column( nullable=false)
	private Date fecha_mod = new Date();  

	private String descripcion;

	private String status_solicitud;

	public Integer getId_tipos_solicitud_usuario() {
		return id_tipo_solicitud_usuario;
	}

	public void setId_tipos_solicitud_usuario(Integer id_tipos_solicitud_usuario) {
		this.id_tipo_solicitud_usuario = id_tipos_solicitud_usuario;
	}

	public String getTipo_solicitud() {
		return tipo_solicitud;
	}

	public void setTipo_solicitud(String tipo_solicitud) {
		this.tipo_solicitud = tipo_solicitud;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getStatus_solicitud() {
		return status_solicitud;
	}

	public void setStatus_solicitud(String status_solicitud) {
		this.status_solicitud = status_solicitud;
	}

	public Integer getId_tipo_solicitud_usuario() {
		return id_tipo_solicitud_usuario;
	}

	public void setId_tipo_solicitud_usuario(Integer id_tipo_solicitud_usuario) {
		this.id_tipo_solicitud_usuario = id_tipo_solicitud_usuario;
	}
}
