package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Solicitud 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_solicitud;
	
	@Column( nullable=false)
	private String status_solicitud;

	private Date fecha_atencion;  

	@Column( nullable=false)
	private Date fecha_solicitud;

	@Column( nullable=false)
	private Date fecha_modificacion = new Date();
	
	private Date fecha_planeada_act;  

	private String sustituye_a;

	private String tipo;

	private String comentarios;
	
	private Date fecha_alta;
	
	private Date fecha_baja;

	private Integer puesto_a_cubrir; 

	private Integer sucursal_id;

	private boolean reemplazo;
	
	private String nom_supervisor;

	private Integer administrador_TI_id;

	@Column( nullable=false)
	private Integer solicitante_id;   

	@Column( nullable=false)
	private Integer colaborador_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_solicitud_usuario_id", referencedColumnName = "id_tipo_solicitud_usuario")
	private Tipo_solicitud_usuario Tipo_solicitud_usuario;

	
	public Tipo_solicitud_usuario getTipo_solicitud_usuario() {
		return Tipo_solicitud_usuario;
	}

	public void setTipo_solicitud_usuario(Tipo_solicitud_usuario tipo_solicitud_usuario) {
		Tipo_solicitud_usuario = tipo_solicitud_usuario;
	}

	public Integer getId_solicitud() {
		return id_solicitud;
	}

	public void setId_solicitud(Integer id_solicitud) {
		this.id_solicitud = id_solicitud;
	}

	public String getStatus_solicitud() {
		return status_solicitud;
	}

	public void setStatus_solicitud(String status_solicitud) {
		this.status_solicitud = status_solicitud;
	}

	public Date getFecha_atencion() {
		return fecha_atencion;
	}

	public void setFecha_atencion(Date fecha_atencion) {
		this.fecha_atencion = fecha_atencion;
	}

	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public Date getFecha_planeada_act() {
		return fecha_planeada_act;
	}

	public void setFecha_planeada_act(Date fecha_planeada_act) {
		this.fecha_planeada_act = fecha_planeada_act;
	}

	public String getSustituye_a() {
		return sustituye_a;
	}

	public void setSustituye_a(String sustituye_a) {
		this.sustituye_a = sustituye_a;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public Date getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public Integer getPuesto_a_cubrir() {
		return puesto_a_cubrir;
	}

	public void setPuesto_a_cubrir(Integer puesto_a_cubrir) {
		this.puesto_a_cubrir = puesto_a_cubrir;
	}

	public Integer getSucursal_id() {
		return sucursal_id;
	}

	public void setSucursal_id(Integer sucursal_id) {
		this.sucursal_id = sucursal_id;
	}

	public boolean isReemplazo() {
		return reemplazo;
	}

	public void setReemplazo(boolean reemplazo) {
		this.reemplazo = reemplazo;
	}	
	
    /*Nuevo campo "SUPERVISOR" agregado a la base de datos*/
    public String getNom_supervisor() {
		return nom_supervisor;
	}

	public void setNom_supervisor(String nom_supervisor) {
		this.nom_supervisor = nom_supervisor;
	}
	
	public Integer getAdministrador_TI_id() {
		return administrador_TI_id;
	}

	public void setAdministrador_TI_id(Integer administrador_TI_id) {
		this.administrador_TI_id = administrador_TI_id;
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


}
