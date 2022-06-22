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
import org.springframework.web.multipart.MultipartFile;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Detalle_solicitud;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Servicio_usuario;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario.DetalleSolicitudImpService;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario.ServicioUsuarioImpService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/ControlDeUsuario")
@RestController
public class ServicioUsuarioController {
	@Autowired
	private ServicioUsuarioImpService servicioUsuarioImpService;
	@Autowired
	private DetalleSolicitudImpService detalleSolicitudImpService;
	
	
	@GetMapping(value = "/ServicioUsuario/ListaServicioUsuario")
	public List<Servicio_usuario> allServicioUsuario(){
		return servicioUsuarioImpService.findAllServicioUsuario();
	}
	
    //GuardarNuevo registro de servicio Usuario
	@PostMapping(value = "/ServicioUsuario/AgregarNuevoServicioUsuario")
	public Servicio_usuario addServicioUsuario(	@RequestParam String usuario, @RequestParam String contrasenia, @RequestParam Integer detalle_solicitud_id) {
		Servicio_usuario se = new Servicio_usuario();
		se.setFecha_registro(new Date());
		se.setUsuario(usuario);
		se.setContrasenia(contrasenia);
		Detalle_solicitud ds = detalleSolicitudImpService.findByIdDetalleSolicitud(detalle_solicitud_id);
		se.setDetalle_solicitud(ds);
		servicioUsuarioImpService.appServicioUsuario(se);
		return servicioUsuarioImpService.findByIdDetalleSolicitud(detalle_solicitud_id);
	}
	
	
	@GetMapping(value = "/ServicioUsuario/ServUsuarioPorIdServUsuario/{id_servicio_usuario}")
	private Servicio_usuario findByIdServicioUsuario(@PathVariable Integer id_servicio_usuario) {
		return servicioUsuarioImpService.findByIdServicioUsuario(id_servicio_usuario);	
	}
	
    /**Servicios de usuario por id de solicitud */
	@GetMapping(value = "/ServicioUsuario/ServUsuarioPorSolicitudId/{solicitud_id}")
	private List<Servicio_usuario> findBySolicitudId(@PathVariable Integer solicitud_id) {
		return servicioUsuarioImpService.findBySolicitudId(solicitud_id);
	}
	
    /**Servicios de usuario por id de colaborador */
	@GetMapping(value = "/ServicioUsuario/ServUsuarioPorColaboradorId/{colaborador_id}")
	private List<Servicio_usuario> findByColaboradorId(@PathVariable Integer colaborador_id) {
		return servicioUsuarioImpService.findByColabodaradorId(colaborador_id);
	}
	
	/*@GetMapping(value = "/Solicitud/servicioUPorIdDetalleSolicitud/{detalle_solicitud_id}")
	public Servicio_usuario findByIdDetalleSolicitud( @PathVariable  Integer detalle_solicitud_id) {
		return servicioUsuarioImpService.findByIdDetalleSolicitud(detalle_solicitud_id);
	}*/
	
	/*Actualizar servicioUsuario*/
	@PutMapping(value = "/ServicioUsuario/ActualizarServicioUsuario")
	public void updateServicioUsuario(@RequestParam Integer id_servicio_usuario, @RequestParam Integer detalle_solicitud_id) 
	{   
		Servicio_usuario se = new Servicio_usuario();
		Detalle_solicitud ds = detalleSolicitudImpService.findByIdDetalleSolicitud(detalle_solicitud_id);
	    se = findByIdServicioUsuario(id_servicio_usuario);
		se.setDetalle_solicitud(ds);
		servicioUsuarioImpService.updateServicioUsuario(se);
	}
	
	/**Carga la carta responsiva al servicioUsuario*/
	@PutMapping("/ServicioUsuario/ServicioUsuarioCargarResponsiva")
	public void updateServicioUsuarioResponsiva( @RequestParam Integer id_servicio_usuario, @RequestParam ("files")  MultipartFile archivo_responsiva) {
		try{
			/*Recuperamos el registro*/
        	Servicio_usuario su =  findByIdServicioUsuario(id_servicio_usuario);        	

            /*Editanos el registro buscado, añadimos la responsiva*/
            su.setArchivo_responsiva(archivo_responsiva.getBytes());
            
            /*Actualizamos el registro*/
            servicioUsuarioImpService.updateServicioUsuario(su);
   
        }catch (Exception e){ System.out.println(e); }
    
    }
}