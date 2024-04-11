package com.koleapp.service;

import java.util.List;

import com.koleapp.dto.CriteriosConsultaVentasDTO;
import com.koleapp.model.DetalleVentas;
import com.koleapp.model.Ventas;

public interface IVentaService {

	Ventas registrar(Ventas ventas);

	void modificar(Ventas entas);

	void eliminar(int idVenta);

	Ventas listarId(int idVenta);

	List<Ventas> listar();
	
	List<Ventas> listarCriterio(CriteriosConsultaVentasDTO criterio);
	
	List<DetalleVentas> listarDetalle(Integer idVenta);
	
	byte[] generarReporte(Integer idVenta);
}
