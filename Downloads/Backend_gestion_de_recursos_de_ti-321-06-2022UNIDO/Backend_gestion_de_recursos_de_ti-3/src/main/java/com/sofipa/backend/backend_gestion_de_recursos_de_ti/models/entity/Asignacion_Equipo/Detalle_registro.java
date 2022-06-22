package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo;

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

@Entity
public class Detalle_registro 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_detalle_asignacion;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="registro_asignacion_id",  nullable = false)
    private Registro_asignacion registro;

	private String status_detalle;
	
	@Column( nullable=false)
	private String tipo_activo;
	
	@Column( nullable=false)
	private String nombre_equipo;
	
	@Column( nullable=true)
	private String observ_equipo;
	
	@Column( nullable=false)
	private Integer equipo_id;
	
	@Lob
	@Column(name=" archivo_responsiva_pdf", columnDefinition="longblob",nullable=true)
	private byte[] archivo_responsiva;
	
	
	
	
	@Column( nullable=true)
	private String direccion_mac;

	@Column( nullable=true)
	private String direccion_ip;

	@Column( nullable=true)
	private String version_office;

	@Column( nullable=true)
	private String licencia_office;

	@Column( nullable=true)
	private String programas_instalados;

	@Column( nullable=true)
	private String direccion_colaborador;

	@Column( nullable=true)
	private int precio;

	@Column( nullable=true)
	private String precio_nombre;
	
	
	
	
	
	
	
	public byte[] getArchivo_responsiva() 
	{
		return archivo_responsiva;
	}

	public void setArchivo_responsiva(byte[] archivo_responsiva) {
		this.archivo_responsiva = archivo_responsiva;
	}

	public Integer getId_detalle_asignacion() {
		return id_detalle_asignacion;
	}

	public void setId_detalle_asignacion(Integer id_detalle_asignacion) {
		this.id_detalle_asignacion = id_detalle_asignacion;
	}

	public String getStatus_detalle() {
		return status_detalle;
	}

	public void setStatus_detalle(String status_detalle) {
		this.status_detalle = status_detalle;
	}

	public String getTipo_activo() {
		return tipo_activo;
	}

	public void setTipo_activo(String tipo_activo) {
		this.tipo_activo = tipo_activo;
	}

	public String getObserv_equipo() {
		return observ_equipo;
	}

	public void setObserv_equipo(String observ_equipo) {
		this.observ_equipo = observ_equipo;
	}

	public Integer getEquipo_id() {
		return equipo_id;
	}

	public void setEquipo_id(Integer equipo_id) {
		this.equipo_id = equipo_id;
	}

	public Registro_asignacion getRegistro() {
		return registro;
	}

	public void setRegistro(Registro_asignacion registro) {
		this.registro = registro;
	}

	public String getNombre_equipo() {
		return nombre_equipo;
	}

	public void setNombre_equipo(String nombre_equipo) {
		this.nombre_equipo = nombre_equipo;
	}

	public String getDireccion_mac() {
		return direccion_mac;
	}

	public void setDireccion_mac(String direccion_mac) {
		this.direccion_mac = direccion_mac;
	}

	public String getDireccion_ip() {
		return direccion_ip;
	}

	public void setDireccion_ip(String direccion_ip) {
		this.direccion_ip = direccion_ip;
	}

	public String getVersion_office() {
		return version_office;
	}

	public void setVersion_office(String version_office) {
		this.version_office = version_office;
	}

	public String getLicencia_office() {
		return licencia_office;
	}

	public void setLicencia_office(String licencia_office) {
		this.licencia_office = licencia_office;
	}

	public String getProgramas_instalados() {
		return programas_instalados;
	}

	public void setProgramas_instalados(String programas_instalados) {
		this.programas_instalados = programas_instalados;
	}

	public String getDireccion_colaborador() {
		return direccion_colaborador;
	}

	public void setDireccion_colaborador(String direccion_colaborador) {
		this.direccion_colaborador = direccion_colaborador;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getPrecio_nombre() {
		return precio_nombre;
	}

	public void setPrecio_nombre(String precio_nombre) {
		this.precio_nombre = precio_nombre;
	}

	
}
