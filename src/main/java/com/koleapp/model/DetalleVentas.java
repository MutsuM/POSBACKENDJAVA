package com.koleapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="detalleventas")
public class DetalleVentas implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDetalleventa;
	
	@Column(name="cantidad", nullable = false)
	private int cantidad;
	
	@Column(name="descuento", nullable = false)
	private double descuento;
	
	@Column(name="impuesto", nullable = false)
	private double impuesto;
	
	@Column(name="precioventa", nullable = false)
	private double precioventa;
	
	@Column(name="importe", nullable = false)
	private double importe;
	
	@Column(name="subtotal", nullable = true)
	private double subtotal;
	
	@Column(name="id_item",nullable=false)//setear nullable a false
	private int idItem;	
	
	@OneToOne
	@JoinColumn(name="id_tipodetalleventa",nullable=false) //setear nullable a false
	private TipoDetalleventas tipoItem;
	
	
	//@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "id_venta", nullable = false)	
	@JsonIgnore
	private Ventas ventas;
		
	//empleado que realiza este item de venta
	@OneToOne
	@JoinColumn(name="id_empleado", nullable = false)
	private Empleados empleado;
	
	private String descripcion;
	
	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdDetalleventa() {
		return idDetalleventa;
	}

	public void setIdDetalleventa(int idDetalleventa) {
		this.idDetalleventa = idDetalleventa;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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

	public double getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(double precioventa) {
		this.precioventa = precioventa;
	}

	public Ventas getVenta() {
		return ventas;
	}

	public void setVenta(Ventas venta) {
		this.ventas = venta;
	}
	
	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	
	@JsonIgnore
	public Ventas getVentas() {
		return ventas;
	}
	
	@JsonProperty
	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}

	public TipoDetalleventas getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoDetalleventas tipoItem) {
		this.tipoItem = tipoItem;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
}