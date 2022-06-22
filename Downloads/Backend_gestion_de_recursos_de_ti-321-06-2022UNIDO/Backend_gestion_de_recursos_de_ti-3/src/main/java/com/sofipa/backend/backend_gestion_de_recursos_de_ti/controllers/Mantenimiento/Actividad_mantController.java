package com.sofipa.backend.backend_gestion_de_recursos_de_ti.controllers.Mantenimiento;

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
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Actividad_mant;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento.Actividad_mantImpService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/Mantenimiento")
@RestController
public class Actividad_mantController {
	
	
	@Autowired
	private Actividad_mantImpService actividad_mantImpService;
	
	
	@GetMapping("/ActividadMant/ListaActividadMantForTipoMantId/{tipo_mant_id}")
	public List<Actividad_mant> findByTipoMantId(@PathVariable("tipo_mant_id") Integer tipo_mant_id) {
		return actividad_mantImpService.findByTipoMantId(tipo_mant_id);
	}
	
	@GetMapping("/ActividadMant/ListaActividadMant")
	public List<Actividad_mant> findByAll() {
		return actividad_mantImpService.findByIdAll();
	}
	
	@GetMapping("/ActividadMant/ActividadMantForIdActividadMant/{id_actividad_mant}")
	public Actividad_mant findByIdActividadMant(@PathVariable Integer id_actividad_mant) {
		return actividad_mantImpService.findByIdActividadMant(id_actividad_mant);
	}
	
	/** Metódo para guardar una actividad de mantenimiento*/
	@PostMapping(value="/ActividadMant/AgregarActividadMant")
	public void addActividadMant( @RequestBody Actividad_mant actividad_mant, @RequestParam Integer tipo_mant_id ){
		
		actividad_mant.setTipo_mant_id(tipo_mant_id);
		actividad_mant.setFecha_creacion(new Date());
		actividad_mantImpService.addActividadMant(actividad_mant);
	}
	
    /** Metódo para actualizar una actividad de mantenimiento*/
	@PutMapping(value="/ActividadMant/ActualizarActividadMant")
	public void updateStatusActividadMant( @RequestBody Actividad_mant actividad_mant, @RequestParam Integer tipo_mant_id){
		
		Actividad_mant am = this.findByIdActividadMant(actividad_mant.getId_actividad_mant());
		actividad_mant.setTipo_mant_id(tipo_mant_id);
		actividad_mant.setFecha_creacion(am.getFecha_creacion());
		actividad_mantImpService.updateActividadMant(actividad_mant);
		
	}
	
}
