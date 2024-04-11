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
import com.koleapp.model.Clientes;
import com.koleapp.model.Especialidad;
import com.koleapp.model.Proveedor;
import com.koleapp.service.ICategoriaService;
import com.koleapp.service.IClienteService;
import com.koleapp.service.IProveedorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Clientes>> listar() {
		List<Clientes> clientes = new ArrayList<>();
		clientes = service.listar();
		return new ResponseEntity<List<Clientes>>(clientes, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Clientes> listarId(@PathVariable("id") Integer id) {
		
		Clientes cliente= new Clientes();
		cliente = service.listarId(id);
		if (cliente == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Clientes>(cliente, HttpStatus.OK);
	}	
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Clientes> registrar(@RequestBody Clientes cliente){
		this.service.registrar(cliente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getIdCliente()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
			
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Clientes> actualizar(@RequestBody Clientes cliente) {
		service.modificar(cliente);
		return new ResponseEntity<Clientes>(HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value="/coinci/{nombre}")
	public ResponseEntity<List<Clientes>> listaNombre(@PathVariable("nombre") String nombre) {
		List<Clientes> clientes = new ArrayList<>();
		clientes = service.consultaNombre(nombre);
		return new ResponseEntity<List<Clientes>>(clientes, HttpStatus.OK);
	}
	
	
}