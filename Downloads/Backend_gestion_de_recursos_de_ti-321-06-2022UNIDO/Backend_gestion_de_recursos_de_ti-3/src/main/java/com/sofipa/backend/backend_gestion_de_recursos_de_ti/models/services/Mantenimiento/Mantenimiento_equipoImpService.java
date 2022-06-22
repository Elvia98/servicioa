
package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Mantenimiento.Mantenimiento_equipoDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Actividad_mant;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Mantenimiento_equipo;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Registro_mantenimiento;

@Service
public class Mantenimiento_equipoImpService implements Mantenimiento_equipoService{
	
	@Autowired
	private Mantenimiento_equipoDao mantenimientoEquipoDao;
	
	/*	C	O	N	S	U	L	T	A	S	*/
	@Override
	@Transactional(readOnly = true)
	public List<Mantenimiento_equipo> findByRegistroMantId(Integer registro_mantenimiento_id )
	{
		return mantenimientoEquipoDao.findByRegistroMantId(registro_mantenimiento_id);	
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mantenimiento_equipo> findByRegistroMantIdSinEditSinEditar(Integer registro_mantenimiento_id) {
		return mantenimientoEquipoDao.findByRegistroMantIdSinEditSinEditar(registro_mantenimiento_id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Map<Mantenimiento_equipo, Actividad_mant>> findByIdRegistroAndAndActividadesAndTipo(Integer registro_mantenimiento_id) {
		return mantenimientoEquipoDao.findByIdRegistroAndAndActividadesAndTipo(registro_mantenimiento_id);
	}

	@Override
	@Transactional(readOnly = true)
	public Mantenimiento_equipo findByIdMantenimiento_equipo(Integer id_mantenimiento_equipo) {
		return mantenimientoEquipoDao.findBy_IdMantEquipo(id_mantenimiento_equipo); 
	}

	@Override
	@Transactional(readOnly = true)
	public Mantenimiento_equipo findBy_IdRegistroMantenimiento(Integer registro_mantenimiento_id) {
		return mantenimientoEquipoDao.findBy_IdRegistroMantenimiento(registro_mantenimiento_id);
	}

	@Override
	@Transactional(readOnly = true)
	public Mantenimiento_equipo findLastMantenimientoEquipoByIdRegistroMant(Integer registro_mantenimiento_id) {
		return mantenimientoEquipoDao.findLastMantenimientoEquipoByIdRegistroMant(registro_mantenimiento_id) ;
	}

	@Override
	@Transactional(readOnly = true)
	public Mantenimiento_equipo findByTipoActivoAndIdEquipo( String tipo_activo, Integer equipo_id )
	{
		return mantenimientoEquipoDao.findByTipoActivoAndIdEquipo(tipo_activo,equipo_id) ;
	}
	
	
	
	
	/*	 A	G	R	E	G	A	R	*/
	@Override
	@Transactional
	public String addMantenimientoEquipo(Mantenimiento_equipo mantenimiento_equipo) {
		mantenimientoEquipoDao.save(mantenimiento_equipo);
		return "Registro guardado";
	}

	
	
	
	
	/*	 A	C	T	U	A	L	I	Z	A	R	*/
	@Override
	@Transactional
	public String updateMantenimientoEquipo(Mantenimiento_equipo mantenimiento_equipo) {
		mantenimientoEquipoDao.save(mantenimiento_equipo);
		return "Registro actualizado";
	}

}
