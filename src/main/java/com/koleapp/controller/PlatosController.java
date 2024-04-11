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
import com.koleapp.dto.PlatoDTO;
import com.koleapp.exception.ModeloNotFoundException;
import com.koleapp.model.DetalleVentas;
import com.koleapp.model.Plato;
import com.koleapp.model.Productos;
import com.koleapp.model.Ventas;
import com.koleapp.service.IProductoService;
import com.koleapp.service.IVentaService;
import com.koleapp.service.PlatoService;
import com.koleapp.service.impl.IPlatoServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/platos")
public class PlatosController {
	
	@Autowired
	private PlatoService service;
	


	
	//METODO PARA OBTENER TODOS LOS PLATOS SIN CRITERIO
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Plato>> listar() {
		List<Plato> platos = new ArrayList<>();
		platos = service.listar();
		return new ResponseEntity<List<Plato>>(platos, HttpStatus.OK);
	}
	
	

	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Plato> registrar(@RequestBody PlatoDTO plato){		
		
		this.service.registrar(plato);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(plato.getIdPlato()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Plato> actualizar(@RequestBody PlatoDTO plato){		
		
		this.service.registrar(plato);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(plato.getIdPlato()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	
	
	
}