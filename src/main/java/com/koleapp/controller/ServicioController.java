package com.koleapp.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.koleapp.exception.ModeloNotFoundException;
import com.koleapp.model.Servicios;
import com.koleapp.service.IServicioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/servicios")
public class ServicioController {

	@Autowired
	private IServicioService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Servicios>> listar() {
		List<Servicios> servicios = new ArrayList<>();
		servicios = service.listar();
		return new ResponseEntity<List<Servicios>>(servicios, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Servicios> listarId(@PathVariable("id") Integer id) {
		
		Servicios servicios= new Servicios();
		servicios = service.listarId(id);
		if (servicios == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Servicios>(servicios, HttpStatus.OK);
	}	
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Servicios> registrar(@RequestBody Servicios servicios){				
		this.service.registrar(servicios);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(servicios.getIdServicios()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
			
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Servicios> actualizar(@RequestBody Servicios servicios) {
		service.modificar(servicios);
		return new ResponseEntity<Servicios>(HttpStatus.OK);
	}
	
	
	//METODO PARA ELIMINAR UN REGISTRO
	@DeleteMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminar(@PathVariable("id") Integer id){		
		//METODO QUE REALIZA LA ELIMINACIÓN		
		 Integer eliminado =this.service.eliminar(id);
		 if(eliminado==1) {//SI ES 1, SE ELIMINÓ
			 return new ResponseEntity<>(eliminado,HttpStatus.OK);
		 }else {
			 return new ResponseEntity<>(0,HttpStatus.OK);
		 }		 			
	}
	
	
	
}