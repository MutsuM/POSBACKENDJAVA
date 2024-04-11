package com.koleapp.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.koleapp.model.FormaPago;
import com.koleapp.service.IFormaPagoProveedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/formapagoproveedor")
public class FormaPagoProveedorController {

	@Autowired
	private IFormaPagoProveedorService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FormaPago>> listar() {
		List<FormaPago> fpv = new ArrayList<>();
		fpv = service.listar();
		return new ResponseEntity<List<FormaPago>>(fpv, HttpStatus.OK);
	}	
}