package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.ControlUsuario.Tipo_solicitud_usuarioDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Tipo_solicitud_usuario;

@Service
public class Tipo_solicitud_usuarioImpService implements Tipo_solicitud_usuarioService{

	@Autowired
	private Tipo_solicitud_usuarioDao tipo_solicitud_usuariodao;

	@Override
	@Transactional(readOnly = true)
	public List<Tipo_solicitud_usuario> findAllTiposSolicitudes() {
		return tipo_solicitud_usuariodao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Tipo_solicitud_usuario findByIdTipoSolicitudUsuario(Integer id_tipo_solicitud_usuario) {
		return tipo_solicitud_usuariodao.findByIdTipoSolicitudUsuario(id_tipo_solicitud_usuario);
	}

	@Override
	@Transactional
	public String addTipoSolicitud(Tipo_solicitud_usuario tipo_solicitud_usuario) {
		tipo_solicitud_usuariodao.save(tipo_solicitud_usuario);
		return "Registro guardado";
	}

	@Override
	@Transactional
	public String updateTipoSolicitud(Tipo_solicitud_usuario tipo_solicitud_usuario) {
		tipo_solicitud_usuariodao.save(tipo_solicitud_usuario);
		return "Registro actualizado";
	}
	
}