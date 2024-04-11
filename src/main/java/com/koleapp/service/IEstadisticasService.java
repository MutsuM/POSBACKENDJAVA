package com.koleapp.service;

import java.util.List;

import com.koleapp.dto.EmpleadoDetalleResumenDTO;
import com.koleapp.dto.EstadisticasDTO;




public interface IEstadisticasService {	
	List<EstadisticasDTO> listarVentas(EstadisticasDTO param);
	List<EstadisticasDTO> listarVentasResumen(EstadisticasDTO param);
	public List<EstadisticasDTO> listarVentasEmpleados(EstadisticasDTO param);
	public List<EstadisticasDTO> listarProductosEmpleados(EstadisticasDTO param);
	public List<EstadisticasDTO> listarServiciosEmpleados(EstadisticasDTO param);	
	EmpleadoDetalleResumenDTO listaDetalleEmpleado(EstadisticasDTO param);
}