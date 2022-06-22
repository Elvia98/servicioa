package com.sofipa.backend.backend_gestion_de_recursos_de_ti.controllers.Asignacion_Equipo;

import java.io.IOException;
import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Detalle_registro;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Asignacion_Equipo.Registro_asignacion;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Asignacion_Equipo.Detalle_registroImpService;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Asignacion_Equipo.Registro_asignacionImpService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/AsinacionEquipo")
@RestController
public class Detalle_registroController 
{
	@Autowired
	private Detalle_registroImpService detalle_registroImpService;
	
	@Autowired
	private Registro_asignacionImpService registro_asignacionImpService;
	
	
	/*	CONSULTAS	*/
	@GetMapping("/DetalleRegistro/ListaDetalleRegistroForIdRegistro/{id_registro_asignacion}")
	public List<Detalle_registro> findByIdRegistro(@PathVariable ("id_registro_asignacion") Integer id_registro_asignacion) 
	{
		return detalle_registroImpService.findByIdRegistro(id_registro_asignacion);
	}
	
	@GetMapping("/DetalleRegistro/ListaDetalleRegistroForIdColaborador/{colaborador_id}")
	public List<Detalle_registro> findByIdColaborador(@PathVariable ("colaborador_id") Integer colaborador_id) 
	{
		return detalle_registroImpService.findByIdColaborador(colaborador_id);
	}
	
	@GetMapping("/DetalleRegistro/DetalleRegistroForIdDetalleRegistro/{id_detalle_asignacion}")
	public Detalle_registro findByIdDetalleRegistro(@PathVariable ("id_detalle_asignacion") Integer id_detalle_asignacion) 
	{
		return detalle_registroImpService.findByIdDetalleRegistro(id_detalle_asignacion);
	}
	
	@GetMapping("/DetalleRegistro/DetalleRegistroForIdEquipoTipoEquipoStatus/{equipo_id}/{tipo_activo}")
	public Detalle_registro findByIdEquipo_Tipo_Status(
														@PathVariable ("equipo_id") Integer equipo_id, 
														@PathVariable ("tipo_activo") String tipo_activo
													  ) 
	{
		return detalle_registroImpService.findByIdEquipo_Tipo_Status(equipo_id, tipo_activo);
	}

	
	
	
	/*	AGREGAR	*/
	@PostMapping(value="/DetalleRegistro/agregarNuevoDetalle")
	public Detalle_registro addDetalleRegistro( @RequestBody Detalle_registro detalle_registro, @RequestParam Integer registro_asignacion_id )
	{
		Registro_asignacion r = registro_asignacionImpService.findByIdRegistro(registro_asignacion_id);
		detalle_registro.setRegistro(r);
		detalle_registroImpService.addDetalleRegistro(detalle_registro);
		return detalle_registroImpService.findByIdMasReciente();
	}
	
	
	
	
	/*	ACTUALIZAR	*/
	@PutMapping(value="/DetalleRegistro/ActualizarResponsiva")
	public void actualizarResponsiva( 	@RequestParam Integer id_detalle_asignacion,
										@RequestParam ("files")  MultipartFile archivo_responsiva
									)
	{	
		try 
		{
			Detalle_registro detalle_registro = detalle_registroImpService.findByIdDetalleRegistro(id_detalle_asignacion);
			detalle_registro.setArchivo_responsiva(archivo_responsiva.getBytes());
			detalle_registroImpService.updateDetalleRegistro(detalle_registro);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@PutMapping(value="/DetalleRegistro/ActualizarNuevoDetalle")
	public void updateDetalleRegistro( @RequestBody Detalle_registro detalle_registro, @RequestParam Integer registro_asignacion_id )
	{
		Registro_asignacion r = registro_asignacionImpService.findByIdRegistro(registro_asignacion_id);
		detalle_registro.setRegistro(r);
		detalle_registroImpService.updateDetalleRegistro(detalle_registro);
	}
	
}
