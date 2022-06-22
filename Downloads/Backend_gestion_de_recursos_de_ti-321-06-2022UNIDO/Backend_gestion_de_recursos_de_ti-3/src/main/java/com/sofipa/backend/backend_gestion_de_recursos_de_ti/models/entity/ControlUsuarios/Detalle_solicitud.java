package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Detalle_solicitud 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_detalle_solicitud;
	
	@Column( nullable=false)
	private String status_serv;

	@ManyToOne
    @JoinColumn(name="solicitud_id ",  nullable = false)
	private Solicitud solicitud; 
	
	@ManyToOne
    @JoinColumn(name="tipo_servicio_id ",  nullable = false)
	private Tipo_servicio tipo_servicio;
	
	/*servicio_usuario_id: contendrá el id del servicio usuario a modificar, en caso de que sea una activación o suspensión */
	private Integer servicio_usuario_id;

	
	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public Tipo_servicio getTipo_servicio() {
		return tipo_servicio;
	}

	public void setTipo_servicio(Tipo_servicio tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}
	

	public Integer getId_detalle_solicitud() {
		return id_detalle_solicitud;
	}

	public void setId_detalle_solicitud(Integer id_detalle_solicitud) {
		this.id_detalle_solicitud = id_detalle_solicitud;
	}

	public String getStatus_serv() {
		return status_serv;
	}

	public void setStatus_serv(String status_serv) {
		this.status_serv = status_serv;
	}

	public Integer getServicio_usuario_id() {
		return servicio_usuario_id;
	}

	public void setServicio_usuario_id(Integer servicio_usuario_id) {
		this.servicio_usuario_id = servicio_usuario_id;
	}

	
	
}
