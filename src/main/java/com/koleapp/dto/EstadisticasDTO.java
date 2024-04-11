package com.koleapp.dto;

import java.io.Serializable;

public class EstadisticasDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String mes=null;
	private Double total=null;
	private Integer orden=null;
	private String fechaDesde = null;
	private String fechaHasta = null;
	private String descripcion;
	private Integer idEmpleado=null;
	private String nombresEmpleado=null;	
	private Integer año=null;
	private Integer indiceMes=null;
	private Integer cantidad=null;
	private Double precioCosto=null;
	
	
		
	
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecioCosto() {
		return precioCosto;
	}
	public void setPrecioCosto(Double precioCosto) {
		this.precioCosto = precioCosto;
	}
	public Integer getAño() {
		return año;
	}
	public void setAño(Integer año) {
		this.año = año;
	}
	public Integer getIndiceMes() {
		return indiceMes;
	}
	public void setIndiceMes(Integer indiceMes) {
		this.indiceMes = indiceMes;
	}
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombresEmpleado() {
		return nombresEmpleado;
	}
	public void setNombresEmpleado(String nombresEmpleado) {
		this.nombresEmpleado = nombresEmpleado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public String getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	
	
	
	

}
