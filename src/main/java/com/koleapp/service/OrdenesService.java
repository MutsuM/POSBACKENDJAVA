package com.koleapp.service;

import java.util.List;

import com.koleapp.dto.OrdenesDTO;
import com.koleapp.model.Ordenes;

public interface OrdenesService {

	Ordenes registrar(OrdenesDTO orden) throws Exception;
	Ordenes actualizar(OrdenesDTO orden) throws Exception;
	void actualizarEstado(OrdenesDTO orden) throws Exception;
	List<Ordenes> listarOrdenes() throws Exception;
	Ordenes listById(int idOrden) throws Exception;
	byte[] generarReporte(int idOrden);
	
}
