package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.ControlUsuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Solicitud;

public interface SolicitudDao extends JpaRepository<Solicitud,Integer>
{	
	@Query(value= "SELECT * "
			+ "FROM solicitud "
			+ "ORDER BY fecha_solicitud DESC;", nativeQuery=true)
    List<Solicitud> findAllSolicitudes();
	
	@Query(value= "SELECT * "
			+ "FROM solicitud "
			+ "WHERE solicitante_id=:solicitante_id "
			+ "ORDER BY fecha_solicitud DESC;", nativeQuery=true)
    List<Solicitud> findByIdSolicitante(@PathVariable("solicitante_id") 		   Integer solicitante_id );

	@Query(value= "SELECT * "
			+ "FROM solicitud "
			+ "WHERE colaborador_id=:colaborador_id "
			+ "ORDER BY fecha_solicitud DESC;", nativeQuery=true)
    List<Solicitud> findByIdColaborador(@PathVariable("colaborador_id") 		   Integer colaborador_id );
	
	@Query(value="SELECT * FROM `solicitud` WHERE solicitante_id=:solicitante_id AND tipo_solicitud_usuario_id=:tipo_solicitud_usuario_id AND status_solicitud='Espera' ORDER BY fecha_solicitud DESC LIMIT 1;" , nativeQuery=true)
	Solicitud ultimaSoliByIdSolicitanteAndTipoAndStatusEspera(@PathVariable("solicitante_id") 		   Integer solicitante_id, 
                                                        @PathVariable("tipo_solicitud_usuario_id") Integer tipo_solicitud_usuario_id);
	
	
	@Query(value= "SELECT * "
			+ "FROM solicitud WHERE id_solicitud=:id_solicitud ", nativeQuery=true)
	Solicitud findByIdSolicitud(@PathVariable("id_solicitud") Integer id_solicitud);
	
	
	
	}
