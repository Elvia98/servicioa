package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Mantenimiento.Actividad_mantDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Actividad_mant;

@Service
public class Actividad_mantImpService  implements  Actividad_mantService{
	@Autowired
	private Actividad_mantDao actividadMantDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Actividad_mant> findByTipoMantId(Integer id_tipo_mant){
		return actividadMantDao.findByTipoMantId(id_tipo_mant);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Actividad_mant> findByIdAll(){
		return actividadMantDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Actividad_mant findByIdActividadMant(Integer id_actividad_mant) {
		return actividadMantDao.findBy_IdActividadMant(id_actividad_mant); 
	}

	@Override
	@Transactional
	public String addActividadMant(Actividad_mant actividad_mant) {
		actividadMantDao.save(actividad_mant);
		return "Registro guardado";
	}

	@Override
	@Transactional
	public String updateActividadMant(Actividad_mant actividad_mant) {
		actividadMantDao.save(actividad_mant);
		return "Registro actualizado";
	}
}