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
import org.springframework.web.bind.annotation.RestController;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Tipo_solicitud_usuario;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario.Tipo_solicitud_usuarioImpService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/ControlDeUsuario")
@RestController
public class Tipo_solicitud_usuarioController 
{
	@Autowired
	private Tipo_solicitud_usuarioImpService tipo_solicitud_usuarioImpService;
	
	  //Método para llamar a todos los tipos de solicitudes
	@GetMapping(value = "/TipoSolicitudUsuario/TodosLosTiposSolicitudUsuario")
	public List<Tipo_solicitud_usuario> findAllTiposSolicitudes() {
		return tipo_solicitud_usuarioImpService.findAllTiposSolicitudes();
	}

	  //Un tipo de solicitud por id de la solicitud
	@GetMapping(value = "/TipoSolicitudUsuario/UnTipoSolicitudUsuarioPorId/{id_tipo_solicitud_usuario}")
	public Tipo_solicitud_usuario findByIdTipoSolicitudUsuario( @PathVariable("id_tipo_solicitud_usuario") Integer id_tipo_solicitud_usuario) {
		return tipo_solicitud_usuarioImpService.findByIdTipoSolicitudUsuario(id_tipo_solicitud_usuario);
	}
	
	@PostMapping(value = "/TipoSolicitudUsuario/AgregarTipoSolicitudUsuario")
	public void addTipoSolicitud( @RequestBody Tipo_solicitud_usuario tipo_solicitud) {	
		tipo_solicitud.setFecha_creacion(new Date());
		tipo_solicitud.setFecha_mod(new Date());
	    tipo_solicitud_usuarioImpService.addTipoSolicitud(tipo_solicitud);
	}
	
	@PutMapping(value = "/TipoSolicitudUsuario/ActualizarTipoSolicitudUsuario")
	public void updateTipoSolicitud( @RequestBody Tipo_solicitud_usuario tipo_solicitud ) {	
		Tipo_solicitud_usuario t = findByIdTipoSolicitudUsuario(tipo_solicitud.getId_tipo_solicitud_usuario());
		t.setTipo_solicitud(tipo_solicitud.getTipo_solicitud());
		t.setFecha_mod(new Date());
		t.setDescripcion(tipo_solicitud.getDescripcion());
		t.setStatus_solicitud(tipo_solicitud.getStatus_solicitud());
		
		tipo_solicitud_usuarioImpService.updateTipoSolicitud(t);
	}
	
}
