package com.koleapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koleapp.dao.IDetalleVentasDAO;
import com.koleapp.dao.IServiciosDAO;
import com.koleapp.model.DetalleVentas;
import com.koleapp.model.Servicios;
import com.koleapp.model.Ventas;
import com.koleapp.service.IServicioService;

@Service
public class IServiciosServiceImpl implements IServicioService {

	@Autowired
	private IServiciosDAO dao;
	
	@Autowired
	private IDetalleVentasDAO detalleDao;
	
	
	
	
	
	
	
	
	@Override
	public void registrar(Servicios servicio) {
		// TODO Auto-generated method stub		
		dao.save(servicio);		
	}

	@Override
	public void modificar(Servicios  servicio) {
		// TODO Auto-generated method stub
		dao.save(servicio);
	}

	
	@Override
	public Integer eliminar(int idServicio) {
		
		//1. METODO PARA VALIDAR SI EL SERVICIO NO TIENE RELACIÓN ALGUNA CON UNA VENTA		
		List<DetalleVentas> lista = this.detalleDao.findServioceBeforeDelete(idServicio);
		if(lista.isEmpty()) {
			dao.deleteById(idServicio);
			return 1;
		}
		else {
			return 0;
		}
							
	}

	@Override
	public Servicios listarId(int idServicio) {
		// TODO Auto-generated method stub
		//return dao.findOne(idServicio);
		Optional<Servicios> opt = dao.findById(idServicio);
		return opt.isPresent() ? opt.get() : new Servicios();	
	}

	@Override
	public List<Servicios> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	
	
}
