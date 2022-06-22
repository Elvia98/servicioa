package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Mantenimiento.Elem_mantenimientoDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Actividad_mant;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Elem_mantenimiento;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Tipo_mant;

@Service
public class Elem_mantenimientoImpService implements Elem_mantenimientoService{
	@Autowired
	private Elem_mantenimientoDao elem_mantenimientoDaoMantDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Elem_mantenimiento> findByActividadMantId(Integer actividad_mant_id ){
		return elem_mantenimientoDaoMantDao.findByActividadMantId(actividad_mant_id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Elem_mantenimiento> findByIdMantenimiento_equipo(Integer mantenimiento_equipo_id ){
		return elem_mantenimientoDaoMantDao.findByIdMantenimiento_equipo(mantenimiento_equipo_id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Elem_mantenimiento> findByIdAll(){
		return elem_mantenimientoDaoMantDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Elem_mantenimiento findByIdElemMant(Integer mantenimiento_equipo_id) {
		return elem_mantenimientoDaoMantDao.findBy_IdElemMantenimiento(mantenimiento_equipo_id); 
	}

	@Override
	@Transactional
	public String addElemMant(Elem_mantenimiento elem_mantenimiento) {
		elem_mantenimientoDaoMantDao.save(elem_mantenimiento);
		return "Registro guardado";
	}

	@Override
	@Transactional
	public String updateElemMant(Elem_mantenimiento elem_mantenimiento) {
		elem_mantenimientoDaoMantDao.save(elem_mantenimiento);
		return "Registro actualizado";
	}

	@Override
	@Transactional(readOnly = true)
	public List<Map<Actividad_mant, Tipo_mant>> findListaActividadesBy_IdMantenimiento_Equipo(Integer id_mantenimiento_equipo) 
	{	
		return elem_mantenimientoDaoMantDao.findListaActividadesBy_IdMantenimiento_Equipo(id_mantenimiento_equipo);
	}
}