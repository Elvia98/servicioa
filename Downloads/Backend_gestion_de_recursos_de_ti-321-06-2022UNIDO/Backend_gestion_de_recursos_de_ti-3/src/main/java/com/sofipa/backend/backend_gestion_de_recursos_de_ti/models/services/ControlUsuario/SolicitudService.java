package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario;

import java.util.List;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Solicitud;

public interface SolicitudService {

	List<Solicitud> findAllSolicitudes();
	
	List<Solicitud> findByIdSolicitante(Integer solicitante_id);
	
	List<Solicitud> findByIdColaborador(Integer colaborador_id);
	
	Solicitud ultimaSoliByIdSolicitanteAndTipoAndStatusEspera(Integer solicitante_id, Integer tipo_solicitud_usuario_id);

    Solicitud findByIdSolicitud(Integer id_solicitud);
	
	String addSolicitud(Solicitud solicitud );
	
	String updateSolicitud(Solicitud solicitud );
	
	
}
