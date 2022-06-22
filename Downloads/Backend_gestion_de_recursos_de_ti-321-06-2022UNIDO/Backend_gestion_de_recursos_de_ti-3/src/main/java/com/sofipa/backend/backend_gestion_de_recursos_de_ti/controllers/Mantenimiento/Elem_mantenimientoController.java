package com.sofipa.backend.backend_gestion_de_recursos_de_ti.controllers.Mantenimiento;

import java.util.List;
import java.util.Map;

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
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Elem_mantenimiento;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Tipo_mant;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento.Actividad_mantImpService;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento.Elem_mantenimientoImpService;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento.Mantenimiento_equipoImpService;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento.Registro_mantenimientoImpService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/Mantenimiento")
@RestController
public class Elem_mantenimientoController {
	
	@Autowired
	private Elem_mantenimientoImpService elem_mantenimientoImpService;
	
	@Autowired
	private Registro_mantenimientoImpService registro_mantenimientoImpService;
	
	@Autowired
	private Actividad_mantImpService actividad_mantImpService;
	
	@Autowired
	private Mantenimiento_equipoImpService mantenimiento_equipoImpService;
	
	@GetMapping("/ElemMant/ListaElemMantForActividadMantId/{actividad_mant_id}")
	public List<Elem_mantenimiento> findByActividadMantId(@PathVariable("actividad_mant_id") Integer actividad_mant_id) {
		return elem_mantenimientoImpService.findByActividadMantId(actividad_mant_id);
	}
	
	@GetMapping("/ElemMant/ListaElemMantForIdMantenimiento_equipo/{mantenimiento_equipo_id}")
	public List<Elem_mantenimiento> findByIdRegistroMan(@PathVariable("mantenimiento_equipo_id") Integer mantenimiento_equipo_id) {
		return elem_mantenimientoImpService.findByIdMantenimiento_equipo(mantenimiento_equipo_id);
	}
	
	@GetMapping("/ElemMant/ListaElemMant")
	public List<Elem_mantenimiento> findByAll() {
		return elem_mantenimientoImpService.findByIdAll();
	}
	
	@GetMapping("/ElemMant/ElemMantForIdElemMant/{id_elem_mantenimiento}")
	public Elem_mantenimiento findByIdElemMant(@PathVariable Integer id_elem_mantenimiento) {
		return elem_mantenimientoImpService.findByIdElemMant(id_elem_mantenimiento);
	}
	
	@PostMapping(value="/ElemMant/AgregarElemMant")
	public void addElemMant( @RequestBody Elem_mantenimiento elem_mantenimiento, 
							 @RequestParam  Integer id_mantenimiento_equipo  ,
							 @RequestParam  Integer id_actividad_mant)
	{
		elem_mantenimiento.setMantenimiento_equipo( mantenimiento_equipoImpService.findByIdMantenimiento_equipo(id_mantenimiento_equipo) );
		elem_mantenimiento.setActividad_mant( actividad_mantImpService.findByIdActividadMant(id_actividad_mant) );
		elem_mantenimientoImpService.addElemMant(elem_mantenimiento);
	}
	
	@GetMapping("/ElemMant/ListaActividadesDeMantenimeinto/{id_mantenimiento_equipo}")
	List<Map<Actividad_mant,Tipo_mant> > findListaActividadesBy_IdMantenimiento_Equipo( @PathVariable("id_mantenimiento_equipo") Integer id_mantenimiento_equipo )
	{
		return elem_mantenimientoImpService.findListaActividadesBy_IdMantenimiento_Equipo(id_mantenimiento_equipo);
	}
}

