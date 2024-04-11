package com.koleapp.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.koleapp.exception.ModeloNotFoundException;
import com.koleapp.model.Categoria;
import com.koleapp.model.Especialidad;
import com.koleapp.model.Proveedor;
import com.koleapp.service.ICategoriaService;
import com.koleapp.service.IProveedorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

	@Autowired
	private IProveedorService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Proveedor>> listar() {
		List<Proveedor> proveedores = new ArrayList<>();
		proveedores = service.listar();
		return new ResponseEntity<List<Proveedor>>(proveedores, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proveedor> listarId(@PathVariable("id") Integer id) {
		Proveedor proveedor = new Proveedor();
		proveedor = service.listarId(id);
		if (proveedor == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
	}	
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proveedor> registrar(@RequestBody Proveedor proveedor){
		this.service.registrar(proveedor);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(proveedor.getIdProveedor()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	
	
	
	
	
			
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proveedor> actualizar(@RequestBody Proveedor proveedor) {
		service.modificar(proveedor);
		return new ResponseEntity<Proveedor>(HttpStatus.OK);
	}
	
}