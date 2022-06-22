package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Mantenimiento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Actividad_mant;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
public interface Actividad_mantDao extends JpaRepository<Actividad_mant,Integer> {
	
	@Query(value="SELECT *"
			   + "FROM actividad_mant "
			   + "WHERE tipo_mant_id=:tipo_mant_id ", nativeQuery=true)
	List<Actividad_mant> findByTipoMantId(@PathVariable ("tipo_mant_id") Integer tipo_mant_id );
	
	@Query(value= "SELECT * FROM `actividad_mant` as am WHERE am.id_actividad_mant=:id_actividad_mant", nativeQuery = true)
	Actividad_mant findBy_IdActividadMant( @PathVariable("id_actividad_mant") Integer id_actividad_mant );

}
