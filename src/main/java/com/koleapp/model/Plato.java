package com.koleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="platos")
public class Plato {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPlato;
	

	@Column(name="nombre", nullable = false)
	private String nombre;
	
	@Column(name="detalle", nullable = false)
	private String detalle;
	
	@Column(name="costo", nullable = true)
	private Double costo;
	
	@Column(name="precio", nullable = false)
	private Double precio;
	
	@Column(name="imagen", nullable = true)
	private String imagen;
	
	@Column(name="activo", nullable = false)
	private Boolean activo;
		
	
	@OneToOne
	@JoinColumn(name="id_categoria",nullable=false) //setear nullable a false
	private Categoria categoria;
	
	//1=SIMPLE, 2=COMPUESTO
	@Column(name="tipo_plato", nullable = true)
	private int tipoPlato;
	


	public int getIdPlato() {
		return idPlato;
	}


	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public Double getCosto() {
		return costo;
	}


	public void setCosto(Double costo) {
		this.costo = costo;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public int getTipoPlato() {
		return tipoPlato;
	}


	public void setTipoPlato(int tipoPlato) {
		this.tipoPlato = tipoPlato;
	}
	
	
	
	

}
