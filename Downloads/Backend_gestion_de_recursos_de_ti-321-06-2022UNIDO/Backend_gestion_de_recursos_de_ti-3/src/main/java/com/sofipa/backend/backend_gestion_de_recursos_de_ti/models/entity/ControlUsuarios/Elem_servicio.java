package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Elem_servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_elem_servicio;
	
	@Column( nullable=false)
	private Date fecha_registro;
	
	@Column( nullable=false)
	private Date fecha_modificacion = new Date();
	
	@Column(nullable=false)
	private String status_registro;
	
	@Column
	private Integer sucursal_id;
	
	@ManyToOne
    @JoinColumn(name="detalle_solicitudAct_id",  nullable = false)
	private Detalle_solicitud detalle_solicitudAct;
	
	@ManyToOne
    @JoinColumn(name="detalle_solicitudSusp_id")
	private Detalle_solicitud detalle_solicitudSusp;

	@ManyToOne
    @JoinColumn(name="servicio_usuario_id",  nullable = false)
	private Servicio_usuario servicio_usuario;
	
	public Integer getId_elem_servicio() {
		return id_elem_servicio;
	}

	public void setId_elem_servicio(Integer id_elem_servicio) {
		this.id_elem_servicio = id_elem_servicio;
	}
	
	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	public String getStatus_registro() {
		return status_registro;
	}

	public void setStatus_registro(String status_registro) {
		this.status_registro = status_registro;
	}
	/*Sucursal a la que se le asignan los servicios*/
	public Integer getSucursal_id() {
		return sucursal_id;
	}

	public void setSucursal_id(Integer sucursal_id) {
		this.sucursal_id = sucursal_id;
	}

    /*Guardará el detalle de solicitud que realizó la activación*/
	public Detalle_solicitud getDetalle_solicitudAct() {
		return detalle_solicitudAct;
	}

	public void setDetalle_solicitudAct(Detalle_solicitud detalle_solicitudAct) {
		this.detalle_solicitudAct = detalle_solicitudAct;
	}
	
    /*Guardará el detalle de solicitud que realizó la suspensión*/
	public Detalle_solicitud getDetalle_solicitudSusp() {
		return detalle_solicitudSusp;
	}

	public void setDetalle_solicitudSusp(Detalle_solicitud detalle_solicitudSusp) {
		this.detalle_solicitudSusp = detalle_solicitudSusp;
	}
	
	public Servicio_usuario getServicio_usuario() {
		return servicio_usuario;
	}

	public void setServicio_usuario(Servicio_usuario servicio_usuario) {
		this.servicio_usuario = servicio_usuario;
	}

	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}


}
