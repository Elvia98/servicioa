package com.sofipa.backend.backend_gestion_de_recursos_de_ti.controllers.ControlUsuario;

import java.util.Date;
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
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Elem_servicio;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Servicio_usuario;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario.DetalleSolicitudImpService;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario.Elem_servicioImpService;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario.ServicioUsuarioImpService;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/ControlDeUsuario")
@RestController
public class Elem_servicioController {
	@Autowired
	private Elem_servicioImpService elem_servicioImpService;
	@Autowired
	private ServicioUsuarioImpService servicioUsuarioImpService;
	@Autowired
	private DetalleSolicitudImpService detalleSolicitudImpService;
	
    /**Regresa una lista de los elemento  de servicio activados segun sea el id_solicitud */
	@GetMapping("/ElemServicio/ListaElemServiciosForIdSolicitudAct/{id_solicitud}")
	public List<Elem_servicio> 	findByIdSolicitudAct(@PathVariable("id_solicitud") Integer id_solicitud) {
		return elem_servicioImpService.findByIdSolicitudAct(id_solicitud);
	}
	
    /**Regresa una lista de los elemento  de servicio suspendidos segun sea el id_solicitud */
	@GetMapping("/ElemServicio/ListaElemServiciosForIdSolicitudSusp/{id_solicitud}")
	public List<Elem_servicio> 	findByIdSolicitudSusp(@PathVariable("id_solicitud") Integer id_solicitud) {
		return elem_servicioImpService.findByIdSolicitudSusp(id_solicitud);
	}

    /**Regresa la lista de todos los servicios activados o suspendidos por colaborador y una sucursal en especifico */
	@GetMapping("/ElemServicio/ListaElemServiciosForColaboradorSucursal/{colaborador_id}/{sucursal_id}")
	public List<Elem_servicio> 	findByColaboradorIdAndSucursalId(@PathVariable("colaborador_id") Integer colaborador_id, @PathVariable("sucursal_id") Integer sucursal_id ) {
		return elem_servicioImpService.findByColaboradorIdAndSuscursalId(colaborador_id, sucursal_id);
	}
	
    /**Regresa la lista de todos los servicios activados o suspendidos por colaborador*/
	@GetMapping("/ElemServicio/ListaElemServiciosForColaborador/{colaborador_id}")
	public List<Elem_servicio> 	findByColaboradorIdAnd(@PathVariable("colaborador_id") Integer colaborador_id ) {
		return elem_servicioImpService.findByColaboradorId(colaborador_id);
	}

	@GetMapping("/ElemServicio/ListaElemServicios")
	public List<Elem_servicio> findAll() {
		return elem_servicioImpService.findAll();
	}
	
    /**Regresa un ElemServicio por su id */
	@GetMapping("/ElemServicio/ElemServicioForIdElemServicio/{id_elem_servicio}")
	public Elem_servicio findByIdElemServicio(@PathVariable("id_elem_servicio") Integer id_elem_servicio) {
		return elem_servicioImpService.findByIdElemServicio(id_elem_servicio);
	}
	
    /**Inserta un ElemServicio */
	@PostMapping(value="/ElemServicio/AgregarElemServicio")
	public void addElemServicio( @RequestParam Integer servicio_usuario_id, @RequestParam Integer detalle_solicitudAct_id, @RequestParam Integer sucursal_id){ //@RequestBody Elem_servicio elem_servicio
		Elem_servicio elem_servicio = new Elem_servicio();
		Servicio_usuario se = new Servicio_usuario();
		Detalle_solicitud dsAct = new Detalle_solicitud();
		/* Al crearse un elem servicio por defecto debe de pertenecer a una activación*/
	    se=servicioUsuarioImpService.findByIdServicioUsuario(servicio_usuario_id);
	    dsAct= detalleSolicitudImpService.findByIdDetalleSolicitud(detalle_solicitudAct_id);

	    elem_servicio.setDetalle_solicitudAct(dsAct);
	    elem_servicio.setServicio_usuario(se);
	    elem_servicio.setStatus_registro("Activado");
	    elem_servicio.setFecha_registro(new Date());
	    elem_servicio.setSucursal_id(sucursal_id);
		elem_servicioImpService.addElemServicio(elem_servicio);
	}
	
    /**Actualizar estado del elem_servicio*/
	@PutMapping(value = "/ElemServicio/ActualizarStatusElemServicio")
	public void updateElemServicio(@RequestParam Integer id_elem_servicio, @RequestParam String status_registro, @RequestParam Integer detalle_solicitudSup_id) {
		Elem_servicio es= findByIdElemServicio(id_elem_servicio);
		Detalle_solicitud ds= detalleSolicitudImpService.findByIdDetalleSolicitud(detalle_solicitudSup_id);
		es.setFecha_modificacion(new Date());
		es.setStatus_registro(status_registro);
		es.setDetalle_solicitudSusp(ds);
		elem_servicioImpService.updateElemServicio(es);
	}
	
}
