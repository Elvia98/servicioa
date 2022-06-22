package com.sofipa.backend.backend_gestion_de_recursos_de_ti.controllers.Inventario;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Inventario.GlpiService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
@RequestMapping("/api")
@RestController
public class GlpiController {

	//Mandamos a llamar el servicio que nos conecta con el Dao
	protected GlpiService glpiservice = new GlpiService();
	
	//Un constructor
	public GlpiController() {}

	
	@GetMapping( value = "/generateToken" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String generateToken() 
	{
		return glpiservice.generateToken();
	}
	
	@GetMapping( value = "/killToken" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteToken(String token) 
	{
		return glpiservice.deleteToken(token);
	}
	
	/*
	  Mètodo que sirve para llamar a todos los items de una tabla
	  Paràmetros: la tabla en la que se van a llamar los datos, el token de sesión 
	*/
	@GetMapping( value = "/AllItems" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String AllItems(@RequestParam String tabla, String token) 
	{
		return glpiservice.AllItems(tabla,token);
	}

	@GetMapping( value = "/AllEquipos" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String AllIEquipos(String tabla, String token)
	{
		return glpiservice.AllIEquipos(tabla, token);
	}
	
	@GetMapping( value = "/AnUser" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String AnUser(@RequestParam String token, @RequestParam String nombre, @RequestParam String apellidos)
	{
		return glpiservice.AnUser(token,nombre,apellidos);
	}
	
	@GetMapping( value = "/AnUserForUserName" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String AnUserForUserName(@RequestParam String token, @RequestParam String username)
	{
		return glpiservice.AnUserForUserName(token,username);
	}
	
	@GetMapping( value = "/AnEquipoExtends" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String AnEquipo(String tabla, String id, String token)
	{
		return glpiservice.AnEquipo(tabla,id,token);
	}
	
	/*
	 Mètodo que sirve para llamar a un item en especifico de una tabla
	 Paràmetros: la tabla en la que se van a llamar los datos, el id del item, el token de sesión
	*/
	@GetMapping( value = "/AnItem" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String AnItem(@RequestParam String tabla, String id, String token) 
	{
		return glpiservice.AnItem(tabla,id,token);
	}
	
	
	@PostMapping( value = "/addItem" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String AddItem(@RequestBody String body, @RequestParam String tabla, @RequestParam String token) throws IOException 
	{
		return glpiservice.AddItem(body, tabla, token);
	}

	@PutMapping( value = "/updateItem" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateItem(@RequestBody String body, @RequestParam String tabla, @RequestParam String id, @RequestParam String token) throws IOException 
	{
		return glpiservice.updateItem(body, tabla,id, token);
	}
	
	
	//Método para regresar subitems de una tabla en especifico
	@GetMapping( value = "/allSubItems" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String AllItems(@RequestParam String id, String tabla, String token)
	{
	return glpiservice.allSubItems(id,tabla,token);
	}
	
	
	//Método para regresar un item en especifico de una tabla especifica
	@GetMapping( value = "/anItemExtends" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String AnItemExtends(@RequestParam String tabla, @RequestParam String id, @RequestParam String token)
	{
		return glpiservice.AnItemExtends(tabla, id,token);
	}
	
	
	@GetMapping( value = "/allOperatingSystems" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String AllOperatingSystems(@RequestParam String token)
	{
		return glpiservice.AllOperatingSystems(token);
	}
	
}