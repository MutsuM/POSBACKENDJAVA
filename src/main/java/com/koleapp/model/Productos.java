package com.koleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Productos {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProductos;
		
	@Column(name="codigobarras",nullable=true)
	private double codigoBarras;
	
	@Column(name="referencia",length=80,nullable=true)
	private String referencia;
	
	@Column(name="descripcion",length=500,nullable=false)
	private String descripcion;
	
	@Column(name="stock",nullable=false)
	private int stock;
	
	@Column(name="pedidominimo",nullable=true)
	private double pedidoMinimo;
	
	@Column(name="stockminimo",nullable=true)
	private double stockMinimo;
	
	@Column(name="precioventa",nullable=false)
	private double precioventa;
	
	@Column(name="preciocosto",nullable=false)
	private double preciocosto;
	
	@Column(name="disponibleVenta",nullable=false)
	private boolean disponibleVenta;
	
	@Column(name="activo",nullable=false)
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="id_categoria",nullable=false)	
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="id_proveedor",nullable=false)
	private Proveedor proveedores;

	public int getIdProductos() {
		return idProductos;
	}

	public void setIdProductos(int idProductos) {
		this.idProductos = idProductos;
	}

	public double getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(double codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPedidoMinimo() {
		return pedidoMinimo;
	}

	public void setPedidoMinimo(double pedidoMinimo) {
		this.pedidoMinimo = pedidoMinimo;
	}

	public double getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(double stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public double getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(double precioventa) {
		this.precioventa = precioventa;
	}

	public double getPreciocosto() {
		return preciocosto;
	}

	public void setPreciocosto(double preciocosto) {
		this.preciocosto = preciocosto;
	}

	public boolean isDisponibleVenta() {
		return disponibleVenta;
	}

	public void setDisponibleVenta(boolean disponibleVenta) {
		this.disponibleVenta = disponibleVenta;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Proveedor getProveedores() {
		return proveedores;
	}

	public void setProveedores(Proveedor proveedores) {
		this.proveedores = proveedores;
	}

	public Productos() {
		super();
	}

	
	
	
	
}
