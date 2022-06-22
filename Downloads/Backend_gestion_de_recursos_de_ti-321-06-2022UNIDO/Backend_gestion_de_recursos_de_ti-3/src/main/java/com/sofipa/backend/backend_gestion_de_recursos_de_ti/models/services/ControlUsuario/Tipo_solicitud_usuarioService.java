package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario;

import java.util.List;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Tipo_solicitud_usuario;

public interface Tipo_solicitud_usuarioService 
{
	List<Tipo_solicitud_usuario> findAllTiposSolicitudes();
	Tipo_solicitud_usuario findByIdTipoSolicitudUsuario(Integer id_tipo_solicitud_usuario);
	String addTipoSolicitud(Tipo_solicitud_usuario tipo_solicitud_usuario);
	String updateTipoSolicitud(Tipo_solicitud_usuario tipo_solicitud_usuario);
}
