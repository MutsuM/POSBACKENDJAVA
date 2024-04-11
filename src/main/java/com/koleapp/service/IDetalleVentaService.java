package com.koleapp.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.koleapp.model.DetalleVentas;


public interface IDetalleVentaService {

	
	List<DetalleVentas> listarDetalle(Integer idVenta);
	
	void eliminarDetallesVenta(Integer idVenta); 
	
	 
	
}
