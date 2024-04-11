package com.koleapp.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Stream;
import com.koleapp.model.Empresa;



public interface IEmpresaService {
	public void registrar(Empresa empresa);
	public void updatelogo(Integer idEmpresa,MultipartFile file);
	public Empresa getImagen(Integer idEmpresa);
	public Stream<Empresa> getAllFiles();
	List<Empresa> listar();
	Empresa listarId(String id);
	
}
