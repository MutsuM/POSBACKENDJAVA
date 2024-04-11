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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.koleapp.exception.ModeloNotFoundException;
import com.koleapp.model.Caja;
import com.koleapp.model.Empleados;
import com.koleapp.model.Empresa;
import com.koleapp.model.Sucursal;
import com.koleapp.service.ICajaService;
import com.koleapp.service.IEmpleadoService;
import com.koleapp.service.IEmpresaService;
import com.koleapp.util.ResponseFile;
import com.koleapp.util.ResponseMessage;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private IEmpresaService service;

	// REGISTRO DE EMPRESA
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Empresa empresa) {
		this.service.registrar(empresa);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(empresa.getIdEmpresa()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//LISTADO DE EMPRESAS
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Empresa>> listar() {
		List<Empresa> empresa = new ArrayList<>();
		empresa = service.listar();
		return new ResponseEntity<List<Empresa>>(empresa, HttpStatus.OK);
	}
	
	//LISTADO POR EMPRESA
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa> listarId(@PathVariable("id") String id) {
		Empresa empresa=new Empresa();		
		empresa = service.listarId(id);
		if (empresa == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
	}
	

	@PutMapping(value="/upload",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id) {
		String message = "";
		try {
			service.updatelogo(id,file);
			message = "Carga de Imagen exitosa: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "No se pudo cargar la imagen: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Integer id) {
		Empresa empresa = service.getImagen(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + empresa.getNombreImagen() + "\"")
				.body(empresa.getLogo());
	}

	@GetMapping("/files")
	public ResponseEntity<List<ResponseFile>> getListFiles() {
		List<ResponseFile> files = service.getAllFiles().map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/")
					.path(String.valueOf(dbFile.getIdEmpresa())).toUriString();

			return new ResponseFile(dbFile.getNombreImagen(), fileDownloadUri, dbFile.getType(),
					dbFile.getLogo().length);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

}
