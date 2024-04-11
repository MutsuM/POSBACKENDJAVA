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
import com.koleapp.model.MovimientosCaja;
import com.koleapp.service.ICajaService;
import com.koleapp.service.IMovimientoCajaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/movimiento")
public class MovimientoController {

	@Autowired
	private IMovimientoCajaService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MovimientosCaja>> listar() {
		List<MovimientosCaja> movi = new ArrayList<>();
		movi = service.listar();
		return new ResponseEntity<List<MovimientosCaja>>(movi, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MovimientosCaja> listarId(@PathVariable("id") Integer id) {
		
		MovimientosCaja movi = new MovimientosCaja();
		movi= service.listarId(id);
		if (movi == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<MovimientosCaja>(movi, HttpStatus.OK);
	}
	
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody MovimientosCaja movi){
		this.service.registrar(movi);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movi.getIdMovimiento()).toUri();
		return ResponseEntity.created(location).build();		
	}
			
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody MovimientosCaja movi) {
		service.modificar(movi);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}