package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Mantenimiento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Tipo_mant;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
public interface Tipo_mantDao extends JpaRepository<Tipo_mant,Integer> {
	@Query(value="SELECT *"
			   + "FROM tipo_mant "
			   + "WHERE status_tipo_mant=:status_tipo_mant ", nativeQuery=true)
	List<Tipo_mant> findByStatusTipoMant(@PathVariable ("status_tipo_mant") String status_tipo_mant );
	
	@Query(value= "SELECT * FROM `tipo_mant` as tm WHERE tm.id_tipo_mant=:id_tipo_mant", nativeQuery = true)
	Tipo_mant findBy_IdTipoMant( @PathVariable("id_tipo_mant") Integer id_tipo_mant );

}
