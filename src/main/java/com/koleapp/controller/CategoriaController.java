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
import com.koleapp.model.Categoria;
import com.koleapp.model.Especialidad;
import com.koleapp.model.Medico;
import com.koleapp.service.ICategoriaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Categoria>> listar() {
		List<Categoria> categorias = new ArrayList<>();
		categorias = service.listar();
		return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> listarId(@PathVariable("id") Integer id) {
		Categoria categoria = new Categoria();
		categoria = service.listarId(id);
		if (categoria == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}
	
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Categoria categoria){
		this.service.registrar(categoria);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getIdCategoria()).toUri();
		return ResponseEntity.created(location).build();		
	}
			
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Categoria categoria) {
		service.modificar(categoria);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	/*
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar2(@PathVariable("id") Integer id) {
		
		Categoria cat = service.listarId(id);
		if (cat== null) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			service.eliminar(id);
		}	
	}*/
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminar(@PathVariable("id") Integer id) {
		
		Categoria cat = service.listarId(id);
		if (cat== null) {
			//throw new ModeloNotFoundException("ID: " + id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			service.eliminar(id);
			return new ResponseEntity<>(id, HttpStatus.OK);
		}	
	}
	
}