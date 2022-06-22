package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Actividad_mant;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Elem_mantenimiento;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Tipo_mant;

public interface Elem_mantenimientoService {
	List<Elem_mantenimiento> findByActividadMantId(Integer actividad_mant_id );
	List<Elem_mantenimiento> findByIdMantenimiento_equipo(Integer mantenimiento_equipo_id );
	List<Elem_mantenimiento> findByIdAll();
	Elem_mantenimiento findByIdElemMant(Integer mantenimiento_equipo_id) ;
    String addElemMant(Elem_mantenimiento elem_mantenimiento) ;
    String updateElemMant(Elem_mantenimiento elem_mantenimiento);
    
    List<Map<Actividad_mant,Tipo_mant>> findListaActividadesBy_IdMantenimiento_Equipo(Integer id_mantenimiento_equipo );
}
