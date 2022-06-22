package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.ControlUsuario.Servicio_usuarioDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Servicio_usuario;

@Service
public class ServicioUsuarioImpService implements ServicioUsuarioService{
	
	@Autowired
	private Servicio_usuarioDao servicio_usuarioDao;

	@Override
	public List<Servicio_usuario> findAllServicioUsuario() {
		return servicio_usuarioDao.findAllServicioUsuario();
	}
	
    @Override
	public List<Servicio_usuario> findBySolicitudId(Integer solicitud_id) {
		return servicio_usuarioDao.findBySolicitudId(solicitud_id);
	}
	
	@Override
	public List<Servicio_usuario> findByColabodaradorId(Integer colaborador_id) {
		return servicio_usuarioDao.findByColaboradorId(colaborador_id);
	}
		
	@Override
	public Servicio_usuario findByIdServicioUsuario(Integer id_servicio_usuario) {
		return servicio_usuarioDao.findByIdServicioUsuario(id_servicio_usuario);
	}

	@Override
	@Transactional
	public String appServicioUsuario(Servicio_usuario servicio_usuario) {
		servicio_usuarioDao.save(servicio_usuario);
		return "Registro guardado";
	}

	@Override
	@Transactional
	public String updateServicioUsuario(Servicio_usuario servicio_usuario) {
		servicio_usuarioDao.save(servicio_usuario);
		return "Registro actualizado";
	}

	@Override
	public Servicio_usuario findByIdDetalleSolicitud(Integer detalle_solicitud_id) {
		return servicio_usuarioDao.findByIdDetalleSolicitud(detalle_solicitud_id); 
	}
	

}
