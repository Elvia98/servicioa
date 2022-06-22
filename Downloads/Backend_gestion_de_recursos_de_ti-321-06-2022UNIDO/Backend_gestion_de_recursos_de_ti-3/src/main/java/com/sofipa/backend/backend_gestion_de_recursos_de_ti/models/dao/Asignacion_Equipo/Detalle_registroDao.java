package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Asignacion_Equipo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Detalle_registro;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
public interface Detalle_registroDao extends JpaRepository<Detalle_registro,Integer>
{
	@Query(value= "SELECT dr.id_detalle_asignacion, dr.archivo_responsiva_pdf, dr.equipo_id, dr.nombre_equipo, dr.observ_equipo, "
				+ "dr.status_detalle, dr.tipo_activo, dr.registro_asignacion_id, "
				+ "dr.direccion_mac, dr.direccion_ip, dr.version_office, dr.licencia_office, dr.programas_instalados, "
				+ "dr.direccion_colaborador, dr.precio, dr.precio_nombre "
				
				+ "FROM detalle_registro as dr, registro_asignacion as ra "
				+ "WHERE dr.registro_asignacion_id = ra.id_registro_asignacion "
				+ "AND ra.id_registro_asignacion =:id_registro_asignacion", nativeQuery=true)
	List<Detalle_registro> findByIdRegistro(@PathVariable ("id_registro_asignacion") Integer id_registro_asignacion );
	
	@Query(value="SELECT dr.id_detalle_asignacion, dr.nombre_equipo, dr.archivo_responsiva, dr.equipo_id, dr.observ_equipo, dr.status_detalle, dr.tipo_activo, dr.registro_asignacion_id "
				+ "dr.direccion_mac, dr.direccion_ip, dr.version_office, dr.licencia_office, dr.programas_instalados, "
				+ "dr.direccion_colaborador, dr.precio, dr.precio_nombre "
			    + "FROM detalle_registro as dr, registro_asignacion as ra "
			    + "WHERE dr.registro_asignacion_id=ra.id_registro_asignacion "
			    + "AND ra.colaborador_id=:colaborador_id", nativeQuery=true)
	List<Detalle_registro> findByIdColaborador( @PathVariable ("colaborador_id") Integer colaborador_id );
	
	@Query(value="SELECT * FROM `detalle_registro` WHERE equipo_id =:equipo_id AND tipo_activo =:tipo_activo AND status_detalle = 'ACTIVO'", nativeQuery=true)
	Detalle_registro findByIdEquipo_Tipo_Status(
													@PathVariable ("equipo_id") Integer equipo_id,
													@PathVariable ("tipo_activo") String tipo_activo
												);
	
	@Query(value="SELECT * FROM `detalle_registro` ORDER BY id_detalle_asignacion DESC LIMIT 1", nativeQuery=true)
	Detalle_registro findByIdMasReciente();
}
