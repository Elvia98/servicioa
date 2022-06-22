package com.sofipa.backend.backend_gestion_de_recursos_de_ti.controllers.Mantenimiento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Solicitud_Asig_Equipo;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Registro_mantenimiento;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento.Registro_mantenimientoImpService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/Mantenimiento")
@RestController
public class Registro_mantenimientoController {
	
	
	@Autowired
	private Registro_mantenimientoImpService registro_mantenimientoImpService;
	
	
	/* CONSULTAS */
		
	@GetMapping("/RegistroMantenimiento/UltimoRegistroRealizado")
	public Registro_mantenimiento find_Ultimo_Registro_Realizado() 
	{
		return registro_mantenimientoImpService.find_Ultimo_Registro_Realizado();
	}
	
	@GetMapping("/RegistroMantenimiento/RegistrosEspera")
	public List<Registro_mantenimiento> findByStatusEspera() 
	{
		return registro_mantenimientoImpService.findByStatusEspera();
	}

	@GetMapping("/RegistroMantenimiento/RegistrosRealizados")
	public List<Registro_mantenimiento> findByStatusRealizado() 
	{
		return registro_mantenimientoImpService.findByStatusRealizado();
	}

	@GetMapping("/RegistroMantenimiento/RegistrosCancelados")
	public List<Registro_mantenimiento> findByStatusCancelado() 
	{
		return registro_mantenimientoImpService.findByStatusCancelado();
	}

	@GetMapping("/RegistroMantenimiento/RegistroMantenimientoForIdRegistroMant/{id_registro_mantenimiento}")
	public Registro_mantenimiento findByIdRegistroMant(@PathVariable Integer id_registro_mantenimiento) {
		return registro_mantenimientoImpService.findByIdRegistro_mantenimiento(id_registro_mantenimiento);
	}
	
	@GetMapping("/RegistroMantenimiento/RegistroMantenimientoForIdAdmin/{administrador_TI}")
	public Registro_mantenimiento findLastByIdAdministrador(@PathVariable Integer administrador_TI) {
		return registro_mantenimientoImpService.findLastByIdAdministrador(administrador_TI);
	}

	
	
	
	/* AGREGAR */	
	@PostMapping(value="/RegistroMantenimiento/AgregarRegistroMantenimiento")
	public Registro_mantenimiento addRegistroMantenimiento( @RequestBody Registro_mantenimiento registro_mantenimiento ){
		registro_mantenimientoImpService.addRegistroMantenimiento(registro_mantenimiento);
		return findLastByIdAdministrador(registro_mantenimiento.getId_empleado_registra());
	}
	
	
	
	
	/* ACTUALIZAR */
	@PutMapping(value="/RegistroMantenimiento/ActualizarRegistroMantenimiento")
	public void updateRegistroMantenimiento( @RequestBody Registro_mantenimiento registro_mantenimiento  )
	{
	    registro_mantenimientoImpService.updateRegistroMantenimiento(registro_mantenimiento);
	}
	
}
