package com.koleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipoorden")
public class TipoOrden {

	/*
	 1 = mesa
	 2 = delivery
	 3 = llevar
	 * */
	
	@Id
	@Column(name="id")
	private int idTipoOrden;

	@Column(name="nombre",nullable=false)
	private String nombre;
	

	@Column(name="activo",nullable=false)
	private Boolean activo;


	public int getIdTipoOrden() {
		return idTipoOrden;
	}


	public void setIdTipoOrden(int idTipoOrden) {
		this.idTipoOrden = idTipoOrden;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	

	
	
}
