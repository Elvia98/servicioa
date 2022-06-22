package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registro_mantenimiento 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_registro_mantenimiento;
	
	private String observ_generales; 
	    
	private String status_registro; 
	
	private Date fecha_creacion; 
	
	private Date fecha_mod; 
	
	private Date fecha_agendada;
	
	private Integer id_empleado_registra; 	/* SE TRATA DE LA PERSONA REGISTRA UN MANTENIMEINTO (LO AGENDE OS E A EVENTUAL )*/
	
	private Integer id_empleado_realiza; 	/* SE TRATA DE LA PERSONA REALIZA Y EDITA EL MANTENIMEINTO */
	
	private String nombre_empleado_registra;
	
	private String nombre_empleado_realiza;
	
	private Integer sucursal_id;
	
	private String descripcion;
	
	private String nombre_sucursal;
	
	
	
	
	
	
	
	
	public String getNombre_sucursal() {
		return nombre_sucursal;
	}

	public void setNombre_sucursal(String nombre_sucursal) {
		this.nombre_sucursal = nombre_sucursal;
	}

	public String getNombre_empleado_registra() {
		return nombre_empleado_registra;
	}

	public void setNombre_empleado_registra(String nombre_empleado_registra) {
		this.nombre_empleado_registra = nombre_empleado_registra;
	}

	public String getNombre_empleado_realiza() {
		return nombre_empleado_realiza;
	}

	public void setNombre_empleado_realiza(String nombre_empleado_realiza) {
		this.nombre_empleado_realiza = nombre_empleado_realiza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getId_empleado_realiza() {
		return id_empleado_realiza;
	}

	public void setId_empleado_realiza(Integer id_empleado_realiza) {
		this.id_empleado_realiza = id_empleado_realiza;
	}

	public Integer getId_registro_mantenimiento() {
		return id_registro_mantenimiento;
	}

	public void setId_registro_mantenimiento(Integer id_registro_mantenimiento) {
		this.id_registro_mantenimiento = id_registro_mantenimiento;
	}

	public String getObserv_generales() {
		return observ_generales;
	}

	public void setObserv_generales(String observ_generales) {
		this.observ_generales = observ_generales;
	}

	public String getStatus_registro() {
		return status_registro;
	}

	public void setStatus_registro(String status_registro) {
		this.status_registro = status_registro;
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

	public Date getFecha_agendada() {
		return fecha_agendada;
	}

	public void setFecha_agendada(Date fecha_agendada) {
		this.fecha_agendada = fecha_agendada;
	}

	public Integer getId_empleado_registra() {
		return id_empleado_registra;
	}

	public void setId_empleado_registra(Integer id_empleado_registra) {
		this.id_empleado_registra = id_empleado_registra;
	}

	public Integer getSucursal_id() {
		return sucursal_id;
	}

	public void setSucursal_id(Integer sucursal_id) {
		this.sucursal_id = sucursal_id;
	}

}
