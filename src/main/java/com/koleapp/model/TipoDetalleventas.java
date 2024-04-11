package com.koleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipodetalleventas")
public class TipoDetalleventas {
	
	@Id
	@Column(name="idtipodetalleventa")
	private int idTipoDetalleventas;

	@Column(name="nombre",nullable=false)
	private String nombre;
	public int getIdTipoDetalleventas() {
		return idTipoDetalleventas;
	}
	public void setIdTipoDetalleventas(int idTipoDetalleventas) {
		this.idTipoDetalleventas = idTipoDetalleventas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}