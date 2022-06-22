package com.sofipa.backend.backend_gestion_de_recursos_de_ti.controllers.Asignacion_Equipo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.multipart.MultipartFile;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Detalle_registro;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Registro_asignacion;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Solicitud_Asig_Equipo;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Asignacion_Equipo.Detalle_registroImpService;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Asignacion_Equipo.Registro_asignacionImpService;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Asignacion_Equipo.Solicitud_Asig_EquipoImpService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/AsinacionEquipo")
@RestController
public class Registro_asignacionController 
{
	
	@Autowired
	private Registro_asignacionImpService registro_asignacionImpService;	
	
	@Autowired
	private Solicitud_Asig_EquipoImpService solicitud_Asig_EquipoImpService;
	
	
	
	
	/*	CONSULTAS	*/
	@GetMapping("/RegistroAsignacion/SeguimientoPendientes")	
	public List<Integer> findBySeguimiento() 
	{
		return registro_asignacionImpService.findBySeguimiento();
	}
	
	@GetMapping("/RegistroAsignacion/ListaRegistroAsignacionPorIdColaborador/{colaborador_id}")
	public List<Registro_asignacion> findByIdColaborador( @PathVariable("colaborador_id") Integer colaborador_id) 
	{
		return registro_asignacionImpService.findByIdColaborador(colaborador_id);
	}

	@GetMapping("/RegistroAsignacion/ListaRegistroAsignacionPorIdSolicitud/{solicitud_asig_equipo_id}")
	public List<Registro_asignacion> findByIdSolicitud( @PathVariable("solicitud_asig_equipo_id") Integer solicitud_asig_equipo_id) 
	{
		return registro_asignacionImpService.findByIdSolicitud(solicitud_asig_equipo_id);
	}
		
	@GetMapping("/RegistroAsignacion/RegistroAsignacionActivoMasReciente")
	public Registro_asignacion findBy_MasReciente_StatusActivo() 
	{
		return registro_asignacionImpService.findByMasReciente();
	}
	
	@GetMapping("/RegistroAsignacion/RegistroAsignacionPorId/{id_registro_asignacion}")
	public Registro_asignacion findByIdRegistro( @PathVariable("id_registro_asignacion") Integer id_registro_asignacion ) 
	{
		return registro_asignacionImpService.findByIdRegistro(id_registro_asignacion);
	}

	
	
	
	/*	AGREGAR	*/
	@PostMapping("/RegistroAsignacion/AgregarRegistroAsignacionDirecta")
	public Registro_asignacion addRegistroD( @RequestBody Registro_asignacion registro ) 
	{
		registro.setSolicitud(null);
		registro_asignacionImpService.addRegistro(registro);
		return registro_asignacionImpService.findByMasReciente();
	}
	
	@PostMapping("/RegistroAsignacion/AgregarRegistroAsignacionIndirecta")
	public Registro_asignacion addRegistroI( @RequestBody Registro_asignacion registro, @RequestParam Integer id_solicitud_asig_equipo ) 
	{
		Solicitud_Asig_Equipo solicitud_Asig_Equipo = solicitud_Asig_EquipoImpService.findBy_IdSolicitud(id_solicitud_asig_equipo);
		registro.setSolicitud(solicitud_Asig_Equipo);
		registro_asignacionImpService.addRegistro(registro);
		return registro_asignacionImpService.findByMasReciente();
	}

	

	
	/*	ACTUALIZAR	*/
	@PutMapping("/RegistroAsignacion/ActualizarRegistroAsignacion")
	public void updateRegistro(@RequestBody Registro_asignacion registro) 
	{
		registro_asignacionImpService.updateRegistro(registro);	
	}
	

	
	
}
