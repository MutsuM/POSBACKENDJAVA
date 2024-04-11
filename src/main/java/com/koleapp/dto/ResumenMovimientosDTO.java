package com.koleapp.dto;

public class ResumenMovimientosDTO {
	
	private Integer idVenta;
	private String detalledescripcion;
	private String cliente;
	private String empleado;
	private String fecha;
	private String tipomovimiento;
	private String importe;
	private String formapago;
	
	public Integer getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	public String getDetalledescripcion() {
		return detalledescripcion;
	}
	public void setDetalledescripcion(String detalledescripcion) {
		this.detalledescripcion = detalledescripcion;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getEmpleado() {
		return empleado;
	}
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTipomovimiento() {
		return tipomovimiento;
	}
	public void setTipomovimiento(String tipomovimiento) {
		this.tipomovimiento = tipomovimiento;
	}
	
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public String getFormapago() {
		return formapago;
	}
	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}
	
	
	

}
