package com.koleapp.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.koleapp.dto.OrdenesDTO;

import com.koleapp.model.Ordenes;

import com.koleapp.service.OrdenesService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/ordenes")
public class OrdenesController {

	@Autowired
	private OrdenesService service;

	// METODO PARA OBTENER TODAS LAS VENTAS SIN CRITERIO
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ordenes>> listar() {
		List<Ordenes> ordenes = new ArrayList<>();
		try {
			ordenes = service.listarOrdenes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<List<Ordenes>>(ordenes, HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ordenes> registrar(@RequestBody OrdenesDTO ordenes) {

		try {
			this.service.registrar(ordenes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(ordenes.getIdOrden()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(value = "/actualizarEstado",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ordenes> actualizarEstado(@RequestBody OrdenesDTO ordenes) {

		try {
			this.service.actualizarEstado(ordenes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(ordenes.getIdOrden()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(value = "/generarReporte/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte(@PathVariable("id") int id) {
		byte[] data = null;
		data = service.generarReporte(id);
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}

}