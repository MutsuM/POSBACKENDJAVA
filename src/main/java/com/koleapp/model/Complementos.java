package com.koleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="complementos")
public class Complementos {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComplemento;
	
	@Column(name="nombres",length=100,nullable=false)
	private String nombre;
	
	@Column(name="activo",length=50,nullable=false)
	private Boolean activo;

	public int getIdComplemento() {
		return idComplemento;
	}

	public void setIdComplemento(int idComplemento) {
		this.idComplemento = idComplemento;
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
