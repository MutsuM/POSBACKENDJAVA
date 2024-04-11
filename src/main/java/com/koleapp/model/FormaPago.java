package com.koleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="formapago")
public class FormaPago {
	
	
	@Id		
	private int idFormapago;
	
	@Column(name="tipo",nullable=false,length=100)
	private String tipo;

	public int getIdFormapago() {
		return idFormapago;
	}

	public void setIdFormapago(int idFormapago) {
		this.idFormapago = idFormapago;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}