package com.koleapp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name="caja")
public class Caja {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcaja")
	private int idCaja;
	
	@Column(name="ingresoventas",nullable=true)
	private double ingresoVentas;
	
	//monto con el que se apertura la caja
	@Column(name="cajainicial",nullable=true)
	private double cajainicial;
	
	//todos los ingresos en efectivo a la caja
	@Column(name="ingresonoventas",nullable=true)
	private double ingresosNoventas;
	
	//total de extracciones de la caja
	@Column(name="extracciones",nullable=true)
	private double extracciones;
	
	//monto descuadrado de la caja
	@Column(name="descuadre",nullable=true)
	private double descuadre;
	
	//valor de la caja al cierre
	@Column(name="caja",nullable=true)
	private double cajacierre;
		
	//fecha en la que se hace el cierre de la caja
	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name="fechaapertura",nullable=true)
	private LocalDateTime fechaApertura;
	
	
	//fecha en la que se hace el cierre de la caja
	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name="fechacierre",nullable=true)
	private LocalDateTime fechaCierre;

	//estado de la caja, si está abierta o cerrada, true=abierta, false=cerrada
	@Column(name="estado", nullable=true)
	private Boolean estado;
	
	//valor de inicio de la siguiente caja a aperturar
	@Column(name="proximacaja",nullable=true)
	private double proximacaja;
	
	
	@Transient//permite que la variable no sea tomada en cuenta por la persistencia
	private int idEmpleado;
	
	

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdCaja() {
		return idCaja;
	}

	public void setIdCaja(int idCaja) {
		this.idCaja = idCaja;
	}

	public double getIngresoVentas() {
		return ingresoVentas;
	}

	public void setIngresoVentas(double ingresoVentas) {
		this.ingresoVentas = ingresoVentas;
	}

	public double getCajainicial() {
		return cajainicial;
	}

	public void setCajainicial(double cajainicial) {
		this.cajainicial = cajainicial;
	}

	public double getIngresosNoventas() {
		return ingresosNoventas;
	}

	public void setIngresosNoventas(double ingresosNoventas) {
		this.ingresosNoventas = ingresosNoventas;
	}

	public double getExtracciones() {
		return extracciones;
	}

	public void setExtracciones(double extracciones) {
		this.extracciones = extracciones;
	}

	public double getDescuadre() {
		return descuadre;
	}

	public void setDescuadre(double descuadre) {
		this.descuadre = descuadre;
	}

	public double getCajacierre() {
		return cajacierre;
	}

	public void setCajacierre(double cajacierre) {
		this.cajacierre = cajacierre;
	}

	public LocalDateTime getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(LocalDateTime fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public LocalDateTime getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(LocalDateTime fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public double getProximacaja() {
		return proximacaja;
	}

	public void setProximacaja(double proximacaja) {
		this.proximacaja = proximacaja;
	}
	
	

	
	
}
