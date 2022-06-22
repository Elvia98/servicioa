package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Mantenimiento;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Registro_mantenimiento;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
public interface Registro_mantenimientoDao extends JpaRepository<Registro_mantenimiento,Integer>{

	/* CONSULTAS PARA LA VISTA CONTROL DE MANTENIMIENTOS*/
	
	@Query(value="SELECT * FROM registro_mantenimiento "
			    +"WHERE status_registro = 'ESPERA' "
			    +"ORDER BY fecha_creacion DESC", nativeQuery=true)
	List<Registro_mantenimiento> findByStatusEspera();
	
	@Query(value="SELECT * FROM registro_mantenimiento "
		    +"WHERE status_registro = 'REALIZADO' "
		    +"ORDER BY fecha_mod DESC", nativeQuery=true)
	List<Registro_mantenimiento> findByStatusRealizado();
	
	@Query(value="SELECT * FROM registro_mantenimiento "
		    +"WHERE status_registro = 'CANCELADO' "
		    +"ORDER BY fecha_mod DESC", nativeQuery=true)
	List<Registro_mantenimiento> findByStatusCancelado();
	
	@Query(value= "SELECT * FROM `registro_mantenimiento` as rm WHERE rm.id_registro_mantenimiento=:id_registro_mantenimiento", nativeQuery = true)
	Registro_mantenimiento findBy_IdRegistroMant( @PathVariable("id_registro_mantenimiento") Integer id_registro_mantenimiento );

	@Query(value="SELECT * FROM registro_mantenimiento WHERE id_empleado_registra=:administrador_TI AND status_registro = 'REALIZADO' ORDER BY fecha_creacion DESC", nativeQuery=true)
	List<Registro_mantenimiento> findByIdAdministradorStatusRealizado(@PathVariable ("administrador_TI") Integer administrador_TI );
	
	@Query(value= "SELECT* "
			+ "FROM registro_mantenimiento "
			+ "WHERE registro_mantenimiento.status_registro = 'REALIZADO' "
			+ "ORDER BY registro_mantenimiento.id_registro_mantenimiento "
			+ "DESC "
			+ "LIMIT 1", nativeQuery=true)
	Registro_mantenimiento find_Ultimo_Registro_Realizado();
	
	@Query(value="SELECT *"
			   + "FROM registro_mantenimiento "
			   + "WHERE id_empleado_registra=:administrador_TI ORDER BY fecha_creacion DESC LIMIT 1", nativeQuery=true)
	Registro_mantenimiento findLastByIdAdministrador(@PathVariable ("administrador_TI") Integer administrador_TI );
	
}
