package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Mantenimiento;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Actividad_mant;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Mantenimiento_equipo;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
public interface Mantenimiento_equipoDao extends JpaRepository<Mantenimiento_equipo,Integer>{

	@Query(value="SELECT * FROM mantenimiento_equipo WHERE registro_mantenimiento_id=:registro_mantenimiento_id AND observ_equipo IS NULL ", nativeQuery=true)
	List<Mantenimiento_equipo> findByRegistroMantIdSinEditar(@PathVariable ("registro_mantenimiento_id") Integer registro_mantenimiento_id );
	
	@Query(value="SELECT * FROM mantenimiento_equipo WHERE registro_mantenimiento_id=:registro_mantenimiento_id ORDER BY id_mantenimiento_equipo DESC LIMIT 1", nativeQuery=true)
	Mantenimiento_equipo findLastMantenimientoEquipoByIdRegistroMant(@PathVariable ("registro_mantenimiento_id") Integer registro_mantenimiento_id );
	
	
	@Query(value="SELECT * FROM mantenimiento_equipo WHERE registro_mantenimiento_id=:registro_mantenimiento_id ", nativeQuery=true)
	List<Mantenimiento_equipo> findByRegistroMantId(@PathVariable ("registro_mantenimiento_id") Integer registro_mantenimiento_id );
	
	
	@Query(value="SELECT * FROM mantenimiento_equipo WHERE registro_mantenimiento_id=:registro_mantenimiento_id ", nativeQuery=true)
	List<Mantenimiento_equipo> findByRegistroMantIdSinEdit(@PathVariable ("registro_mantenimiento_id") Integer registro_mantenimiento_id );
	
	@Query(value="SELECT * FROM mantenimiento_equipo WHERE registro_mantenimiento_id=:registro_mantenimiento_id AND comentarios_usuario IS NULL AND observ_equipo IS NULL", nativeQuery=true)
	List<Mantenimiento_equipo> findByRegistroMantIdSinEditSinEditar(@PathVariable ("registro_mantenimiento_id") Integer registro_mantenimiento_id );
	
	@Query(value= "SELECT * FROM `mantenimiento_equipo` as rm WHERE rm.id_mantenimiento_equipo=:id_mantenimiento_equipo", nativeQuery = true)
	Mantenimiento_equipo findBy_IdMantEquipo( @PathVariable("id_mantenimiento_equipo") Integer id_mantenimiento_equipo );
	
	
	@Query(value= "SELECT * FROM `mantenimiento_equipo` as rm WHERE rm.registro_mantenimiento_id=:registro_mantenimiento_id LIMIT 1", nativeQuery = true)
	Mantenimiento_equipo findBy_IdRegistroMantenimiento( @PathVariable("registro_mantenimiento_id") Integer registro_mantenimiento_id );
	
	@Query(value= "SELECT * FROM `mantenimiento_equipo` WHERE tipo_activo=:tipo_activo AND equipo_id=:equipo_id", nativeQuery = true)
	Mantenimiento_equipo findByTipoActivoAndIdEquipo( @PathVariable("tipo_activo") String tipo_activo, @PathVariable("equipo_id")   Integer equipo_id);

	
	@Query(value= "SELECT DISTINCT me.id_mantenimiento_equipo, me.comentarios_usuario, me.equipo_id, me.observ_equipo, me.problema_localizado, me.tipo_activo, ME.nombre_equipo, tm.nombre, am.nombre_act "
				+ "FROM mantenimiento_equipo as me, elem_mantenimiento as em, actividad_mant as am, tipo_mant as tm, registro_mantenimiento as rm "
				+ "WHERE me.id_mantenimiento_equipo = em.mantenimiento_equipo_id AND em.actividad_mant_id = am.id_actividad_mant AND am.tipo_mant_id = tm.id_tipo_mant AND me.registro_mantenimiento_id = rm.id_registro_mantenimiento AND rm.id_registro_mantenimiento =:registro_mantenimiento_id", nativeQuery = true)
	List<Map<Mantenimiento_equipo, Actividad_mant>> findByIdRegistroAndAndActividadesAndTipo( @PathVariable("registro_mantenimiento_id") Integer registro_mantenimiento_id);

}

