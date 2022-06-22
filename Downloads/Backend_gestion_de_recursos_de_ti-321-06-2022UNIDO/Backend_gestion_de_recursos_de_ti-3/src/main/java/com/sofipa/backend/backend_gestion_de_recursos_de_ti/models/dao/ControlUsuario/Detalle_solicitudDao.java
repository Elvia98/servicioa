package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.ControlUsuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Detalle_solicitud;

public interface Detalle_solicitudDao extends JpaRepository<Detalle_solicitud,Integer>
{
	@Query(value="SELECT * FROM `detalle_solicitud` WHERE solicitud_id=:solicitud_id ORDER BY id_detalle_solicitud DESC LIMIT 1;" , nativeQuery=true)
	Detalle_solicitud ultimoDetalleBySolicitudId(@PathVariable("solicitud_id") Integer solicitud_id);
	
	@Query(value="SELECT * FROM detalle_solicitud WHERE solicitud_id=:solicitud_id", nativeQuery=true)
	List<Detalle_solicitud> findByIdSolicitud(@PathVariable("solicitud_id") Integer solicitud_id);
	
	@Query(value="SELECT * FROM detalle_solicitud WHERE id_detalle_solicitud=:id_detalle_solicitud", nativeQuery=true)
	Detalle_solicitud findByIdDetalleSolicitud(@PathVariable("id_detalle_solicitud") Integer id_detalle_solicitud);
	
}
