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
import com.koleapp.model.Caja;
import com.koleapp.model.Empleados;
import com.koleapp.service.ICajaService;
import com.koleapp.service.IEmpleadoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService service;

	//LISTADO DE EMPLEADOS
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Empleados>> listar() {
		List<Empleados> empleados = new ArrayList<>();
		empleados = service.listar();
		return new ResponseEntity<List<Empleados>>(empleados, HttpStatus.OK);
	}
	
	//LISTADO POR EMPLEADO
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empleados> listarId(@PathVariable("id") Integer id) {
		Empleados empleado=new Empleados();		
		empleado = service.listarId(id);
		if (empleado == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Empleados>(empleado, HttpStatus.OK);
	}
	
	//REGISTRO DE EMPLEADO
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Empleados empleados){
		this.service.registrar(empleados);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empleados.getIdEmpleado()).toUri();
		return ResponseEntity.created(location).build();		
	}
			
	//ACTUALIZAR EMPLEADO
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Empleados empleados) {
		service.modificar(empleados);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	//METODO PARA ELIMINAR UN REGISTRO
	//SOLO SE DEBE ELIMINAR UN EMPLEADO SI NO TIENE ALGUNA VENTA RELACIONADA
	@DeleteMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminar(@PathVariable("id") Integer id){		
		//METODO QUE REALIZA LA ELIMINACIÓN		
		 Integer eliminado =this.service.eliminar(id);
		 if(eliminado==1) {//SI ES 1, SE ELIMINÓ
			 return new ResponseEntity<>(eliminado,HttpStatus.OK);
		 }else {
			 return new ResponseEntity<>(0,HttpStatus.BAD_REQUEST);
		 }		 			
	}
	
	
	

}
