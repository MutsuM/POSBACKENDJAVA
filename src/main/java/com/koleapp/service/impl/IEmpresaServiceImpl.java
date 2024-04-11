package com.koleapp.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.koleapp.dao.IEmpresaDAO;
import com.koleapp.model.Empleados;
import com.koleapp.model.Empresa;
import com.koleapp.service.IEmpresaService;

@Service
public class IEmpresaServiceImpl implements IEmpresaService {

	@Autowired
	private IEmpresaDAO empresaRepository;

	
	
	
	@Override
	public void registrar(Empresa empresa) {
		this.empresaRepository.save(empresa);
		
	}

	
	@Override
	public List<Empresa> listar() {
		// TODO Auto-generated method stub
		return this.empresaRepository.findAll();
	}

	

	@Override
	public Empresa listarId(String id) {
		// TODO Auto-generated method stub
		Optional<Empresa> opt = empresaRepository.findById(id);
		return opt.isPresent() ? opt.get() : new Empresa();			
	}


	@Transactional
	@Override
	public void updatelogo(Integer idEmpresa, MultipartFile file) {
		String nombreImagen = StringUtils.cleanPath(file.getOriginalFilename());
		Empresa empresa = new Empresa();
		try {
			
			
			//Optional<Empresa> emp = empresaRepository.actualizarImagen(idEmpresa, file.getBytes(), nombreImagen, file.getContentType());
			empresaRepository.actualizarImagen(idEmpresa, file.getBytes(), nombreImagen, file.getContentType());
			//return empresaRepository.actualizarImagen(idEmpresa, file.getBytes(), nombreImagen, file.getContentType());
			
			//return empresaRepository.save(empresa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}

	@Override
	public Empresa getImagen(Integer idEmpresa) {
		Empresa emp = empresaRepository.traerDatos(idEmpresa);
		return emp;
	}

	@Override
	public Stream<Empresa> getAllFiles() {
		return empresaRepository.findAll().stream();
	}

}
