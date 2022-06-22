package com.sofipa.backend.backend_gestion_de_recursos_de_ti.controllers.Mantenimiento;

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
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Tipo_mant;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento.Tipo_mantImpService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/Mantenimiento")
@RestController
public class Tipo_mantController {
	@Autowired
	private Tipo_mantImpService tipo_mantImpService;
	
	
	@GetMapping("/TipoMant/ListaTipoMnatForStatusTipo/{status_tipo_mant}")
	public List<Tipo_mant> findByStatusTipoMant(@PathVariable("status_tipo_mant") String status_tipo_mant) {
		return tipo_mantImpService.findByStatusTipoMant(status_tipo_mant);
	}
	
	@GetMapping("/TipoMant/ListaTipoMant")
	public List<Tipo_mant> findByAll() {
		return tipo_mantImpService.findByIdAll();
	}
	
	@GetMapping("/TipoMant/TipoMantForIdTipoMant/{id_tipo_mant}")
	public Tipo_mant findByIdTipoMant(@PathVariable Integer id_tipo_mant) {
		return tipo_mantImpService.findByIdTipoMant(id_tipo_mant);
	}
	
	@PostMapping(value="/TipoMant/AgregarTipoMant")
	public void addTipoMant( @RequestBody Tipo_mant tipo_mant ){
		tipo_mantImpService.addTipo_mant(tipo_mant);
	}
	
	@PutMapping(value="/TipoMant/ActualizarStatusTipoMant")
	public void updateStatusTipoMant( @RequestParam  Integer id_tipo_mant, @RequestParam  String status_tipo_mant ){
		
		Tipo_mant tm = this.findByIdTipoMant(id_tipo_mant);
		tm.setStatus_mant(status_tipo_mant);
		tipo_mantImpService.updateTipoMant(tm);
		
	}
}
