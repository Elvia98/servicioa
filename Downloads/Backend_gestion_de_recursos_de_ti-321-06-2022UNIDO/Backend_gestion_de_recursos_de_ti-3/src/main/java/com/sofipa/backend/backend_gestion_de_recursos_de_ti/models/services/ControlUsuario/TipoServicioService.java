package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario;

import java.util.List;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Tipo_servicio;

public interface TipoServicioService 
{
	List<Tipo_servicio> findByTodosLosServicios();
	Tipo_servicio findByIdTipo(Integer id_tipo_servicio);
	String addTipo(Tipo_servicio Tipo_servicio);
	String updateTipo(Tipo_servicio Tipo_servicio);
}
