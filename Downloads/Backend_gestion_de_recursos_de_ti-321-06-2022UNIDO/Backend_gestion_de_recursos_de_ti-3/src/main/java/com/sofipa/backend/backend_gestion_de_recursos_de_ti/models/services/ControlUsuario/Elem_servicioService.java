package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario;

import java.util.List;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Elem_servicio;

public interface Elem_servicioService {
	
	List<Elem_servicio> findByIdSolicitudAct(Integer id_solicitud);
	List<Elem_servicio> findByIdSolicitudSusp(Integer id_solicitud);
	List<Elem_servicio> findByColaboradorIdAndSuscursalId(Integer colaborador_id, Integer sucursal_id);
	List<Elem_servicio> findByColaboradorId(Integer colaborador_id);
	List<Elem_servicio> findAll();
	Elem_servicio findByIdElemServicio(Integer elem_servicio_id);
    String addElemServicio(Elem_servicio elem_servicio);
    String updateElemServicio(Elem_servicio elem_servicio);
}
