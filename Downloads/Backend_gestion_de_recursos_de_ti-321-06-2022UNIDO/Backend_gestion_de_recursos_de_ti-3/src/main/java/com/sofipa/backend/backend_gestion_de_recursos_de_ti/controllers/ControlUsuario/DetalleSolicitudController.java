package com.sofipa.backend.backend_gestion_de_recursos_de_ti.controllers.ControlUsuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Detalle_solicitud;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Solicitud;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Tipo_servicio;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario.DetalleSolicitudImpService;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario.SolicitudImpService;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario.TipoServicioImpService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/ControlDeUsuario")
@RestController
public class DetalleSolicitudController 
{
	
	@Autowired
	private DetalleSolicitudImpService detalleSolicitudImpService;
	
	@Autowired
	private SolicitudImpService solicitudImpService;
	
	@Autowired
	private TipoServicioImpService tiposervicio;
		
	
	@GetMapping(value = "/DetalleSolicitud/ListaDetalleSolicitudPorIdSolicitud/{solicitud_id}")
	public List<Detalle_solicitud> findByIdSolicitud(@PathVariable ("solicitud_id") Integer solicitud_id) 
	{
		return detalleSolicitudImpService.findByIdSolicitud(solicitud_id);
	}

	@GetMapping(value = "/DetalleSolicitud/DetalleSolicitudPorIdDetalle/{id_detalle_solicitud}")
	public Detalle_solicitud findByIdDetalleSolicitud(@PathVariable ("id_detalle_solicitud") Integer id_detalle_solicitud) {
		return detalleSolicitudImpService.findByIdDetalleSolicitud(id_detalle_solicitud);
	}


	@PostMapping(value = "/DetalleSolicitud/AgregarNuevoDetalleSolicitud")
	public Detalle_solicitud appDetalleSolicitud(@RequestParam Integer solicitud_id,@RequestParam Integer tipo_servicio_id, @RequestParam Integer servicio_usuario_id ) {
		Detalle_solicitud ds = new Detalle_solicitud();
		ds.setStatus_serv("Espera");
		Solicitud s = solicitudImpService.findByIdSolicitud(solicitud_id);
		Tipo_servicio ts = tiposervicio.findByIdTipo(tipo_servicio_id);
		if(servicio_usuario_id>0) {
			ds.setServicio_usuario_id(servicio_usuario_id);
		}
		
		ds.setSolicitud(s);
		ds.setTipo_servicio(ts);
		detalleSolicitudImpService.appDetalleSolicitud(ds);
		return detalleSolicitudImpService.ultimoDetalleBySolicitudId(solicitud_id);
	}

	
	@PutMapping(value = "/DetalleSolicitud/ActualizarDetalleSolicitud")
	public void updateDetalleSolicitud(@RequestParam Integer id_detalle_solicitud,
										 @RequestParam String status_serv) 
	{
		Detalle_solicitud ds = findByIdDetalleSolicitud(id_detalle_solicitud);
		ds.setStatus_serv(status_serv);
	    detalleSolicitudImpService.updateDetalleSolicitud(ds);
	}
	
}
