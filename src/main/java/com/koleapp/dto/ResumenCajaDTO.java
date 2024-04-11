package com.koleapp.dto;

public class ResumenCajaDTO {
	
	private int idcaja;
	private double ventasefectivo;
	private double ingresoscaja;
	private double cajainicial;
	private double egresos;
	private double caja;
	private double descuadre;
	private double proximacaja;
	
		public double getCaja() {
		return caja;
	}
	public void setCaja(double caja) {
		this.caja = caja;
	}
	public double getDescuadre() {
		return descuadre;
	}
	public void setDescuadre(double descuadre) {
		this.descuadre = descuadre;
	}
	public double getProximacaja() {
		return proximacaja;
	}
	public void setProximacaja(double proximacaja) {
		this.proximacaja = proximacaja;
	}
	public int getIdcaja() {
		return idcaja;
	}
	public void setIdcaja(int idcaja) {
		this.idcaja = idcaja;
	}
	public double getVentasefectivo() {
		return ventasefectivo;
	}
	public void setVentasefectivo(double ventasefectivo) {
		this.ventasefectivo = ventasefectivo;
	}
	public double getIngresoscaja() {
		return ingresoscaja;
	}
	public void setIngresoscaja(double ingresoscaja) {
		this.ingresoscaja = ingresoscaja;
	}
	public double getCajainicial() {
		return cajainicial;
	}
	public void setCajainicial(double cajainicial) {
		this.cajainicial = cajainicial;
	}
	public double getEgresos() {
		return egresos;
	}
	public void setEgresos(double egresos) {
		this.egresos = egresos;
	}	
}