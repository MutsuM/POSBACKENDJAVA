package com.koleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipomovimiento")
public class TipoMovimiento {
	
	
	@Id
	@Column(name="idtipomovimiento")	
	private int idTipomov;
	
	@Column(name="descripcion",nullable=false)
	private String decripcion;

	public int getIdTipomov() {
		return idTipomov;
	}

	public void setIdTipomov(int idTipomov) {
		this.idTipomov = idTipomov;
	}

	public String getDecripcion() {
		return decripcion;
	}

	public void setDecripcion(String decripcion) {
		this.decripcion = decripcion;
	}
	
	
	

}
