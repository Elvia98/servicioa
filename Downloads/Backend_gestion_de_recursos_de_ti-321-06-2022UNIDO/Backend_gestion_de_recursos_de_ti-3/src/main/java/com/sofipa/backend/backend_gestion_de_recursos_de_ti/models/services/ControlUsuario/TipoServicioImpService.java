package com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.services.ControlUsuario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.dao.ControlUsuario.TipoServicioDao;
import com.sofipa.backend.backend_gestion_de_recursos_de_ti.models.entity.ControlUsuarios.Tipo_servicio;

@Service
public class TipoServicioImpService implements TipoServicioService{

	@Autowired 
	private TipoServicioDao tiposerviciodao;

	
	@Override
	@Transactional(readOnly = true)
	public List<Tipo_servicio> findByTodosLosServicios() {
		return tiposerviciodao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Tipo_servicio findByIdTipo(Integer id_tipo_servicio) {
		return tiposerviciodao.findByIdTipo(id_tipo_servicio);
	}

	@Override
	@Transactional
	public String addTipo(Tipo_servicio Tipo_servicio) {
		tiposerviciodao.save(Tipo_servicio);
		return "Registro guardado";
	}

	@Override
	@Transactional
	public String updateTipo(Tipo_servicio Tipo_servicio) {
		tiposerviciodao.save(Tipo_servicio);
		return "Registro actualizado";
	}

}
