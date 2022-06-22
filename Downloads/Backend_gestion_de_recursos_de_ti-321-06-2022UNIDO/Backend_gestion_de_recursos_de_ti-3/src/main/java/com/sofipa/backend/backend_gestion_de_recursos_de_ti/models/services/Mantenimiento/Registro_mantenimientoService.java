package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Registro_mantenimiento;

public interface Registro_mantenimientoService {
	
	Registro_mantenimiento findLastByIdAdministrador( Integer administrador_TI );
	Registro_mantenimiento find_Ultimo_Registro_Realizado();
	Registro_mantenimiento findByIdRegistro_mantenimiento(Integer id_registro_mantenimiento );
	
	List<Registro_mantenimiento> findByIdAdministradorStatusRealizado(Integer administrador_TI );
	List<Registro_mantenimiento> findByStatusEspera();
	List<Registro_mantenimiento> findByStatusRealizado();
	List<Registro_mantenimiento> findByStatusCancelado();
	
	String addRegistroMantenimiento(Registro_mantenimiento registro_mantenimiento );
	String updateRegistroMantenimiento(Registro_mantenimiento registro_mantenimiento );
}
