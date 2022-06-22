package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Asignacion_Equipo;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Asignacion_Equipo.Solicitud_Asig_EquipoDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Registro_asignacion;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Solicitud_Asig_Equipo;

@Service
public class Solicitud_Asig_EquipoImpService implements Solicitud_Asig_EquipoService {

	@Autowired
	private Solicitud_Asig_EquipoDao solicitud_Asig_EquipoDao;

	
	
	/*	CONSULTAS	*/
	
	/*	SOLICITANTE	*/
	@Override
	@Transactional(readOnly = true)
	public List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusEspera(Integer solicitante_id) 
	{
		return solicitud_Asig_EquipoDao.findBy_IdSolicitante_StatusEspera(solicitante_id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusCancelado(Integer solicitante_id) 
	{
		return solicitud_Asig_EquipoDao.findBy_IdSolicitante_StatusCancelado(solicitante_id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusAtendido(Integer solicitante_id) 
	{
		return solicitud_Asig_EquipoDao.findBy_IdSolicitante_StatusAtendido(solicitante_id);
	}
	
	/*	ADMINSITRADOR	*/
	@Override
	@Transactional(readOnly = true)
	public List<Solicitud_Asig_Equipo> findBy_StatusEspera() 
	{
		return solicitud_Asig_EquipoDao.findBy_StatusEspera();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Solicitud_Asig_Equipo> findBy_StatusCancelado() 
	{
		return solicitud_Asig_EquipoDao.findBy_StatusCancelado();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Solicitud_Asig_Equipo> findBy_StatusAtendido() 
	{
		return solicitud_Asig_EquipoDao.findBy_StatusAtendido();
	}

	/*	SOLICITUD	*/
	@Override
	@Transactional(readOnly = true)
	public Solicitud_Asig_Equipo findBy_IdSolicitud(Integer id_solicitud_asig_equipo) 
	{
		return solicitud_Asig_EquipoDao.findBy_IdSolicitud(id_solicitud_asig_equipo) ;
	}

	@Override
	@Transactional(readOnly = true)
	public Solicitud_Asig_Equipo findBy_Status_And_IdColaborador_And_TipoEquipo(Integer colaborador_id, String tipo_equipo) 
	{
		return solicitud_Asig_EquipoDao.findBy_Status_And_IdColaborador_And_TipoEquipo(colaborador_id, tipo_equipo);
	}

	@Override
	@Transactional(readOnly = true)
	public Solicitud_Asig_Equipo findBy_LastIdSolicitud() 
	{
		return solicitud_Asig_EquipoDao.findBy_LastIdSolicitud();
	}
	
	
	
	
	/*	AGREGAR	*/
	@Override
	@Transactional
	public String addRegistro(Solicitud_Asig_Equipo solicitud_Asig_Equipo) 
	{
		solicitud_Asig_EquipoDao.save(solicitud_Asig_Equipo);
		return "Registro guardado";
	}

	
	
	
	/*	ACTUALIZAR	*/
	@Override
	@Transactional
	public String updateRegistro(Solicitud_Asig_Equipo solicitud_Asig_Equipo) 
	{
		solicitud_Asig_EquipoDao.save(solicitud_Asig_Equipo);
		return "Registro actualizado";
	}
}
