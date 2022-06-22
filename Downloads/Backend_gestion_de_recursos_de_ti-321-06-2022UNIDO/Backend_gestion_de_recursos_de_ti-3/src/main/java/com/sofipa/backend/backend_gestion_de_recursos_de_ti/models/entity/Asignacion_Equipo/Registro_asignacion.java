package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo;

import java.io.File;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Registro_asignacion 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_registro_asignacion;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "solicitud_asig_equipo_id", referencedColumnName = "id_solicitud_asig_equipo")
	private Solicitud_Asig_Equipo solicitud;
	
	private String status_registro;
	
	private Date fecha_asignacion = new Date();
	
	private Date fecha_modificacion = new Date();

	private String observaciones;
	
	private Integer colaborador_id;
	
	private Integer administrador_TI;
	
	private String nombre_empleado_asignado;
	
	private String nombre_empleado_registra;
	
	
	
	

	public Integer getId_registro_asignacion() {
		return id_registro_asignacion;
	}

	public void setId_registro_asignacion(Integer id_registro_asignacion) {
		this.id_registro_asignacion = id_registro_asignacion;
	}

	public Solicitud_Asig_Equipo getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud_Asig_Equipo solicitud) {
		this.solicitud = solicitud;
	}

	public Integer getColaborador_id() {
		return colaborador_id;
	}

	public void setColaborador_id(Integer colaborador_id) {
		this.colaborador_id = colaborador_id;
	}

	public Integer getAdministrador_TI() {
		return administrador_TI;
	}

	public void setAdministrador_TI(Integer administrador_TI) {
		this.administrador_TI = administrador_TI;
	}

	public String getStatus_registro() {
		return status_registro;
	}

	public void setStatus_registro(String status_registro) {
		this.status_registro = status_registro;
	}

	public Date getFecha_asignacion() {
		return fecha_asignacion;
	}

	public void setFecha_asignacion(Date fecha_asignacion) {
		this.fecha_asignacion = fecha_asignacion;
	}

	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getNombre_empleado_asignado() {
		return nombre_empleado_asignado;
	}

	public void setNombre_empleado_asignado(String nombre_empleado_asignado) {
		this.nombre_empleado_asignado = nombre_empleado_asignado;
	}

	public String getNombre_empleado_registra() {
		return nombre_empleado_registra;
	}

	public void setNombre_empleado_registra(String nombre_empleado_registra) {
		this.nombre_empleado_registra = nombre_empleado_registra;
	}

	
	
}
