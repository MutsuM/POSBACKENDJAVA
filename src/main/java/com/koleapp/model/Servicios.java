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
@Table(name="servicios")
public class Servicios {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idServicios;
	
	@Column(name="referencia",length=30,nullable=true)
	private String referencia;
	
	@Column(name="descripcion",length=120,nullable=false)
	private String descripcion;
	
	@Column(name="precio",nullable=false)
	private double precio;
	
	@Column(name="duracion",nullable=true)
	private int duracion;
	
	@Column(name="activo",nullable=false)
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="id_categoria",nullable=false)
	private Categoria categoria;

	

	
	public int getIdServicios() {
		return idServicios;
	}

	public void setIdServicios(int idServicios) {
		this.idServicios = idServicios;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
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
}