package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario;

import java.util.List;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Servicio_usuario;

public interface ServicioUsuarioService {
	
	List<Servicio_usuario> findAllServicioUsuario();
	List<Servicio_usuario> findBySolicitudId(Integer solicitud_id);
	List<Servicio_usuario> findByColabodaradorId(Integer colaborador_id);
	Servicio_usuario findByIdDetalleSolicitud(Integer detalle_solicitud_id);
	Servicio_usuario findByIdServicioUsuario(Integer id_servicio_usuario);
	String appServicioUsuario(Servicio_usuario servicio_usuario);
	String updateServicioUsuario(Servicio_usuario servicio_usuario);
}
