package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Mantenimiento;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Actividad_mant;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Elem_mantenimiento;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Tipo_mant;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
public interface Elem_mantenimientoDao extends JpaRepository<Elem_mantenimiento,Integer> {
	
	@Query(value="SELECT *"
			   + "FROM elem_mantenimiento "
			   + "WHERE actividad_mant_id=:actividad_mant_id ", nativeQuery=true)
	List<Elem_mantenimiento> findByActividadMantId(@PathVariable ("actividad_mant_id") Integer actividad_mant_id );
	
	@Query(value="SELECT * FROM elem_mantenimiento WHERE mantenimiento_equipo_id =:mantenimiento_equipo_id", nativeQuery=true)
	List<Elem_mantenimiento> findByIdMantenimiento_equipo(@PathVariable ("mantenimiento_equipo_id") Integer mantenimiento_equipo_id );
	
	@Query(value= "SELECT * FROM `elem_mantenimiento` as em WHERE em.id_elem_mantenimiento=:id_elem_mantenimiento", nativeQuery = true)
	Elem_mantenimiento findBy_IdElemMantenimiento( @PathVariable("id_elem_mantenimiento") Integer id_elem_mantenimiento );

	
	@Query(value= "SELECT am.nombre_act, am.descripcion, tm.nombre "
				+ "FROM actividad_mant as am, tipo_mant as tm, elem_mantenimiento as em, mantenimiento_equipo as me "
				+ "WHERE am.tipo_mant_id = tm.id_tipo_mant "
				+ "AND em.actividad_mant_id = am.id_actividad_mant "
				+ "AND  me.id_mantenimiento_equipo = em.mantenimiento_equipo_id "
				+ "AND me.id_mantenimiento_equipo =:id_mantenimiento_equipo", 
				nativeQuery = true)
	List<Map<Actividad_mant,Tipo_mant> > findListaActividadesBy_IdMantenimiento_Equipo( @PathVariable("id_mantenimiento_equipo") Integer id_mantenimiento_equipo );
	/*
	 
	 	SELECT am.nombre_act, am.descripcion, tm.nombre 
		FROM actividad_mant as am, tipo_mant as tm, elem_mantenimiento as em, mantenimiento_equipo as me
		WHERE am.tipo_mant_id = tm.id_tipo_mant AND em.actividad_mant_id = am.id_actividad_mant AND  me.id_mantenimiento_equipo = em.mantenimiento_equipo_id
		AND me.id_mantenimiento_equipo = 12
	 
	*/
}
