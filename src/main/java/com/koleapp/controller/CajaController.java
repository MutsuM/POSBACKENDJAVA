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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.koleapp.dto.ResumenCajaDTO;
import com.koleapp.dto.ResumenMovimientosDTO;
import com.koleapp.exception.ModeloNotFoundException;
import com.koleapp.model.Caja;
import com.koleapp.model.Empleados;
import com.koleapp.model.MovimientosCaja;
import com.koleapp.service.ICajaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/caja")
public class CajaController {

	@Autowired
	private ICajaService service;

	// METODO QUE LISTA TODAS LAS CAJAS QUE ESTÁN CERRADAS.
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Caja>> listar() {
		List<Caja> caja = new ArrayList<>();
		caja = service.listar();
		return new ResponseEntity<List<Caja>>(caja, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Caja> listarId(@PathVariable("id") Integer id) {
		Caja caja = new Caja();
		caja = service.listarId(id);
		if (caja == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Caja>(caja, HttpStatus.OK);
	}

	// METODO QUE TRAE LA CAJA ACTIVA, SOBRE LA CUAL SE HARAN TODAS LAS OPERACIONES
	@GetMapping(value = "/getCajaActiva", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Caja> traerCajaActiva() {
		Caja caja = new Caja();
		caja = service.getCajaActiva();
		if (caja == null) {
			// throw new ModeloNotFoundException("No hay cajas abiertas");
			return new ResponseEntity<Caja>(caja, HttpStatus.OK);
		}
		return new ResponseEntity<Caja>(caja, HttpStatus.OK);
	}

	// METODO QUE TRAE LOS MOVIMIENTOS ASOCIADOS A UNA CAJA
	@GetMapping(value = "/getResumenMovimientos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ResumenMovimientosDTO>> listarMovimientoResumen(@PathVariable("id") Integer id) {
		List<ResumenMovimientosDTO> lista = service.listarMovimientoResumen(id);
		if (lista == null) {
			return new ResponseEntity<List<ResumenMovimientosDTO>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<List<ResumenMovimientosDTO>>(lista, HttpStatus.OK);
	}

	//METODO QUE APERTURA LA CAJA
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody MovimientosCaja movimiento) {
		MovimientosCaja mov= this.service.registrar(movimiento);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mov.getCaja().getIdCaja())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Caja caja) {
	//public ResponseEntity<Object> actualizar(@RequestParam("caja") Caja caja,@RequestParam("empleados") Empleados empleados) {
				
		service.modificar(caja);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping(value = "/listarResumenCaja/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResumenCajaDTO> listarResumenCaja(@PathVariable("id") Integer id) {
		ResumenCajaDTO resumen = new ResumenCajaDTO();
		resumen = service.listarResumenCaja(id);

		if (resumen == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<ResumenCajaDTO>(resumen, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getLastCaja", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Caja> getLastCaja() {
		Caja caja = new Caja();
		caja = service.getUltimacaja();
		if (caja == null) {
			return new ResponseEntity<Caja>(caja, HttpStatus.OK);	
		}
		return new ResponseEntity<Caja>(caja, HttpStatus.OK);
	}

}