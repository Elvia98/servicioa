package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Asignacion_Equipo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Asignacion_Equipo.Detalle_registroDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Detalle_registro;

@Service
public class Detalle_registroImpService implements Detalle_registroService{

	@Autowired
	private Detalle_registroDao detalle_registroDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Detalle_registro> findByIdRegistro(Integer id_registro_asignacion) {
		return detalle_registroDao.findByIdRegistro(id_registro_asignacion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Detalle_registro> findByIdColaborador(Integer colaborador_id) {
		return detalle_registroDao.findByIdColaborador(colaborador_id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Detalle_registro findByIdDetalleRegistro(Integer id_detalle_asignacion ) 
	{
		return detalle_registroDao.getById(id_detalle_asignacion);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Detalle_registro findByIdEquipo_Tipo_Status(Integer equipo_id, String tipo_activo) 
	{
		return detalle_registroDao.findByIdEquipo_Tipo_Status(equipo_id, tipo_activo);
	}
	
	

	@Override
	@Transactional
	public String addDetalleRegistro(Detalle_registro detalle_registro) {
		detalle_registroDao.save(detalle_registro);
		return "Registro guardado";
	}

	@Override
	@Transactional
	public String updateDetalleRegistro(Detalle_registro detalle_registro) {
		detalle_registroDao.save(detalle_registro);
		return "Registro actualizado";
	}

	@Override
	@Transactional(readOnly = true)
	public Detalle_registro findByIdMasReciente() 
	{	
		return detalle_registroDao.findByIdMasReciente();
	}

	


}
