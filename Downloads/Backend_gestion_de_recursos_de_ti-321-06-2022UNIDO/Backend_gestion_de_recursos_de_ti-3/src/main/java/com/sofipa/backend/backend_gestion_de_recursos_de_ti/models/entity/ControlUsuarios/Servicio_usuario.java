package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Servicio_usuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_servicio_usuario;
	
	private String contrasenia;   

	@Column( nullable=false)
	private Date fecha_registro;

	@Column( nullable=false)
	private Date fecha_mod_reg = new Date();  

	private String usuario;

	
	@Lob
	@Column(name=" archivo_responsiva", columnDefinition="longblob", nullable=true)
	private byte[] archivo_responsiva;

	@OneToOne
    @JoinColumn(name = "detalle_solicitud_id", referencedColumnName = "id_detalle_solicitud")
	private Detalle_solicitud detalle_solicitud;
		
		
	public Integer getId_servicio_usuario() {
		return id_servicio_usuario;
	}

	public void setId_servicio_usuario(Integer id_servicio_usuario) {
		this.id_servicio_usuario = id_servicio_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Date getFecha_mod_reg() {
		return fecha_mod_reg;
	}

	public void setFecha_mod_reg(Date fecha_mod_reg) {
		this.fecha_mod_reg = fecha_mod_reg;
	}


	public byte[] getArchivo_responsiva() {
		return archivo_responsiva;
	}

	public void setArchivo_responsiva(byte[] archivo_responsiva) {
		this.archivo_responsiva = archivo_responsiva;
	}
	
	public Detalle_solicitud getDetalle_solicitud() {
		return detalle_solicitud;
	}

	public void setDetalle_solicitud(Detalle_solicitud detalle_solicitud) {
		this.detalle_solicitud = detalle_solicitud;
	}
	
	

}
