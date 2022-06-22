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
public class Elem_mantenimiento 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_elem_mantenimiento;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "actividad_mant_id", referencedColumnName = "id_actividad_mant ")
	private Actividad_mant actividad;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mantenimiento_equipo_id", referencedColumnName = "id_mantenimiento_equipo ")
	private Mantenimiento_equipo mantenimiento_equipo;

	public Integer getId_elem_mantenimiento() {
		return id_elem_mantenimiento;
	}

	public void setId_elem_mantenimiento(Integer id_elem_mantenimiento) {
		this.id_elem_mantenimiento = id_elem_mantenimiento;
	}

	public Actividad_mant getActividad_mant() {
		return actividad;
	}

	public void setActividad_mant(Actividad_mant actividad_mant) {
		this.actividad = actividad_mant;
	}

	public Mantenimiento_equipo getRegistroMantenimiento() 
	{
		return mantenimiento_equipo;
	}

	public void setMantenimiento_equipo(Mantenimiento_equipo antenimiento_equipo) 
	{
		this.mantenimiento_equipo = antenimiento_equipo;
	}
}
