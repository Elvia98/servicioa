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


import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Tipo_servicio;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario.TipoServicioImpService;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/ControlDeUsuario")
@RestController
public class TipoServicioController 
{
	@Autowired
	private TipoServicioImpService tiposervicio;
	
	
	@GetMapping(value = "/TiposServicios/TodosLosTiposServicios")
	public List<Tipo_servicio> findByTodosLosServicios() {
		return tiposervicio.findByTodosLosServicios();
	}

	@GetMapping(value = "/TiposServicios/TipoServiciosPorId/{id_tipo_servicio}")
	public Tipo_servicio findByIdTipo(@PathVariable("id_tipo_servicio") Integer id_tipo_servicio) {
		return tiposervicio.findByIdTipo(id_tipo_servicio);
	}
	
	@PostMapping(value = "/TiposServicios/AgregarTipoServicio")
	public void addTipoServicio( @RequestBody Tipo_servicio tipo_servicio) {	
		tipo_servicio.setFecha_creacion_serv(new Date());
		tipo_servicio.setFecha_mod_serv(new Date());
	    tiposervicio.addTipo(tipo_servicio);
	}
	
	@PutMapping(value = "/TiposServicios/ActualizarTipoServicio")
	public void updateTipoServicio( @RequestBody Tipo_servicio tipo_servicio ) {	
		Tipo_servicio t = findByIdTipo(tipo_servicio.getId_tipo_servicio());
		tipo_servicio.setFecha_creacion_serv(t.getFecha_creacion_serv());
		tipo_servicio.setFecha_mod_serv(new Date());		
		tiposervicio.updateTipo(tipo_servicio);
	}

}
