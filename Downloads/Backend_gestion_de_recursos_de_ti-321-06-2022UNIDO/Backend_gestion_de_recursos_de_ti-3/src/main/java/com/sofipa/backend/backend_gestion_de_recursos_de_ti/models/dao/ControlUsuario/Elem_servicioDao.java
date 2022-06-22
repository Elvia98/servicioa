package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.ControlUsuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Elem_servicio;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
public interface Elem_servicioDao extends JpaRepository<Elem_servicio,Integer>{
	@Query(value= "SELECT * FROM elem_servicio as es " 
	       	+" WHERE es.detalle_solicitud_act_id=ANY ( "
	    								+"SELECT id_detalle_solicitud "
	    								+"FROM detalle_solicitud as ds " 
	    								+"WHERE ds.solicitud_id=:id_solicitud); ",nativeQuery=true)
   List<Elem_servicio> findByIdSolicitudAct(@PathVariable("id_solicitud") Integer id_solicitud);
   
   @Query(value= "SELECT * FROM elem_servicio as es " 
	       	+" WHERE es.detalle_solicitud_susp_id=ANY ( "
	    								+"SELECT id_detalle_solicitud "
	    								+"FROM detalle_solicitud as ds " 
	    								+"WHERE ds.solicitud_id=:id_solicitud); ",nativeQuery=true)
  List<Elem_servicio> findByIdSolicitudSusp(@PathVariable("id_solicitud") Integer id_solicitud);
	
	@Query(value= "SELECT * FROM elem_servicio as es " 
	       	+" WHERE es.detalle_solicitud_act_id=ANY ( "
	    								+"SELECT id_detalle_solicitud "
	    								+"FROM detalle_solicitud as ds " 
	    								+"WHERE ds.solicitud_id= ANY ( "
	    						                            		+ "SELECT id_solicitud "
								    								+ "FROM solicitud as so "
								    								+ "WHERE so.colaborador_id=:colaborador_id "
								    								+ "AND so.sucursal_id=:sucursal_id)); ",nativeQuery=true)
   List<Elem_servicio> findByColaboradorIdAndSuscursalId(@PathVariable("colaborador_id") Integer colaborador_id, @PathVariable("sucursal_id") Integer sucursal_id);

   @Query(value= "SELECT * FROM elem_servicio as es " 
	       	+" WHERE es.detalle_solicitud_act_id=ANY ( "
	    								+"SELECT id_detalle_solicitud "
	    								+"FROM detalle_solicitud as ds " 
	    								+"WHERE ds.solicitud_id= ANY ( "
	    						                            		+ "SELECT id_solicitud "
								    								+ "FROM solicitud as so "
								    								+ "WHERE so.colaborador_id=:colaborador_id "
								    								+ ")); ",nativeQuery=true)
   List<Elem_servicio> findByColaboradorId(@PathVariable("colaborador_id") Integer colaborador_id);


	
	@Query(value= "SELECT * FROM `elem_servicio`  WHERE id_elem_servicio=:id_elem_servicio", nativeQuery = true)
	Elem_servicio findBy_IdElemServicio( @PathVariable("id_elem_servicio") Integer id_elem_servicio );

}
