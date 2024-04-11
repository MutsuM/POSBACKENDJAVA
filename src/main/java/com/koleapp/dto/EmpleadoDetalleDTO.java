package com.koleapp.dto;

import java.io.Serializable;

public class EmpleadoDetalleDTO implements Serializable {

	
	private String fecha;
	private String elemento;
	private String porcentaje;
	private String valorVenta;
	private String valorAPagar;		
	private String tipoElemento;
	
	

	private static final long serialVersionUID = 1L;



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public String getElemento() {
		return elemento;
	}



	public void setElemento(String elemento) {
		this.elemento = elemento;
	}



	public String getPorcentaje() {
		return porcentaje;
	}



	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}



	public String getValorVenta() {
		return valorVenta;
	}



	public void setValorVenta(String valorVenta) {
		this.valorVenta = valorVenta;
	}



	public String getValorAPagar() {
		return valorAPagar;
	}



	public void setValorAPagar(String valorAPagar) {
		this.valorAPagar = valorAPagar;
	}



	public String getTipoElemento() {
		return tipoElemento;
	}



	public void setTipoElemento(String tipoElemento) {
		this.tipoElemento = tipoElemento;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
