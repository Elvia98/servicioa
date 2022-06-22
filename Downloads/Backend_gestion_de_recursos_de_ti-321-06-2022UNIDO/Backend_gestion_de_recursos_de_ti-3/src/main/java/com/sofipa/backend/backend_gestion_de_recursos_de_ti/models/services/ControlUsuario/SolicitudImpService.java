package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.ControlUsuario.SolicitudDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Solicitud;

@Service
public class SolicitudImpService implements SolicitudService{

	@Autowired
	private SolicitudDao solicitudDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Solicitud> findAllSolicitudes() {
		return solicitudDao.findAllSolicitudes();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Solicitud> findByIdSolicitante(Integer solicitante_id) {
		return solicitudDao.findByIdSolicitante(solicitante_id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Solicitud> findByIdColaborador(Integer colaborador_id) {
		return solicitudDao.findByIdColaborador(colaborador_id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Solicitud ultimaSoliByIdSolicitanteAndTipoAndStatusEspera(Integer solicitante_id, Integer tipo_solicitud_usuario_id) {
		return solicitudDao.ultimaSoliByIdSolicitanteAndTipoAndStatusEspera(solicitante_id, tipo_solicitud_usuario_id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Solicitud findByIdSolicitud(Integer id_solicitud) {
		return solicitudDao.findByIdSolicitud(id_solicitud);
	}

	@Override
	@Transactional
	public String addSolicitud(Solicitud solicitud ) {
		solicitudDao.save(solicitud);
		return "Registro guardado";
	}

	@Override
	@Transactional
	public String updateSolicitud(Solicitud solicitud ) {
		solicitudDao.save(solicitud);
		return "Registro actualizado";
	}
	
}
