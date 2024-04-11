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
import com.koleapp.model.Caja;
import com.koleapp.model.FormaPagoVenta;
import com.koleapp.service.ICajaService;
import com.koleapp.service.IFormaPagoVentaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/formapagoventa")
public class FormaPagoVentaController {

	@Autowired
	private IFormaPagoVentaService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FormaPagoVenta>> listar() {
		List<FormaPagoVenta> fpv = new ArrayList<>();
		fpv = service.listar();
		return new ResponseEntity<List<FormaPagoVenta>>(fpv, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FormaPagoVenta> listarId(@PathVariable("id") Integer id) {
		FormaPagoVenta fpv = new FormaPagoVenta();
		fpv = service.listarId(id);
		if (fpv == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<FormaPagoVenta>(fpv, HttpStatus.OK);
	}
		
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody FormaPagoVenta fpv){
		this.service.registrar(fpv);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fpv.getIdFormapagoventa()).toUri();
		return ResponseEntity.created(location).build();		
	}
			
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody FormaPagoVenta fpv) {
		service.modificar(fpv);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}