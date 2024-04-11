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
import com.koleapp.model.Productos;
import com.koleapp.service.IProductoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Productos>> listar() {
		List<Productos> productos = new ArrayList<>();
		productos = service.listar();
		return new ResponseEntity<List<Productos>>(productos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Productos> listarId(@PathVariable("id") Integer id) {
		
		Productos producto= new Productos();
		producto = service.listarId(id);
		if (producto == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Productos>(producto, HttpStatus.OK);
	}	
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Productos> registrar(@RequestBody Productos producto){				
		this.service.registrar(producto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(producto.getIdProductos()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
			
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Productos> actualizar(@RequestBody Productos producto) {
		service.modificar(producto);
		return new ResponseEntity<Productos>(HttpStatus.OK);
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