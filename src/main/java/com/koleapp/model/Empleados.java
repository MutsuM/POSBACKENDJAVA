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
@Table(name="empleados")
public class Empleados {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmpleado;
	
	@Column(name="nombres",length=100,nullable=false)
	private String nombres;
	
	@Column(name="apellidos",length=100,nullable=false)
	private String apellidos;
	
	@Column(name="email",length=100,nullable=false)
	private String email;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="color",length=100,nullable=true)
	private String colorCitas;
	
	@Column(name="activo",nullable=true)
	private boolean activo;
	
	@Column(name="agenda",nullable=true)
	private boolean agenda;
	
	@Column(name="recibiremail",nullable=true)
	private boolean recibirEmail;
	
	@OneToOne
	@JoinColumn(name="id_rol",nullable=false)
	private Rol roles;
	
		

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Rol getRoles() {
		return roles;
	}

	public void setRoles(Rol roles) {
		this.roles = roles;
	}

	public String getColorCitas() {
		return colorCitas;
	}

	public void setColorCitas(String colorCitas) {
		this.colorCitas = colorCitas;
	}

	public boolean isAgenda() {
		return agenda;
	}

	public void setAgenda(boolean agenda) {
		this.agenda = agenda;
	}

	public boolean isRecibirEmail() {
		return recibirEmail;
	}

	public void setRecibirEmail(boolean recibirEmail) {
		this.recibirEmail = recibirEmail;
	}
	
	
}
