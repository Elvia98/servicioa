package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario;

import java.util.List;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Detalle_solicitud;

public interface DetalleSolicitudService 
{
	Detalle_solicitud ultimoDetalleBySolicitudId(Integer solicitud_id);
	List<Detalle_solicitud> findByIdSolicitud(Integer solicitud_id);	
	String appDetalleSolicitud(Detalle_solicitud detalle_solicitud);
	String updateDetalleSolicitud(Detalle_solicitud detalle_solicitud);
	Detalle_solicitud findByIdDetalleSolicitud(Integer id_detalle_solicitud);
}
