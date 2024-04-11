package com.koleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="formapagoventa")
public class FormaPagoVenta {
	
	@Id	
	private int idFormapagoventa;
	
	@Column(name="descripcion",nullable=false,length=80)
	private String descripcion;

	public int getIdFormapagoventa() {
		return idFormapagoventa;
	}

	public void setIdFormapagoventa(int idFormapagoventa) {
		this.idFormapagoventa = idFormapagoventa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	

}
