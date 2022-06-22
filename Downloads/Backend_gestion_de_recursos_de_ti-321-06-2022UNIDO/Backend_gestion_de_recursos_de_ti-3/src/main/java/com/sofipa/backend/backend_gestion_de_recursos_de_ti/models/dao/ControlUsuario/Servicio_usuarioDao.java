package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.ControlUsuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Servicio_usuario;

public interface Servicio_usuarioDao extends JpaRepository<Servicio_usuario,Integer> 
{
	@Query(value= "SELECT * "
			+ "FROM servicio_usuario "
			+ "WHERE detalle_solicitud_id=:detalle_solicitud_id "
			+ "ORDER BY fecha_registro DESC LIMIT 1;", nativeQuery=true)
    Servicio_usuario findByIdDetalleSolicitud(@PathVariable("detalle_solicitud_id") 		   Integer detalle_solicitud_id );
	
	@Query(value= "SELECT * FROM servicio_usuario as su " 
		       	+" WHERE su.detalle_solicitud_id=ANY ( "
		    								+"SELECT id_detalle_solicitud "
		    								+"FROM detalle_solicitud as ds " 
		    								+"WHERE ds.solicitud_id=:solicitud_id) ",nativeQuery=true)
	List<Servicio_usuario> findBySolicitudId(@PathVariable("solicitud_id") 		   Integer solicitud_id );
	
	@Query(value= "SELECT * FROM servicio_usuario as su " 
	       	+" WHERE su.detalle_solicitud_id=ANY ( "
	    								+"SELECT id_detalle_solicitud "
	    								+"FROM detalle_solicitud as ds " 
	    								+"WHERE ds.solicitud_id= ANY ( "
	    						                            		+ "SELECT id_solicitud "
								    								+ "FROM solicitud as so "
								    								+ "WHERE so.colaborador_id=:colaborador_id)) ",nativeQuery=true)
    List<Servicio_usuario> findByColaboradorId(@PathVariable("colaborador_id") 		   Integer colaborador_id );

	
	@Query(value="SELECT * FROM servicio_usuario WHERE id_servicio_usuario=:id_servicio_usuario", nativeQuery=true)
	Servicio_usuario findByIdServicioUsuario(@PathVariable("id_servicio_usuario") Integer id_servicio_usuario);
	
	
	@Query(value="SELECT * FROM servicio_usuario ORDER BY fecha_registro DESC;", nativeQuery=true)
	List<Servicio_usuario> findAllServicioUsuario();
	
}
