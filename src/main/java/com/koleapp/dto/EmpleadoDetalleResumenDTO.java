package com.koleapp.dto;

import java.util.List;

public class EmpleadoDetalleResumenDTO {
	
	private List<EmpleadoDetalleDTO> listaEmpleadoDetalle;
	private String totalServicios;
	private String totalProductos;
	private String totalAPagar;
	public List<EmpleadoDetalleDTO> getListaEmpleadoDetalle() {
		return listaEmpleadoDetalle;
	}
	public void setListaEmpleadoDetalle(List<EmpleadoDetalleDTO> listaEmpleadoDetalle) {
		this.listaEmpleadoDetalle = listaEmpleadoDetalle;
	}
	public String getTotalServicios() {
		return totalServicios;
	}
	public void setTotalServicios(String totalServicios) {
		this.totalServicios = totalServicios;
	}
	public String getTotalProductos() {
		return totalProductos;
	}
	public void setTotalProductos(String totalProductos) {
		this.totalProductos = totalProductos;
	}
	public String getTotalAPagar() {
		return totalAPagar;
	}
	public void setTotalAPagar(String totalAPagar) {
		this.totalAPagar = totalAPagar;
	}
	
	

}
