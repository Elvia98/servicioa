package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.Mantenimiento;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.Mantenimiento.Registro_mantenimientoDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.Mantenimiento.Registro_mantenimiento;

@Service
public class Registro_mantenimientoImpService implements Registro_mantenimientoService{
	@Autowired
	private Registro_mantenimientoDao registro_mantenimientoDao;
	

		
	
	@Override
	@Transactional(readOnly = true)
	public List<Registro_mantenimiento> findByIdAdministradorStatusRealizado(Integer administrador_TI) {
		return registro_mantenimientoDao.findByIdAdministradorStatusRealizado(administrador_TI);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Registro_mantenimiento> findByStatusEspera() 
	{
		return registro_mantenimientoDao.findByStatusEspera();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Registro_mantenimiento> findByStatusRealizado() 
	{
		return registro_mantenimientoDao.findByStatusRealizado();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Registro_mantenimiento> findByStatusCancelado() 
	{
		return registro_mantenimientoDao.findByStatusCancelado();
	}

	@Override
	@Transactional(readOnly = true)
	public Registro_mantenimiento findLastByIdAdministrador(Integer administrador_TI) 
	{
		return registro_mantenimientoDao.findLastByIdAdministrador(administrador_TI);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Registro_mantenimiento findByIdRegistro_mantenimiento(Integer id_registro_mantenimiento) 
	{
		return registro_mantenimientoDao.findBy_IdRegistroMant(id_registro_mantenimiento);
	}

	@Override
	@Transactional(readOnly = true)
	public Registro_mantenimiento find_Ultimo_Registro_Realizado() 
	{
		return registro_mantenimientoDao.find_Ultimo_Registro_Realizado();
	}
	
	
	
	
	
	@Override
	@Transactional
	public String addRegistroMantenimiento(Registro_mantenimiento registro_mantenimiento) {
		registro_mantenimientoDao.save(registro_mantenimiento);
		return "Registro guardado";
	}

	@Override
	@Transactional
	public String updateRegistroMantenimiento(Registro_mantenimiento registro_mantenimiento) {
		registro_mantenimientoDao.save(registro_mantenimiento);
		return "Registro actualizado";
	}
}
