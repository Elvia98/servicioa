package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo_servicio 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipo_servicio;
	
	@Column( nullable=false)
	private String nombre_servicio;

	@Column( nullable=false)
	private Date fecha_creacion_serv;

	@Column( nullable=false)
	private Date fecha_mod_serv = new Date();    

	private String descripcion_serv;

	private boolean tiene_privilegio;

	private String status_servicio;
	
	public Integer getId_tipo_servicio() {
		return id_tipo_servicio;
	}

	public void setId_tipo_servicio(Integer id_tipo_servicio) {
		this.id_tipo_servicio = id_tipo_servicio;
	}

	public String getNombre_servicio() {
		return nombre_servicio;
	}

	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}

	public Date getFecha_creacion_serv() {
		return fecha_creacion_serv;
	}

	public void setFecha_creacion_serv(Date fecha_creacion_serv) {
		this.fecha_creacion_serv = fecha_creacion_serv;
	}

	public Date getFecha_mod_serv() {
		return fecha_mod_serv;
	}

	public void setFecha_mod_serv(Date fecha_mod_serv) {
		this.fecha_mod_serv = fecha_mod_serv;
	}

	public String getDescripcion_serv() {
		return descripcion_serv;
	}

	public void setDescripcion_serv(String descripcion_serv) {
		this.descripcion_serv = descripcion_serv;
	}

	public boolean isTiene_privilegio() {
		return tiene_privilegio;
	}

	public void setTiene_privilegio(boolean tiene_privilegio) {
		this.tiene_privilegio = tiene_privilegio;
	}

	public String getStatus_servicio() {
		return status_servicio;
	}

	public void setStatus_servicio(String status_servicio) {
		this.status_servicio = status_servicio;
	}

}
