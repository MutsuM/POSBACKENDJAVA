package com.koleapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name="ventas")
public class Ventas implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVenta;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name="fecha",nullable=false)
	private LocalDateTime fecha;
	
	@Column(name="descuento",nullable=false)
	private double descuento;
	
	@Column(name="impuesto",nullable=false)
	private double impuesto;
	
	@Column(name="subtotal", nullable = true)
	private double subtotal;
	
	@Column(name="total",nullable=false)
	private double total;
	
	@Column(name="notas",nullable=true)
	private String notas;
	
	@OneToOne
	@JoinColumn(name="id_cliente",nullable=false)
	private Clientes cliente;
	
	@OneToOne
	@JoinColumn(name="id_pagoventa",nullable=false)
	private FormaPagoVenta pagoVenta;
	
	//empleado que registra la venta
	@OneToOne
	@JoinColumn(name="id_empleado",nullable=false)
	private Empleados empleado;
	
	//@JsonBackReference va de la mano con @JsonManagedReference
	@JsonIgnore//ignoro el elemento al listar, esta propiedad se tiene que incluir en el metodo get, para no permitir la recursividad y se añade @JsonProperty al metodo set para permitir el insert	
	@OneToMany(mappedBy = "ventas", cascade = CascadeType.ALL, fetch = FetchType.EAGER)	
	private List<DetalleVentas> detalleVenta;

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public FormaPagoVenta getPagoVenta() {
		return pagoVenta;
	}

	public void setPagoVenta(FormaPagoVenta pagoVenta) {
		this.pagoVenta = pagoVenta;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}
	
	@JsonIgnore
	public List<DetalleVentas> getDetalleVenta() {
		return detalleVenta;
	}
	
	@JsonProperty
	public void setDetalleVenta(List<DetalleVentas> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
}
