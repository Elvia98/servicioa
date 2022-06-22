package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.ControlUsuario.Detalle_solicitudDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Detalle_solicitud;

@Service
public class DetalleSolicitudImpService implements DetalleSolicitudService
{

	@Autowired
	private Detalle_solicitudDao detalle_solicitudDao;
	
	@Override
	@Transactional(readOnly = true)
	public Detalle_solicitud ultimoDetalleBySolicitudId(Integer solicitud_id) {
		return detalle_solicitudDao.ultimoDetalleBySolicitudId(solicitud_id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Detalle_solicitud> findByIdSolicitud(Integer solicitud_id) 
	{
		return detalle_solicitudDao.findByIdSolicitud(solicitud_id);
	}

	@Override
	@Transactional
	public String appDetalleSolicitud(Detalle_solicitud detalle_solicitud) {
		detalle_solicitudDao.save(detalle_solicitud);
		return "Registro guardado";
	}

	@Override
	@Transactional
	public String updateDetalleSolicitud(Detalle_solicitud detalle_solicitud) 
	{
		detalle_solicitudDao.save(detalle_solicitud);
		return "Registro actualizado";
	}

	@Override
	@Transactional(readOnly = true)
	public Detalle_solicitud findByIdDetalleSolicitud(Integer id_detalle_solicitud) {
		return detalle_solicitudDao.findByIdDetalleSolicitud(id_detalle_solicitud);
	}

}
