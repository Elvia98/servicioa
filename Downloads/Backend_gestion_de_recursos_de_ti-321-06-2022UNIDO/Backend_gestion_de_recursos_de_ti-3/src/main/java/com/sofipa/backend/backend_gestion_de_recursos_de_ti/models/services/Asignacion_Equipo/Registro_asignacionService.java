package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Asignacion_Equipo;

import java.io.File;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Registro_asignacion;

public interface Registro_asignacionService 
{
	List<Registro_asignacion> findByIdColaborador(Integer colaborador_id );
	List<Registro_asignacion> findByIdSolicitud(Integer solicitud_asig_equipo_id);
	List<Integer> findBySeguimiento();
	Registro_asignacion findByIdRegistro(Integer id_registro_asignacion);
	Registro_asignacion findByMasReciente();
	String addRegistro(Registro_asignacion registro_asignacion);
	String updateRegistro(Registro_asignacion registro_asignacion);
	
}
