package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.ControlUsuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Tipo_solicitud_usuario;


public interface Tipo_solicitud_usuarioDao extends JpaRepository <Tipo_solicitud_usuario,Integer>
{
	@Query(value="SELECT * FROM tipo_solicitud_usuario as tsu WHERE tsu.id_tipo_solicitud_usuario =:id_tipo_solicitud_usuario", nativeQuery = true)
	Tipo_solicitud_usuario findByIdTipoSolicitudUsuario( @PathVariable("id_tipo_solicitud_usuario") Integer id_tipo_solicitud_usuario);
}