package com.koleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plato_complemento")
public class PlatoComplemento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="id_plato", nullable = true)
	private int id_plato;
	
	@Column(name="id_complemento", nullable = true)
	private int id_complemento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_plato() {
		return id_plato;
	}

	public void setId_plato(int id_plato) {
		this.id_plato = id_plato;
	}

	public int getId_complemento() {
		return id_complemento;
	}

	public void setId_complemento(int id_complemento) {
		this.id_complemento = id_complemento;
	}
	
	
	
	
	
	
	

}
