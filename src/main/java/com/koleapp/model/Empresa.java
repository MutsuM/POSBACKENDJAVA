package com.koleapp.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="empresa")
public class Empresa {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmpresa;
		
	@Column(name="rsocial",length=100,nullable=true)
	private String rsocial;
	
	@Column(name="ruc",length=100,nullable=true)
	private String ruc;
	
	@Column(name="email",length=100,nullable=true)
	private String email;
	
	//logotipo de la empresa
	@Column(name="logo",nullable=true)
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] logo;
	
	@Column(name="direccion",length=100,nullable=true)
	private String direccion;
	
	@Column(name="telefono",length=100,nullable=true)
	private String telefono;
	
	@Column(name="persona_contacto",length=100,nullable=true)
	private String personaContacto;
	
	//nombre de la imagen guardada
	@Column(name="nombre_imagen",nullable=true)
	private String nombreImagen;
	
	//tipo de imagen guardada
	@Column(name="type",nullable=true)
	private String type;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Sucursal> detalleSucursal;

	

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getRsocial() {
		return rsocial;
	}

	public void setRsocial(String rsocial) {
		this.rsocial = rsocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPersonaContacto() {
		return personaContacto;
	}

	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Sucursal> getDetalleSucursal() {
		return detalleSucursal;
	}

	public void setDetalleSucursal(List<Sucursal> detalleSucursal) {
		this.detalleSucursal = detalleSucursal;
	}
	
	
}
