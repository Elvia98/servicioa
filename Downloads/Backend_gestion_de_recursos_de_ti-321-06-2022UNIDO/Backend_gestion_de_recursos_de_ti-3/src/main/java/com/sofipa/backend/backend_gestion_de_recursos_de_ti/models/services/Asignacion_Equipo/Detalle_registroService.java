package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Asignacion_Equipo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Detalle_registro;

public interface Detalle_registroService 
{
	List<Detalle_registro> 	findByIdRegistro(Integer id_registro_asignacion );
	List<Detalle_registro> 	findByIdColaborador(Integer colaborador_id );
	Detalle_registro 		findByIdDetalleRegistro(Integer id_detalle_asignacion );
	Detalle_registro 		findByIdEquipo_Tipo_Status(Integer equipo_id, String tipo_activo);
	Detalle_registro 		findByIdMasReciente();
	String addDetalleRegistro(Detalle_registro detalle_registro );
	String updateDetalleRegistro(Detalle_registro detalle_registro );
	
	
	
}
