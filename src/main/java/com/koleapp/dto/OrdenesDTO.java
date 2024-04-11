package com.koleapp.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.koleapp.model.Clientes;
import com.koleapp.model.Empleados;
import com.koleapp.model.EstadoOrden;
import com.koleapp.model.FormaPagoVenta;
import com.koleapp.model.PlatosOrden;
import com.koleapp.model.TipoOrden;

public class OrdenesDTO {
	
	private int idOrden;
	
	
	private FormaPagoVenta formaPago;
		
	
	private Empleados empleado;
	
	
	private String notas;
		
	
	private TipoOrden tipoOrden;
	
	
	private Double precio;
	
	
	private Double servicio;
	
	
	private Double IGV;
	
	
	private Double total;
	
	
	private Clientes cliente;
		
	
	private String clienteMesa;
		
	
	private LocalDateTime horaInicio;
	
		
	private LocalDateTime horaCierre;
	
	private List<PlatosOrden> listaPlatos;
	
	private EstadoOrden estado;

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public FormaPagoVenta getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPagoVenta formaPago) {
		this.formaPago = formaPago;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public TipoOrden getTipoOrden() {
		return tipoOrden;
	}

	public void setTipoOrden(TipoOrden tipoOrden) {
		this.tipoOrden = tipoOrden;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getServicio() {
		return servicio;
	}

	public void setServicio(Double servicio) {
		this.servicio = servicio;
	}

	public Double getIGV() {
		return IGV;
	}

	public void setIGV(Double iGV) {
		IGV = iGV;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public String getClienteMesa() {
		return clienteMesa;
	}

	public void setClienteMesa(String clienteMesa) {
		this.clienteMesa = clienteMesa;
	}

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDateTime getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(LocalDateTime horaCierre) {
		this.horaCierre = horaCierre;
	}

	public List<PlatosOrden> getListaPlatos() {
		return listaPlatos;
	}

	public void setListaPlatos(List<PlatosOrden> listaPlatos) {
		this.listaPlatos = listaPlatos;
	}

	public EstadoOrden getEstado() {
		return estado;
	}

	public void setEstado(EstadoOrden estado) {
		this.estado = estado;
	}
	
	
	
	

}
