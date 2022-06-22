package com.sofipa.backend.backend_gestion_de_recursos_de_ti.controllers.Asignacion_Equipo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Asignacion_Equipo.Solicitud_Asig_EquipoDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Registro_asignacion;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Solicitud_Asig_Equipo;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Asignacion_Equipo.Registro_asignacionImpService;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Asignacion_Equipo.Solicitud_Asig_EquipoImpService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/AsinacionEquipo")
@RestController
public class Solicitud_Asig_EquipoController 
{	
	@Autowired
	private Solicitud_Asig_EquipoImpService solicitud_Asig_EquipoImpService;
	
    
	/* CONSULTAS	*/
	
	/*	SOLICITANTE	*/
	@GetMapping("/SolicitudAsignacionEquipo/ListaSolicitudesEnEsperaPorIdSolicitante/{solicitante_id}")
	public List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusEspera(@PathVariable("solicitante_id") Integer solicitante_id) 
	{
		return solicitud_Asig_EquipoImpService.findBy_IdSolicitante_StatusEspera(solicitante_id);
	}

	@GetMapping("/SolicitudAsignacionEquipo/ListaSolicitudesCanceladasPorIdSolicitante/{solicitante_id}")
	public List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusCancelado(@PathVariable("solicitante_id") Integer solicitante_id) 
	{
		return solicitud_Asig_EquipoImpService.findBy_IdSolicitante_StatusCancelado(solicitante_id);
	}

	@GetMapping("/SolicitudAsignacionEquipo/ListaSolicitudesAtendidasPorIdSolicitante/{solicitante_id}")
	public List<Solicitud_Asig_Equipo> findBy_IdSolicitante_StatusAtendido(@PathVariable("solicitante_id") Integer solicitante_id) 
	{
		return solicitud_Asig_EquipoImpService.findBy_IdSolicitante_StatusAtendido(solicitante_id);
	}

	
	/*	ADMINISTRADOR	*/
	@GetMapping("/SolicitudAsignacionEquipo/ListaSolicitudesEnEspera")
	public List<Solicitud_Asig_Equipo> findBy_StatusEspera() 
	{
		return solicitud_Asig_EquipoImpService.findBy_StatusEspera();
	}

	@GetMapping("/SolicitudAsignacionEquipo/ListaSolicitudesCanceladas")
	public List<Solicitud_Asig_Equipo> findBy_StatusCancelado() 
	{
		return solicitud_Asig_EquipoImpService.findBy_StatusCancelado();
	}

	@GetMapping("/SolicitudAsignacionEquipo/ListaSolicitudesAtendidas")
	public List<Solicitud_Asig_Equipo> findBy_StatusAtendido() 
	{
		return solicitud_Asig_EquipoImpService.findBy_StatusAtendido();
	}
	
	
	/*	CONSULTAS	*/
	@GetMapping("/SolicitudAsignacionEquipo/SolicitudPorId/{id_solicitud_asig_equipo}")
	public Solicitud_Asig_Equipo findBy_IdSolicitud(@PathVariable("id_solicitud_asig_equipo") Integer id_solicitud_asig_equipo) 
	{
		return solicitud_Asig_EquipoImpService.findBy_IdSolicitud(id_solicitud_asig_equipo) ;
	}
	
	
	
	
	/*	AGREGAR	*/
	@PostMapping("/SolicitudAsignacionEquipo/CrearSolicitudAsignacionEquipo")
	public Solicitud_Asig_Equipo nuevaSolicitud( @RequestBody Solicitud_Asig_Equipo solicitud)
	{
		if( solicitud_Asig_EquipoImpService.findBy_Status_And_IdColaborador_And_TipoEquipo(solicitud.getColaborador_id(), solicitud.getTipo_equipo()) != null )
		{
			return null;
		}
		else
		{
			solicitud_Asig_EquipoImpService.addRegistro(solicitud);
			return solicitud_Asig_EquipoImpService.findBy_LastIdSolicitud();
		}
	}
	
	
	
	
	/*	ACTUALIZAR	*/
	@PutMapping("/SolicitudAsignacionEquipo/ActualizarSolicitudAsignacionEquipo")
	public void updateSolicitud_Asig_Equipo( @RequestBody Solicitud_Asig_Equipo  solicitud_Asig_Equipo ) 
	{
		solicitud_Asig_EquipoImpService.updateRegistro(solicitud_Asig_Equipo);
	}
	
}
