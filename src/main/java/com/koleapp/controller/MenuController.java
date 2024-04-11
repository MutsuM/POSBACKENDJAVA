package com.koleapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koleapp.model.Menu;
import com.koleapp.service.IMenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {
	
	@Autowired
	private IMenuService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar() {
		List<Menu> menues = new ArrayList<>();
		menues = service.listar();
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}
	
	@GetMapping(value = "/usuario/{nombre:.+}", produces = MediaType.APPLICATION_JSON_VALUE)//el ":.+" es para cuando se envie el  @dominio.com, de lo contrario no lko captaría
	public ResponseEntity<List<Menu>> listar(@PathVariable("nombre") String nombre) {
		List<Menu> menues = new ArrayList<>();
		menues = service.listarMenuPorUsuario(nombre);
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}
	
	
}
