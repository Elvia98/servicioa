package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Mantenimiento.Tipo_mantDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Tipo_mant;

@Service
public class Tipo_mantImpService implements  Tipo_mantService{
	@Autowired
	private Tipo_mantDao tipoMantDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Tipo_mant> findByStatusTipoMant(String status_tipo_mant ){
		return tipoMantDao.findByStatusTipoMant(status_tipo_mant);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Tipo_mant> findByIdAll(){
		return tipoMantDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Tipo_mant findByIdTipoMant(Integer id_tipo_mant) {
		return tipoMantDao.findBy_IdTipoMant(id_tipo_mant);
	}

	@Override
	@Transactional
	public String addTipo_mant(Tipo_mant tipo_mant) {
		tipoMantDao.save(tipo_mant);
		return "Registro guardado";
	}

	@Override
	@Transactional
	public String updateTipoMant(Tipo_mant tipo_mant) {
		tipoMantDao.save(tipo_mant);
		return "Registro actualizado";
	}

}
