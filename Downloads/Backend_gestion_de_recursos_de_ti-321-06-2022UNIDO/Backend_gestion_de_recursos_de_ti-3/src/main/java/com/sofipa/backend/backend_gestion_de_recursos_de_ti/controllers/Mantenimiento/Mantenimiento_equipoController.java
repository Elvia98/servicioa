package com.sofipa.backend.backend_gestion_de_recursos_de_ti.controllers.Mantenimiento;

import java.util.List;
import java.util.Map;

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

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Actividad_mant;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Mantenimiento_equipo;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento.Mantenimiento_equipoImpService;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento.Registro_mantenimientoImpService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/Mantenimiento")
@RestController
public class Mantenimiento_equipoController {
	
	
	@Autowired
	private Mantenimiento_equipoImpService mantenimiento_equipoImpService;
	
	@Autowired
	private Registro_mantenimientoImpService registro_mantenimientoImpService;
	
	
	
	/* C	O	N	S	U	L	T	A	S */
	
	@GetMapping("/MantenimientoEquipo/MantenimientoEquipoForIdRegistroAndAndActividadesAndTipo/{registro_mantenimiento_id}")
	public List<Map<Mantenimiento_equipo, Actividad_mant>> findByIdRegistroAndAndActividadesAndTipo(@PathVariable ("registro_mantenimiento_id") Integer registro_mantenimiento_id) {
		return mantenimiento_equipoImpService.findByIdRegistroAndAndActividadesAndTipo(registro_mantenimiento_id);
	}
	
	@GetMapping("/MantenimientoEquipo/ListaMantEquipoForRegistroMantId/{registro_mantenimiento_id}")
	public List<Mantenimiento_equipo> findByRegistroMantId(@PathVariable("registro_mantenimiento_id") Integer registro_mantenimiento_id) {
		return mantenimiento_equipoImpService.findByRegistroMantId(registro_mantenimiento_id);
	}
	
	@GetMapping("/MantenimientoEquipo/MantenimientoEquipoForIdMantEquipoSinEditar/{id_registro_mantenimiento}")
	public List<Mantenimiento_equipo> findByRegistroMantIdSinEditSinEditar(@PathVariable ("id_registro_mantenimiento") Integer id_registro_mantenimiento) {
		return mantenimiento_equipoImpService.findByRegistroMantIdSinEditSinEditar(id_registro_mantenimiento);
	}
	
	@GetMapping("/MantenimientoEquipo/MantenimientoEquipoForIdMantEquipo/{id_registro_mantenimiento}")
	public Mantenimiento_equipo findByIdMantEquipo(@PathVariable Integer id_mantenimiento_equipo) {
		return mantenimiento_equipoImpService.findByIdMantenimiento_equipo(id_mantenimiento_equipo);
	}
	
	public Mantenimiento_equipo findBy_IdRegistroMantenimiento(Integer registro_mantenimiento_id) {
		return mantenimiento_equipoImpService.findBy_IdRegistroMantenimiento(registro_mantenimiento_id);
	}

	public Mantenimiento_equipo findLastMantenimientoEquipoByIdRegistroMant(Integer registro_mantenimiento_id) {
		return mantenimiento_equipoImpService.findLastMantenimientoEquipoByIdRegistroMant(registro_mantenimiento_id) ;
	}
	
	@GetMapping("/MantenimientoEquipo/MantenimientoEquipoForTipoActivoAndIdEquipo/{tipo_activo}/{equipo_id}")
	public Mantenimiento_equipo findByTipoActivoAndIdEquipo( @PathVariable ("tipo_activo") String tipo_activo, 
															 @PathVariable ("equipo_id")   Integer equipo_id )
	{
		return mantenimiento_equipoImpService.findByTipoActivoAndIdEquipo(tipo_activo,equipo_id);
	}
	
	
	
	
	/* A	G	R	E	G	A	R */
	@PostMapping(value="/MantenimientoEquipo/AgregarMantenimientoEquipo")
	public Mantenimiento_equipo addMantenimientoEquipo( @RequestBody Mantenimiento_equipo mantenimiento_equipo,  @RequestParam  Integer id_registro_mantenimiento){	
		mantenimiento_equipo.setRegistroMantenimiento(registro_mantenimientoImpService.findByIdRegistro_mantenimiento(id_registro_mantenimiento));
		mantenimiento_equipoImpService.addMantenimientoEquipo(mantenimiento_equipo);
		return findLastMantenimientoEquipoByIdRegistroMant(id_registro_mantenimiento);
	}

	
	
	
	/* A	C	T	U	A	L	I	Z	A	R */
	@PutMapping(value="/MantenimientoEquipo/ActualizarObservRegistroMantenimiento")
	public void updateObservMantenimientoEquipo( @RequestParam  Integer id_mantenimiento_equipo, 
												 @RequestParam  String  comentarios_usuario, 
												 @RequestParam  String  observ_equipo, 
												 @RequestParam  String  problema_localizado ){
		
		Mantenimiento_equipo me = this.findByIdMantEquipo(id_mantenimiento_equipo);
		me.setProblema_localizado(problema_localizado);
		me.setObserv_equipo(observ_equipo);
		me.setComentarios_usuario(comentarios_usuario);
		mantenimiento_equipoImpService.updateMantenimientoEquipo(me);
		
	}
}
