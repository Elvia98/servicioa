package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Inventario;

import java.io.IOException;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestMethod;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
public class GlpiDao {
	/*        Variables:
	   1. Url de la api rest de glpi
	   2. un rest para realizar las peticiones  la api
	*/
	//protected String url_api_glpi = "http://localhost:8081/glpi/apirest.php/";
	protected String url_api_glpi = "http://localhost:80/glpi/apirest.php/";
	protected RestTemplate restTemplate =  new RestTemplate();
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	//Constructor
	public GlpiDao(){}

	//creamos una funcion que genera encabezdos para generar enviar el token de acceso al encabezado
	private HttpHeaders createHeaders(String encabezado, String dato)
	{

	   return new HttpHeaders() 
	   {
		   {
			   set(encabezado , dato);
		   }
	   };
	}


	//Creaa el token de sesion
	public String generateToken() 
	{
		String url = this.url_api_glpi + "initSession";
		ResponseEntity<String> a = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(createHeaders( "Authorization", "Basic Z2xwaTpnbHBp" )), String.class);
		String b = a.getBody();
		return b;
	}
	
	//Elimina el token de sesion
	public String deleteteToken(String token) 
	{
		String url = this.url_api_glpi + "killSession";
		ResponseEntity<String> a = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(createHeaders( "Session-Token", token )), String.class);
		String b = a.getBody();
		return b;
	}
	
	/* ******************  METODOS RELACIONADOS CON LA APIREST DE GLPI ****************** */
	
	//Método para regresar todas los items de una tabla especificada
	public String AllItems(String tabla, String token)
	{
		String url = this.url_api_glpi + tabla + "?range=0-500";
		ResponseEntity<String> a = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(createHeaders( "Session-Token",token )), String.class);
		String b = a.getBody();
		return b;
	}
	
	
	//Método para regresar todas los items de una tabla especificada  
	public String AllIEquipos(String tabla, String token)
	{
		String url = this.url_api_glpi + tabla + "?range=0-100000&expand_dropdowns=true&get_hateoas=0&order=DESC";
		ResponseEntity<String> a = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(createHeaders( "Session-Token",token )), String.class);
		String b = a.getBody();
		return b;
	}
	
	
	//Para buscar los componentes de una computadora, segun sea la tabla
	public String allSubItems(String id, String tabla, String token)
	{
	    String tipoItem="Computer/";
	String url = this.url_api_glpi +tipoItem+ id+"/"+ tabla + "?range=0-10000";
	ResponseEntity<String> a = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(createHeaders( "Session-Token",token )), String.class);
	String b = a.getBody();
	return b;
	}
	
	
	//Método para regresar un usuario
	public String AnUser(String token,String nombre, String apellidos)
	{
		String url = this.url_api_glpi + "User?searchText[firstname]="+nombre+"&searchText[realname]="+apellidos;
		ResponseEntity<String> a = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(createHeaders( "Session-Token",token )), String.class);
		String b = a.getBody();
		return b;
	}
	
	
	//Método para regresar un usuario por medio del nombre del usuario
	public String AnUserForUserName(String token,String username)
	{
		String url = this.url_api_glpi + "User?searchText[users_id]="+username;
		ResponseEntity<String> a = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(createHeaders( "Session-Token",token )), String.class);
		String b = a.getBody();
		return b;
	}
	
	
	//Método para regresar un item en especifico de una tabla especifica
	public String AnItem(String tabla, String id, String token)
	{
		String url = this.url_api_glpi + tabla + "/" + id;
		ResponseEntity<String> a = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(createHeaders( "Session-Token", token )), String.class);
		String b = a.getBody();
		return b;
	}
	
	//Método para regresar un item en especifico de una tabla especifica
	public String AnItemExtends(String tabla, String id, String token)
	{
		String url = this.url_api_glpi + tabla + "/" + id + "?expand_dropdowns=true";
		ResponseEntity<String> a = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(createHeaders( "Session-Token", token )), String.class);
		String b = a.getBody();
		return b;
	}
	
	
	//Método para regresar un item en especifico de una tabla especifica
	public String AnEquipo(String tabla, String id, String token)
	{
		String url = this.url_api_glpi + tabla + "/" + id + "?expand_dropdowns=true";
		ResponseEntity<String> a = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(createHeaders( "Session-Token", token )), String.class);
		String b = a.getBody();
		return b;
	}
	
	
	public String AllOperatingSystems(String token)
	{
		String url = this.url_api_glpi + "Item_Operatingsystem?expand_dropdowns=true&get_hateoas=false&range=0-10000";
		ResponseEntity<String> a = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(createHeaders( "Session-Token", token )), String.class);
		String b = a.getBody();
		return b;
	}
	
	
	//Método para insertar los datos de un item a una tabla especifica(POST)
 public String addItem(String body, String tabla, String token) throws IOException {
		
 	String url = this.url_api_glpi + tabla;
		HttpHeaders headers = new HttpHeaders();
		
		
		headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.set("Session-Token", token);
	    
		
		HttpEntity<String> request = 
			      new HttpEntity<String>(body, headers);
		
		String resu = 
			      restTemplate.postForObject(url, request, String.class);
			    JsonNode root = objectMapper.readTree(resu);
			    
		return resu;
	}

 
 public String updateItem(String body, String tabla, String id, String token) throws IOException {
 	
		String url = this.url_api_glpi + tabla + "/" + id;
		HttpHeaders headers = new HttpHeaders();

		headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.set("Session-Token", token);
	    
		HttpEntity<String> request = new HttpEntity<String>(body, headers);

		restTemplate.put(url, request);
			    
		return "{\"Output\": {\"mensaje\": \"Registro Actualizado\"}}";
	}
}

