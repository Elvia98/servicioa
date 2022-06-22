package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Asignacion_Equipo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Solicitud_Asig_Equipo;

public interface Solicitud_Asig_EquipoService 
{
		
  	/*	CONSULTAS	*/	
	
	/*	SOLICITANTE	*/
	List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusEspera( Integer solicitante_id);
	List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusCancelado( Integer solicitante_id);
	List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusAtendido( Integer solicitante_id);
	
	/*	ADMINISTRADOR	*/
	List<Solicitud_Asig_Equipo> findBy_StatusEspera();	
	List<Solicitud_Asig_Equipo> findBy_StatusCancelado();
	List<Solicitud_Asig_Equipo> findBy_StatusAtendido();
	
	/* SOLICITUD */
	Solicitud_Asig_Equipo findBy_IdSolicitud( Integer id_solicitud_asig_equipo );
	Solicitud_Asig_Equipo findBy_Status_And_IdColaborador_And_TipoEquipo(Integer colaborador_id	, String tipo_equipo);
	Solicitud_Asig_Equipo findBy_LastIdSolicitud();	
	
	
	
	
	
	/*	AGREGAR	*/
	String addRegistro(Solicitud_Asig_Equipo solicitud_Asig_Equipo);
	
	
	
	
	/*	ACTUALIZAR	*/
	String updateRegistro(Solicitud_Asig_Equipo solicitud_Asig_Equipo);
	
}
