package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Asignacion_Equipo;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Asignacion_Equipo.Registro_asignacionDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Registro_asignacion;

@Service
public class Registro_asignacionImpService implements Registro_asignacionService{

	@Autowired
	private Registro_asignacionDao registro_asignacionDao;

	
	@Override
	@Transactional(readOnly = true)
	public List<Registro_asignacion> findByIdColaborador(Integer colaborador_id) 
	{
		return registro_asignacionDao.findByIdColaborador(colaborador_id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Registro_asignacion> findByIdSolicitud(Integer solicitud_asig_equipo_id) 
	{
		return registro_asignacionDao.findByIdSolicitud(solicitud_asig_equipo_id);
	}

	@Override
	@Transactional(readOnly = true)
	public Registro_asignacion findByIdRegistro(Integer id_registro_asignacion) 
	{
		return registro_asignacionDao.findByIdRegistro(id_registro_asignacion);
	}

	@Override
	@Transactional
	public String addRegistro(Registro_asignacion registro_asignacion) {
		registro_asignacionDao.save(registro_asignacion);
		return "Registro guardado";
	}

	@Override
	@Transactional
	public String updateRegistro(Registro_asignacion registro_asignacion) {
		registro_asignacionDao.save(registro_asignacion);
		return "Registro actualizado";
	}

	@Override
	@Transactional(readOnly = true)
	public Registro_asignacion findByMasReciente() 
	{
		return registro_asignacionDao.findByMasReciente();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Integer> findBySeguimiento() 
	{
		return registro_asignacionDao.findBySeguimiento();
	}

}
