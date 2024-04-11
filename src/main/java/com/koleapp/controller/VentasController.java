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

import com.koleapp.dto.CriteriosConsultaVentasDTO;
import com.koleapp.exception.ModeloNotFoundException;
import com.koleapp.model.DetalleVentas;
import com.koleapp.model.Productos;
import com.koleapp.model.Ventas;
import com.koleapp.service.IProductoService;
import com.koleapp.service.IVentaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/ventas")
public class VentasController {
	
	@Autowired
	private IVentaService service;

	
	//METODO PARA OBTENER TODAS LAS VENTAS SIN CRITERIO
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ventas>> listar() {
		List<Ventas> ventas = new ArrayList<>();
		ventas = service.listar();
		return new ResponseEntity<List<Ventas>>(ventas, HttpStatus.OK);
	}
	
	
	//METODO PARA OBTENER LAS VENTAS POR CRITERIOS
	@PostMapping(value="/criterio",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ventas>> listarCriterios(@RequestBody CriteriosConsultaVentasDTO criterio) {
		List<Ventas> ventas = new ArrayList<>();
		ventas = service.listarCriterio(criterio);
		if(!ventas.isEmpty()) {
			return new ResponseEntity<List<Ventas>>(ventas, HttpStatus.OK);	
		}else{
			return new ResponseEntity<List<Ventas>>(ventas, HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ventas> listarId(@PathVariable("id") Integer id) {			
		Ventas ventas = new Ventas();
		ventas = service.listarId(id);
		if (ventas == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Ventas>(ventas, HttpStatus.OK);
	}	
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ventas> registrar(@RequestBody Ventas ventas){				
		this.service.registrar(ventas);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ventas.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
			
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ventas> actualizar(@RequestBody Ventas ventas) {
		service.modificar(ventas);
		return new ResponseEntity<Ventas>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/detalleVentas/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DetalleVentas>> listarDetalleVentas(@PathVariable("id") Integer id) {
		List<DetalleVentas> detalleVentas = new ArrayList<>();
		detalleVentas = service.listarDetalle(id);
		return new ResponseEntity<List<DetalleVentas>>(detalleVentas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/generarReporte/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte(@PathVariable("id") Integer id) {
		byte[] data = null;
		data = service.generarReporte(id);
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}
	
	
	
}