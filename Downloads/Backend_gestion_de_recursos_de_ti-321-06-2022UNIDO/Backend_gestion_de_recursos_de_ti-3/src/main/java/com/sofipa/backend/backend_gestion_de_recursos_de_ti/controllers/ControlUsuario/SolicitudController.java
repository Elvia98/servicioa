package com.sofipa.backend.backend_gestion_de_recursos_de_ti.controllers.ControlUsuario;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Solicitud;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Tipo_solicitud_usuario;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario.SolicitudImpService;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario.Tipo_solicitud_usuarioImpService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/ControlDeUsuario")
@RestController
public class SolicitudController 
{

	@Autowired
	private SolicitudImpService solicitudImpService;
	@Autowired
	private Tipo_solicitud_usuarioImpService tipo_solicitud_usuarioImpService;
	
	
	@GetMapping(value = "/Solicitud/ListaSolicitudes")
	public List<Solicitud> findAllSolicitudesUsuario()
	{
		return solicitudImpService.findAllSolicitudes();
	}
	
	   /** Método del administrador de TI - Get a todas las solicitudes por solicitante **/
	@GetMapping(value = "/Solicitud/ListaSolicitudPorSolicitante/{solicitante_id}")
	public List<Solicitud> findByIdSolicitante(@PathVariable Integer solicitante_id)
	{
		return solicitudImpService.findByIdSolicitante(solicitante_id);
	}
	
	  /** Método del administrador de TI - Get a todas las solicitudes por colaborador **/
	@GetMapping(value = "/Solicitud/ListaSolicitudPorColaborador/{colaborador_id}")
	public List<Solicitud> findByIdColaborador(@PathVariable Integer colaborador_id)
	{
		return solicitudImpService.findByIdColaborador(colaborador_id);
	}
	
	  /**Regresa l aultima solicitud por el tipo de solicitud y el solicitante que la realizó */
	@GetMapping(value = "/Solicitud/ultimaSoliSolicitudEsperaPorSolicitanteAndTipo/{solicitante_id}/{tipo_solicitud_usuario_id}")
	public Solicitud ultimaSoliByIdSolicitanteAndTipoAndStatusEspera(@PathVariable Integer solicitante_id, 
															         @PathVariable Integer tipo_solicitud_usuario_id) {
		return solicitudImpService.ultimaSoliByIdSolicitanteAndTipoAndStatusEspera(solicitante_id, tipo_solicitud_usuario_id);
	}
	
	  /** Método para mostrar una solicitud en especifico **/
	@GetMapping(value = "/Solicitud/SolicitudPorIdSolicitud/{id_solicitud}")
	public Solicitud findByIdSolicitud(@PathVariable Integer id_solicitud) {
		return solicitudImpService.findByIdSolicitud(id_solicitud);
	}
    
	/*Agrega una nueva solicitud*/
	@PostMapping("/Solicitud/AgregarNuevaSolicitud")
	public Solicitud addSolicitud( @RequestBody Solicitud solicitud, @RequestParam Integer tipo_solicitud_usuario_id ) 
	{
		Tipo_solicitud_usuario ts = tipo_solicitud_usuarioImpService.findByIdTipoSolicitudUsuario(tipo_solicitud_usuario_id);
		solicitud.setTipo_solicitud_usuario(ts);
		solicitud.setFecha_solicitud(new Date());
		solicitud.setStatus_solicitud("Espera");
		solicitudImpService.addSolicitud(solicitud);
		System.out.println(solicitud.getFecha_alta()+" fechas "+ solicitud.getFecha_baja());
		return solicitudImpService.ultimaSoliByIdSolicitanteAndTipoAndStatusEspera(solicitud.getSolicitante_id(), tipo_solicitud_usuario_id);
	}
	
	  /**Actualizar estado de la  solicitud*/
	@PutMapping(value = "/Solicitud/ActualizarSolicitud")
	public void updateSolicitud(@RequestParam Integer id_solicitud, @RequestParam String status_solicitud, @RequestParam Integer administrador_TI_id){
		Solicitud s = findByIdSolicitud(id_solicitud);
		s.setFecha_atencion(new Date());
		s.setFecha_modificacion(new Date());
		s.setStatus_solicitud(status_solicitud);
		if(status_solicitud!="Cancelado") {
			s.setAdministrador_TI_id(administrador_TI_id);
		}
	    solicitudImpService.updateSolicitud(s);
	}
	
}
