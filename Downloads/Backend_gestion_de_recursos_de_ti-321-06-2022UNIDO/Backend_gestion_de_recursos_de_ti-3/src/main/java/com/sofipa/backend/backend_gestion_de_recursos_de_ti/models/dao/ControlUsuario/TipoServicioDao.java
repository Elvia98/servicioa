package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.ControlUsuario;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Tipo_servicio;

public interface TipoServicioDao extends JpaRepository<Tipo_servicio,Integer> 
{
	@Query(value="SELECT * FROM tipo_servicio as ts  WHERE ts.id_tipo_servicio=:id_tipo_servicio", nativeQuery=true)
	Tipo_servicio findByIdTipo( @PathVariable("id_tipo_servicio") Integer id_tipo_servicio);
}
