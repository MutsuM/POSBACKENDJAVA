package com.koleapp.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.koleapp.model.Empleados;
import com.koleapp.model.TipoDetalleventas;
import com.koleapp.model.Ventas;


public class DetalleVentasDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private int idDetalleventa;	
	private int cantidad;	
	private double descuento;	
	private double impuesto;	
	private double precioventa;	
	private double importe;	
	private int idItem;		
	private TipoDetalleventas tipoItem;	
	private Ventas ventas;				
	private Empleados empleado;
	
	
	
}