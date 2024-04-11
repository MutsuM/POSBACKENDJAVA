package com.koleapp.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import com.koleapp.model.Sucursal;
import com.koleapp.service.ISucursalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/sucursal")
public class SucursalController {

	@Autowired
	private ISucursalService service;

	  
		//LISTADO DE SUCURSALES
		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Sucursal>> listar() {
			List<Sucursal> sucursal = new ArrayList<>();
			sucursal = service.listar();
			return new ResponseEntity<List<Sucursal>>(sucursal, HttpStatus.OK);
		}
		
		//LISTADO POR SUCURSAL
		@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Sucursal> listarId(@PathVariable("id") String id) {
			Sucursal sucursal=new Sucursal();		
			sucursal = service.listarId(id);
			if (sucursal == null) {
				throw new ModeloNotFoundException("ID: " + id);
			}
			return new ResponseEntity<Sucursal>(sucursal, HttpStatus.OK);
		}
		
		//REGISTRO DE SUCURSAL
		@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> registrar(@Valid @RequestBody Sucursal sucursal){
			this.service.registrar(sucursal);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sucursal.getIdSucursal()).toUri();
			return ResponseEntity.created(location).build();		
		}
				
		//ACTUALIZAR SUCURSAL
		@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> actualizar(@Valid @RequestBody Sucursal sucursal) {
			service.modificar(sucursal);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		
		//METODO PARA ELIMINAR UN REGISTRO
		//SOLO SE DEBE ELIMINAR UNA SUCURSAL SI NO TIENE ALGUN USUARIO ASOCIADO
		@DeleteMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Integer> eliminar(@PathVariable("id") String id){		
			//METODO QUE REALIZA LA ELIMINACIÓN		
			 Integer eliminado =this.service.eliminar(id);
			 if(eliminado==1) {//SI ES 1, SE ELIMINÓ
				 return new ResponseEntity<>(eliminado,HttpStatus.OK);
			 }else {
				 return new ResponseEntity<>(0,HttpStatus.BAD_REQUEST);
			 }		 			
		}  
	  
}
