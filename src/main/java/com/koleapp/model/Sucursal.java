package com.koleapp.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="sucursal")
public class Sucursal {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSucursal;
		
	@Column(name="rsocial",length=100,nullable=false)
	private String nombre;
	
	
	@Column(name="email",length=100,nullable=false)
	private String email;
	
	
	@Column(name="direccion",length=100,nullable=false)
	private String direccion;
	
	//@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_empresa", nullable = false)	
	//@JsonIgnore
	private Empresa empresa;
	

	public Sucursal() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdSucursal() {
		return idSucursal;
	}


	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	

}
