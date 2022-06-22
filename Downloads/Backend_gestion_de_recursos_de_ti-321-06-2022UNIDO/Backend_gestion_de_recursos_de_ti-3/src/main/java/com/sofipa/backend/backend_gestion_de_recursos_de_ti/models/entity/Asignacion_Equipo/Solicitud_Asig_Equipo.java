package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Solicitud_Asig_Equipo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_solicitud_asig_equipo;
	
	@Column( nullable=false)
	private Date fecha_solicitud;
	
	private String observaciones;
	
	@Column( nullable=false)
	private Date fecha_planeada_asig;
	
	@Column( nullable=false)
	private Date fecha_mod = new Date();
	
	@Column( nullable=false)
	private String status_solicitud;
	
	@Column( nullable=false)
	private String descrip_equipo;
	
	@Column( nullable=false)
	private String tipo_equipo;
	
	@Column( nullable=false)
	private String sustituye_a;
	
	@Column( nullable=false)
	private Integer solicitante_id;
	
	@Column( nullable=false)
	private Integer colaborador_id;
	
	
	private Integer administrador_TI;
	
	
	public Integer getId_solicitud_asig_equipo() {
		return id_solicitud_asig_equipo;
	}

	public void setId_solicitud_asig_equipo(Integer id_solicitud_asig_equipo) {
		this.id_solicitud_asig_equipo = id_solicitud_asig_equipo;
	}

	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFecha_planeada_asig() {
		return fecha_planeada_asig;
	}

	public void setFecha_planeada_asig(Date fecha_planeada_asig) {
		this.fecha_planeada_asig = fecha_planeada_asig;
	}

	public Date getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(Date fecha_mod) {
		this.fecha_mod = fecha_mod;
	}

	public String getStatus_solicitud() {
		return status_solicitud;
	}

	public void setStatus_solicitud(String status_solicitud) {
		this.status_solicitud = status_solicitud;
	}

	public String getDescrip_equipo() {
		return descrip_equipo;
	}

	public void setDescrip_equipo(String descrip_equipo) {
		this.descrip_equipo = descrip_equipo;
	}

	public String getTipo_equipo() {
		return tipo_equipo;
	}

	public void setTipo_equipo(String tipo_equipo) {
		this.tipo_equipo = tipo_equipo;
	}

	public String getSustituye_a() {
		return sustituye_a;
	}

	public void setSustituye_a(String sustituye_a) {
		this.sustituye_a = sustituye_a;
	}

	public Integer getSolicitante_id() {
		return solicitante_id;
	}

	public void setSolicitante_id(Integer solicitante_id) {
		this.solicitante_id = solicitante_id;
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
	
}
