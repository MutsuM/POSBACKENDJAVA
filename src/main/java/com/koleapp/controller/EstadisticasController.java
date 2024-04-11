package com.koleapp.controller;


import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.koleapp.dto.EmpleadoDetalleResumenDTO;
import com.koleapp.dto.EstadisticasDTO;
import com.koleapp.exception.ModeloNotFoundException;
import com.koleapp.service.IEstadisticasService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/estadisticas")
public class EstadisticasController {
	
	@Autowired
	private IEstadisticasService service;

	
	//METODO PARA OBTENER LAS VENTAS POR CRITERIOS
	@PostMapping(value="/generales",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstadisticasDTO>> listarCriterios(@RequestBody EstadisticasDTO estaDTO) {
		List<EstadisticasDTO> lista = new ArrayList<>();
		lista = service.listarVentas(estaDTO);
		if(!lista.isEmpty()) {
			return new ResponseEntity<List<EstadisticasDTO>>(lista, HttpStatus.OK);	
		}else{
			return new ResponseEntity<List<EstadisticasDTO>>(lista, HttpStatus.OK);
		}
	}	
	
	//METODO PARA OBTENER LAS VENTAS POR CRITERIOS
		@PostMapping(value="/resumengenerales",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<EstadisticasDTO>> listarResumenGenerales(@RequestBody EstadisticasDTO estaDTO) {
			List<EstadisticasDTO> lista = new ArrayList<>();
			lista = service.listarVentasResumen(estaDTO);
			if(!lista.isEmpty()) {
				return new ResponseEntity<List<EstadisticasDTO>>(lista, HttpStatus.OK);	
			}else{
				return new ResponseEntity<List<EstadisticasDTO>>(lista, HttpStatus.OK);
			}
		}
		
	//METODO PARA OBTENER LAS VENTAS POR CRITERIOS
			@PostMapping(value="/empleados",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<EstadisticasDTO>> listarVentasEmpleados(@RequestBody EstadisticasDTO estaDTO) {
				List<EstadisticasDTO> lista = new ArrayList<>();
				lista = service.listarVentasEmpleados(estaDTO);
				if(!lista.isEmpty()) {
					return new ResponseEntity<List<EstadisticasDTO>>(lista, HttpStatus.OK);	
				}else{
					return new ResponseEntity<List<EstadisticasDTO>>(lista, HttpStatus.OK);
				}
			}
		
			//METODO PARA OBTENER LAS VENTAS POR CRITERIOS
			@PostMapping(value="/empleados/detalle",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<EmpleadoDetalleResumenDTO> listarVentasEmpleadosDetalle(@RequestBody EstadisticasDTO estaDTO) {				
				EmpleadoDetalleResumenDTO emp = new EmpleadoDetalleResumenDTO();
				emp = service.listaDetalleEmpleado(estaDTO);
				
				if(!emp.equals(null)) {
					return new ResponseEntity<EmpleadoDetalleResumenDTO>(emp, HttpStatus.OK);	
				}else{
					return new ResponseEntity<EmpleadoDetalleResumenDTO>(emp, HttpStatus.OK);
				}
			}		
				
	//METODO PARA OBTENER LAS VENTAS DE SERVICIOS ESPECÍFICAS POR EMPLEADO
	@PostMapping(value="/servicios",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstadisticasDTO>> listarServiciosEmpleados(@RequestBody EstadisticasDTO estaDTO) {
		List<EstadisticasDTO> lista = new ArrayList<>();
		lista = service.listarServiciosEmpleados(estaDTO);
		if(!lista.isEmpty()) {
			return new ResponseEntity<List<EstadisticasDTO>>(lista, HttpStatus.OK);	
		}else{
			return new ResponseEntity<List<EstadisticasDTO>>(lista, HttpStatus.OK);
		}
	}
	
	
	//METODO PARA OBTENER LAS VENTAS DE PRODUCTOS ESPECÍFICAS POR EMPLEADO
		@PostMapping(value="/productos",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<EstadisticasDTO>> listarProductosEmpleados(@RequestBody EstadisticasDTO estaDTO) {
			List<EstadisticasDTO> lista = new ArrayList<>();
			lista = service.listarProductosEmpleados(estaDTO);
			if(!lista.isEmpty()) {
				return new ResponseEntity<List<EstadisticasDTO>>(lista, HttpStatus.OK);	
			}else{
				return new ResponseEntity<List<EstadisticasDTO>>(lista, HttpStatus.OK);
		}
	}
	
}