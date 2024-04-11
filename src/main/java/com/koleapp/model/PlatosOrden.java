package com.koleapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "platos_orden")
public class PlatosOrden extends BaseEntity implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	@Column(name="id_orden",length=100,nullable=true)
	private int idOrden;
	
	@Column(name="id_plato",length=100,nullable=true)
	private int idPlato;
	
	
	//Se guardaran solo los complementos que se han utilizado
	@Column(name="complementos",length=100,nullable=true)
	private String complementos;
	
	//Se guardaran solo los complementos que se han utilizado
	@Column(name="notas",length=100,nullable=true)
	private String notas;
	
	@Column(name="cantidad",length=100,nullable=true)
	private int cantidad;
	
	@Column(name="precio",length=100,nullable=true)
	private Double precio;
	
	@Column(name="igv",length=100,nullable=true)
	private Double igv;
	
	@Column(name="total",length=100,nullable=true)
	private Double total;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getComplementos() {
		return complementos;
	}

	public void setComplementos(String complementos) {
		this.complementos = complementos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	

	public Double getIgv() {
		return igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}
	
}