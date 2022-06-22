package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Inventario;


import java.io.IOException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Inventario.GlpiDao;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PATCH,RequestMethod.PUT})
public class GlpiService
{
	
	protected GlpiDao glpidao = new GlpiDao();
	
	//Constructor 
	public GlpiService() {}

	//Crea el token de session
	public String generateToken()
	{
		return glpidao.generateToken();
	}
	
	//Elimina el token de sesion
	public String deleteToken(String token)
	{
		return glpidao.deleteteToken(token);
	}
	
	//Metodo del service que manda a llamar el metodo de getAllItems del Dao
	public String AllItems(String tabla, String token)
	{
		return glpidao.AllItems(tabla, token);
	}
	
	//Metodo del service que manda a llamar el metodo de getAllItems del Dao
	public String AllIEquipos(String tabla, String token)
	{
		return glpidao.AllIEquipos(tabla, token);
	}
	
	//Metodo del service que manda a llamar el metodo de getAnItem del Dao
	public String AnItem(String tabla, String id, String token)
	{
		return glpidao.AnItem(tabla, id, token);
	}
	
	public String AddItem(String body, String tabla, String token) throws IOException {
		// TODO Auto-generated method stub updateItem
		return glpidao.addItem(body, tabla, token);
	}
	
	public String updateItem(String body, String tabla, String id, String token) throws IOException {
		// TODO Auto-generated method stub
		return glpidao.updateItem(body, tabla, id, token);
	}
	
	
	//Método para regresar un usuario
	public String AnUser(String token,String nombre, String apellidos)
	{
		return glpidao.AnUser(token,nombre,apellidos);
	}
	
	//Método para regresar un usuario por medio del nombre del usuario
	public String AnUserForUserName(String token,String username)
	{
		return glpidao.AnUserForUserName(token,username);
	}
	
	public String allSubItems(String id, String tabla, String token) {
		return glpidao.allSubItems(id, tabla, token);
	}
	
	//Método para regresar un item en especifico de una tabla especifica
	public String AnEquipo(String tabla, String id, String token)
	{
		return glpidao.AnEquipo(tabla,id,token);
	}

	
	//Método para regresar un item en especifico de una tabla especifica
	public String AnItemExtends(String tabla, String id, String token)
	{
		return glpidao.AnItemExtends(tabla, id,token);
	}
	
	public String AllOperatingSystems(String token)
	{
		return glpidao.AllOperatingSystems(token);
	}
}

