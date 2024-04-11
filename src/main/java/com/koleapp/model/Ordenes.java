package com.koleapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "ordenes")
public class Ordenes extends BaseEntity implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int idOrden;
		
	//lista de uno a muchos, platos por orden
	@OneToOne
	@JoinColumn(name="id_formapago",nullable=false) //setear nullable a false
	private FormaPagoVenta formaPago;

	@OneToOne
	@JoinColumn(name="id_empleado",nullable=false) //setear nullable a false
	private Empleados empleado;
	
	@Column(name="notas",length=100,nullable=true)
	private String notas;
		
	@OneToOne
	@JoinColumn(name="id_tipoorden",nullable=false) //setear nullable a false
	private TipoOrden tipoOrden;
	
	@Column(name="precio",length=100,nullable=true)
	private Double precio;
	
	@Column(name="servicio",length=100,nullable=true)
	private Double servicio;
	
	@Column(name="igv",length=100,nullable=true)
	private Double igv;
	
	@Column(name="total",length=100,nullable=true)
	private Double total;
	
	@OneToOne
	@JoinColumn(name="id_cliente",nullable=false) //setear nullable a false
	private Clientes cliente;
	
	@OneToOne
	@JoinColumn(name="estado",nullable=true) //setear nullable a false
	private EstadoOrden estado;
		
	//campo usado para negocios que no tienen mesa registrada y sacan los platos por nombre de cliente
	@Column(name="clientemesa",length=100,nullable=true)
	private String clienteMesa;
		
	@Column(name="hora_inicio",length=100,nullable=true)
	private LocalDateTime horaInicio;
	
	@Column(name="hora_fin",length=100,nullable=true)
	private LocalDateTime horaCierre;
	
	

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public FormaPagoVenta getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPagoVenta formaPago) {
		this.formaPago = formaPago;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public TipoOrden getTipoOrden() {
		return tipoOrden;
	}

	public void setTipoOrden(TipoOrden tipoOrden) {
		this.tipoOrden = tipoOrden;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getServicio() {
		return servicio;
	}

	public void setServicio(Double servicio) {
		this.servicio = servicio;
	}

	
	public Double getIgv() {
		return igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getClienteMesa() {
		return clienteMesa;
	}

	public void setClienteMesa(String clienteMesa) {
		this.clienteMesa = clienteMesa;
	}

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDateTime getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(LocalDateTime horaCierre) {
		this.horaCierre = horaCierre;
	}

	public EstadoOrden getEstado() {
		return estado;
	}

	public void setEstado(EstadoOrden estado) {
		this.estado = estado;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
