package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.ControlUsuario.Elem_servicioDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Elem_servicio;

@Service
public class Elem_servicioImpService implements Elem_servicioService{
	@Autowired
	private Elem_servicioDao elem_servicioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Elem_servicio> findByIdSolicitudAct(Integer id_solicitud){
		return elem_servicioDao.findByIdSolicitudAct(id_solicitud);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Elem_servicio> findByIdSolicitudSusp(Integer id_solicitud){
		return elem_servicioDao.findByIdSolicitudSusp(id_solicitud);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Elem_servicio> findByColaboradorIdAndSuscursalId(Integer colaborador_id, Integer sucursal_id ){
		return elem_servicioDao.findByColaboradorIdAndSuscursalId(colaborador_id, sucursal_id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Elem_servicio> findByColaboradorId(Integer colaborador_id){
		return elem_servicioDao.findByColaboradorId(colaborador_id);
	}
		@Override
	@Transactional(readOnly = true)
	public List<Elem_servicio> findAll(){
		return elem_servicioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Elem_servicio findByIdElemServicio(Integer elem_servicio_id) {
		return elem_servicioDao.findBy_IdElemServicio(elem_servicio_id);
	}

	@Override
	@Transactional
	public String addElemServicio(Elem_servicio elem_servicio) {
		elem_servicioDao.save(elem_servicio);
		return "Registro guardado";
	}

	@Override
	@Transactional
	public String updateElemServicio(Elem_servicio elem_servicio) {
		elem_servicioDao.save(elem_servicio);
		return "Registro actualizado";
	}
}
