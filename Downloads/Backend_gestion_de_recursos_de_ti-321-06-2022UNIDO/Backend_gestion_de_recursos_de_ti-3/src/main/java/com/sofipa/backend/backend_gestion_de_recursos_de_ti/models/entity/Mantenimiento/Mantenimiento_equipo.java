package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Mantenimiento_equipo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_mantenimiento_equipo;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registro_mantenimiento_id", referencedColumnName = "id_registro_mantenimiento ")
	private Registro_mantenimiento registroMantenimiento;
	
	private String comentarios_usuario;
    
	private String tipo_activo; 

	private String problema_localizado;

	private String observ_equipo;

	private Integer equipo_id; 

	private String nombre_equipo;

	public Integer getId_mantenimiento_equipo() 
	{
		return id_mantenimiento_equipo;
	}

	public void setId_mantenimiento_equipo(Integer id_mantenimiento_equipo) 
	{
		this.id_mantenimiento_equipo = id_mantenimiento_equipo;
	}

	public String getComentarios_usuario() 
	{
		return comentarios_usuario;
	}

	public void setComentarios_usuario(String comentarios_usuario) 
	{
		this.comentarios_usuario = comentarios_usuario;
	}

	public String getTipo_activo() 
	{
		return tipo_activo;
	}

	public void setTipo_activo(String tipo_activo) 
	{
		this.tipo_activo = tipo_activo;
	}

	public String getProblema_localizado() 
	{
		return problema_localizado;
	}

	public void setProblema_localizado(String problema_localizado) 
	{
		this.problema_localizado = problema_localizado;
	}

	public String getObserv_equipo() 
	{
		return observ_equipo;
	}

	public void setObserv_equipo(String observ_equipo) 
	{
		this.observ_equipo = observ_equipo;
	}

	public Integer getEquipo_id() 
	{
		return equipo_id;
	}

	public void setEquipo_id(Integer equipo_id) 
	{
		this.equipo_id = equipo_id;
	}

	public Registro_mantenimiento getRegistroMantenimiento() 
	{
		return registroMantenimiento;
	}

	public void setRegistroMantenimiento(Registro_mantenimiento registro_mantenimiento) 
	{
		this.registroMantenimiento = registro_mantenimiento;
	}

	public String getNombre_equipo() {
		return nombre_equipo;
	}

	public void setNombre_equipo(String nombre_equipo) {
		this.nombre_equipo = nombre_equipo;
	}

}
