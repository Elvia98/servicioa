package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Asignacion_Equipo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Solicitud_Asig_Equipo;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
public interface Solicitud_Asig_EquipoDao extends JpaRepository<Solicitud_Asig_Equipo,Integer>
{	
	/*	CONSULTAS	*/
	
	/*SOLICITANTE*/
	
	@Query(value = "SELECT * FROM solicitud_asig_equipo as s WHERE s.solicitante_id =:solicitante_id AND s.status_solicitud = 'ESPERA' ORDER BY s.fecha_solicitud DESC", nativeQuery = true)
	List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusEspera(@PathVariable("solicitante_id")   Integer solicitante_id);
	
	@Query(value = "SELECT * FROM solicitud_asig_equipo as s WHERE s.solicitante_id =:solicitante_id AND s.status_solicitud = 'CANCELADO' ORDER BY s.fecha_mod DESC", nativeQuery = true)
	List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusCancelado(@PathVariable("solicitante_id")   Integer solicitante_id);
	
	@Query(value = "SELECT * FROM solicitud_asig_equipo as s WHERE s.solicitante_id =:solicitante_id AND s.status_solicitud ='APROBADO' OR  s.status_solicitud ='Rechazado' ORDER BY s.fecha_mod DESC", nativeQuery = true)
	List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusAtendido(@PathVariable("solicitante_id")   Integer solicitante_id);
	
	

	/*	ADMINISTRADOR	*/
	@Query(value = "SELECT * FROM solicitud_asig_equipo as s WHERE s.status_solicitud = 'ESPERA' ORDER BY s.fecha_solicitud DESC", nativeQuery = true)
	List<Solicitud_Asig_Equipo> findBy_StatusEspera();
	
	@Query(value = "SELECT * FROM solicitud_asig_equipo as s WHERE s.status_solicitud = 'CANCELADO' ORDER BY s.fecha_mod DESC", nativeQuery = true)
	List<Solicitud_Asig_Equipo> findBy_StatusCancelado();
	
	@Query(value = "SELECT * FROM solicitud_asig_equipo as s WHERE s.status_solicitud ='APROBADO' OR  s.status_solicitud ='RECHAZADO' ORDER BY s.fecha_mod DESC", nativeQuery = true)
	List<Solicitud_Asig_Equipo> findBy_StatusAtendido();
	

	
	/*Consultar una sola solicitud*/
	@Query(value= "SELECT * FROM `solicitud_asig_equipo` as s WHERE s.id_solicitud_asig_equipo=:id_solicitud_asig_equipo", nativeQuery = true)
	Solicitud_Asig_Equipo findBy_IdSolicitud( @PathVariable("id_solicitud_asig_equipo") Integer id_solicitud_asig_equipo );
	

	

	/* VALIDACÍON (SI EL COLABORADOR NO TIENE MÁS SOLICITUES DE UN TIPO DE EQUIPO EN ESPERA)	*/
	@Query(value= "SELECT * "
				+ "FROM `solicitud_asig_equipo` "
				+ "WHERE status_solicitud = 'Espera' "
				+ "AND colaborador_id =:colaborador_id "
				+ "AND tipo_equipo =:tipo_equipo "
				+ "ORDER BY id_solicitud_asig_equipo DESC LIMIT 1", nativeQuery = true)
	Solicitud_Asig_Equipo findBy_Status_And_IdColaborador_And_TipoEquipo(	@PathVariable("colaborador_id") Integer colaborador_id	, 
																			@PathVariable("tipo_equipo") 	String tipo_equipo		);
	
	
	/*	ÚLTIMA SOLICITUD REALIZADA */
	@Query(value= "SELECT * FROM `solicitud_asig_equipo` ORDER BY id_solicitud_asig_equipo DESC LIMIT 1", nativeQuery = true)
	Solicitud_Asig_Equipo findBy_LastIdSolicitud();
	
	
	
	
	
	
	
	
	
	
	
	
	/* Lista de Solicitudes x Solicitante Status en Espera y Fechas */
	@Query(value = "SELECT * FROM solicitud_asig_equipo WHERE solicitante_id =:solicitante_id AND status_solicitud ='ESPERA' AND fecha_solicitud BETWEEN :fecha1 AND :fecha2 ORDER BY fecha_solicitud DESC", nativeQuery = true)
	List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusEspera_Fechas(@PathVariable("solicitante_id") Integer solicitante_id, 
		   															 	 @PathVariable("fecha1") Date fecha1,
		   															 	 @PathVariable("fecha2") Date fecha2);

	/* Lista de Solicitudes x Solicitante Status en Cancelado y Fechas */
	@Query(value = "SELECT * FROM solicitud_asig_equipo WHERE solicitante_id =:solicitante_id AND status_solicitud ='CANCELADO' AND fecha_solicitud BETWEEN :fecha1 AND :fecha2 ORDER BY fecha_mod DESC", nativeQuery = true)
	List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusCancelado_Fechas(@PathVariable("solicitante_id") Integer solicitante_id, 
		   															 	    @PathVariable("fecha1") Date fecha1,
		   															 	    @PathVariable("fecha2") Date fecha2);
	
	/* Lista de Solicitudes x Solicitante Status en Atendido y Fechas */
	@Query(value = "SELECT * FROM solicitud_asig_equipo WHERE solicitante_id =:solicitante_id AND status_solicitud ='APROBADO' OR  status_solicitud ='RECHAZADO' AND fecha_solicitud BETWEEN :fecha1 AND :fecha2 ORDER BY fecha_mod DESC", nativeQuery = true)
	List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusAtendido_Fechas(@PathVariable("solicitante_id") Integer solicitante_id, 
		   															 	   @PathVariable("fecha1") Date fecha1,
		   															 	   @PathVariable("fecha2") Date fecha2);
	/* Lista de Solicitudes x Status en Espera y Fechas */
	@Query(value = "SELECT * FROM solicitud_asig_equipo WHERE status_solicitud ='ESPERA' AND fecha_solicitud BETWEEN :fecha1 AND :fecha2 ORDER BY fecha_solicitud DESC", nativeQuery = true)
	List<Solicitud_Asig_Equipo> findBy_StatusEspera_Fechas(@PathVariable("fecha1") Date fecha1,
		   												   @PathVariable("fecha2") Date fecha2);

	/* Lista de Solicitudes x Status Cancelado y Fechas */
	@Query(value = "SELECT * FROM solicitud_asig_equipo WHERE status_solicitud ='CANCELADO' AND fecha_solicitud BETWEEN :fecha1 AND :fecha2 ORDER BY fecha_mod DESC", nativeQuery = true)
	List<Solicitud_Asig_Equipo> findBy_StatusCancelado_Fechas(@PathVariable("fecha1") Date fecha1,
		   													  @PathVariable("fecha2") Date fecha2);
	
	/* Lista de Solicitudes x Status Atendido y Fechas */
	@Query(value = "SELECT * FROM solicitud_asig_equipo WHERE status_solicitud ='APROBADO' OR  status_solicitud ='RECHAZADO' AND fecha_solicitud BETWEEN :fecha1 AND :fecha2 ORDER BY fecha_mod DESC", nativeQuery = true)
	List<Solicitud_Asig_Equipo> findBy_StatusAtendido_Fechas(@PathVariable("fecha1") Date fecha1,
		   													 @PathVariable("fecha2") Date fecha2);
	
}

