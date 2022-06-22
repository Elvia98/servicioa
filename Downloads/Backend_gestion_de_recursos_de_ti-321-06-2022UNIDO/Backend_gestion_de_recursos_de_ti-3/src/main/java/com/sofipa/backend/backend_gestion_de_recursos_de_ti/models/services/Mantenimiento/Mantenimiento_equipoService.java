package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Actividad_mant;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Mantenimiento_equipo;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Registro_mantenimiento;

public interface Mantenimiento_equipoService {
	
	List<Mantenimiento_equipo> findByRegistroMantId(Integer registro_mantenimiento_id );
	List<Mantenimiento_equipo> findByRegistroMantIdSinEditSinEditar( Integer registro_mantenimiento_id );
	List<Map<Mantenimiento_equipo, Actividad_mant>> findByIdRegistroAndAndActividadesAndTipo( Integer registro_mantenimiento_id);
	
	Mantenimiento_equipo findByIdMantenimiento_equipo(Integer id_mantenimiento_equipo);
	Mantenimiento_equipo findBy_IdRegistroMantenimiento(Integer registro_mantenimiento_id );
	Mantenimiento_equipo findLastMantenimientoEquipoByIdRegistroMant(Integer registro_mantenimiento_id );
	Mantenimiento_equipo findByTipoActivoAndIdEquipo( String tipo_activo, Integer equipo_id );
	
	String addMantenimientoEquipo(Mantenimiento_equipo mantenimiento_equipo);
	String updateMantenimientoEquipo(Mantenimiento_equipo mantenimiento_equipo);
}
