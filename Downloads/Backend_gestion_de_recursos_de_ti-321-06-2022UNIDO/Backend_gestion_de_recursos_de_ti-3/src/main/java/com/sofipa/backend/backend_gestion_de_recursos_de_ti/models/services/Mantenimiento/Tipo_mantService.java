package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento;

import java.util.List;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Tipo_mant;

public interface Tipo_mantService {
	List<Tipo_mant> findByStatusTipoMant(String status_tipo_mant );
    List<Tipo_mant> findByIdAll();
    Tipo_mant findByIdTipoMant(Integer id_tipo_mant) ;
	String addTipo_mant(Tipo_mant tipo_mant) ;
	String updateTipoMant(Tipo_mant tipo_mant);
}
