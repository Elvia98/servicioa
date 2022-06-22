package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento;

import java.util.List;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Actividad_mant;

public interface Actividad_mantService {

	List<Actividad_mant> findByTipoMantId(Integer tipo_mant_id );
    List<Actividad_mant> findByIdAll();
	Actividad_mant findByIdActividadMant(Integer id_actividad_mant) ;
	String addActividadMant(Actividad_mant actividad_mant) ;
	String updateActividadMant(Actividad_mant actividad_mant);
}
