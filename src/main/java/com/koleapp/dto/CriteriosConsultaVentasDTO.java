package com.koleapp.dto;

import java.io.Serializable;

public class CriteriosConsultaVentasDTO implements Serializable {
	

	private Integer numeroTicket = null;
	private String nombreCliente = null;
	private String apellidoMatCliente = null;
	private String apellidoPatCliente = null;
	private Integer idEmpleado = null;
	private String fechaDesde = null;
	private String fechaHasta = null;
	
	
	
	
	
	
	public CriteriosConsultaVentasDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getNumeroTicket() {
		return numeroTicket;
	}
	public void setNumeroTicket(Integer numeroTicket) {
		this.numeroTicket = numeroTicket;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoMatCliente() {
		return apellidoMatCliente;
	}
	public void setApellidoMatCliente(String apellidoMatCliente) {
		this.apellidoMatCliente = apellidoMatCliente;
	}
	public String getApellidoPatCliente() {
		return apellidoPatCliente;
	}
	public void setApellidoPatCliente(String apellidoPatCliente) {
		this.apellidoPatCliente = apellidoPatCliente;
	}
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
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
	
	
	

}
