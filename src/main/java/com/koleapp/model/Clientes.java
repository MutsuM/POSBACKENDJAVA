package com.koleapp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="clientes")
public class Clientes {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;
	
	@Column(name="nombres",length=100,nullable=false)
	private String nombres;
	
	@Column(name="apellidopat",length=50,nullable=false)
	private String apellidoPat;
	
	@Column(name="apellidomat",length=50,nullable=false)
	private String apellidoMat;
	
	@Column(name="sexo",length=2,nullable=false)
	private String sexo;
	
	@Column(name="telefono",length=20,nullable=false)
	private String telefono;
	
	@Column(name="correo",length=100,nullable=true)
	private String correo;
	
	@Column(name="provincia",length=30,nullable=true)
	private String provincia;
	
	@Column(name="fechanac",length=20,nullable=true)
	private LocalDateTime fechaNac;
		
	@Column(name="dni",length=8,nullable=true)
	private String dni;
	
	@Column(name="direccion",length=160,nullable=true)
	private String direccion;
	
	@Column(name="ciudad",length=50,nullable=true)
	private String ciudad;
	
	@Column(name="codigopostal",length=10,nullable=true)
	private String codigoPostal;
	
	@Column(name="infoclinica",length=3000,nullable=true)
	private String infoClinica;
	
	@Column(name="notas",length=400,nullable=true)
	private String notas;
	
	@Column(name="enviosms",nullable=true)
	private boolean enviosSms;
	
	@Column(name="envioCorreo",nullable=true)
	private boolean envioCorreo;
	
	@Column(name="activo",nullable=true)
	private boolean activo;
		
	public Clientes(int idCliente, String nombres, String apellidoPat, String apellidoMat, String sexo, String telefono,
			String correo, String provincia, LocalDateTime fechaNac, String dni, String direccion, String ciudad,
			String codigoPostal, String infoClinica, String notas, boolean enviosSms, boolean envioCorreo,
			boolean activo) {
		super();
		this.idCliente = idCliente;
		this.nombres = nombres;
		this.apellidoPat = apellidoPat;
		this.apellidoMat = apellidoMat;
		this.sexo = sexo;
		this.telefono = telefono;
		this.correo = correo;
		this.provincia = provincia;
		this.fechaNac = fechaNac;
		this.dni = dni;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.infoClinica = infoClinica;
		this.notas = notas;
		this.enviosSms = enviosSms;
		this.envioCorreo = envioCorreo;
		this.activo = activo;
	}
	

	public Clientes() {
		super();
	}


	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPat() {
		return apellidoPat;
	}

	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	public String getApellidoMat() {
		return apellidoMat;
	}

	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public LocalDateTime getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDateTime fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getInfoClinica() {
		return infoClinica;
	}

	public void setInfoClinica(String infoClinica) {
		this.infoClinica = infoClinica;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public boolean isEnviosSms() {
		return enviosSms;
	}

	public void setEnviosSms(boolean enviosSms) {
		this.enviosSms = enviosSms;
	}

	public boolean isEnvioCorreo() {
		return envioCorreo;
	}

	public void setEnvioCorreo(boolean envioCorreo) {
		this.envioCorreo = envioCorreo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
	
	

}
