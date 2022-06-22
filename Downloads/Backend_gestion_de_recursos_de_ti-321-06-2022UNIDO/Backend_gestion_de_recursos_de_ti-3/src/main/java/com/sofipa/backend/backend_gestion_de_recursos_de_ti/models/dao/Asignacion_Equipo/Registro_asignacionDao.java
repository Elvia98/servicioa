package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Asignacion_Equipo;

import java.io.File;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Registro_asignacion;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
public interface Registro_asignacionDao extends JpaRepository<Registro_asignacion , Integer>
{
	@Query(value="SELECT * FROM `registro_asignacion` WHERE colaborador_id=:colaborador_id ORDER BY id_registro_asignacion DESC", nativeQuery=true)
	List<Registro_asignacion> findByIdColaborador( @PathVariable("colaborador_id") Integer colaborador_id );
	
	@Query(value="SELECT * FROM `registro_asignacion` WHERE solicitud_asig_equipo_id=:solicitud_asig_equipo_id", nativeQuery=true)
	List<Registro_asignacion> findByIdSolicitud( @PathVariable("solicitud_asig_equipo_id") Integer solicitud_asig_equipo_id);	
	
	@Query(value="SELECT * FROM `registro_asignacion` WHERE id_registro_asignacion=:id_registro_asignacion" , nativeQuery=true)
	Registro_asignacion findByIdRegistro( @PathVariable("id_registro_asignacion") Integer id_registro_asignacion);
	
	@Query(value="SELECT * FROM `registro_asignacion` ORDER BY id_registro_asignacion DESC LIMIT 1;" , nativeQuery=true)
	Registro_asignacion findByMasReciente();
	
	
	@Query(value="SELECT DISTINCT colaborador_id FROM `registro_asignacion` WHERE status_registro = 'REGISTRADO' OR status_registro = 'ACTUALIZACION' OR status_registro = 'CANCELACION' ORDER BY fecha_modificacion", nativeQuery=true)
	List<Integer> findBySeguimiento();

	@Query(value="SELECT archivo_responsiva FROM registro_asignacion WHERE id_registro_asignacion=:id_registro_asignacion" , nativeQuery=true)
	File findBy_ResponsivaAndidRegistro(@PathVariable("id_registro_asignacion") Integer id_registro_asignacion);
}
