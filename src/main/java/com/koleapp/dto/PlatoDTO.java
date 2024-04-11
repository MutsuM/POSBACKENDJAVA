package com.koleapp.dto;

import com.koleapp.model.Categoria;

public class PlatoDTO {

	

	private int idPlato;
	


	private String nombre;
	

	private String detalle;
	

	private Double costo;
	

	private Double precio;
	

	private String imagen;
	

	private Boolean activo;
		
	

	private Categoria categoria;
	
	private int[] complementos;
	
	//1=SIMPLE, 2=COMPUESTO
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

	public int[] getComplementos() {
		return complementos;
	}

	public void setComplementos(int[] complementos) {
		this.complementos = complementos;
	}

	public int getTipoPlato() {
		return tipoPlato;
	}

	public void setTipoPlato(int tipoPlato) {
		this.tipoPlato = tipoPlato;
	}
	
	
	
	
	
}
