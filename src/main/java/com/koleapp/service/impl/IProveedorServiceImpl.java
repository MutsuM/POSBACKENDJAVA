package com.koleapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koleapp.dao.IProveedorDAO;
import com.koleapp.model.Proveedor;
import com.koleapp.model.Servicios;
import com.koleapp.service.IProveedorService;

@Transactional
@Service
public class IProveedorServiceImpl implements IProveedorService {
	
	@Autowired
	private IProveedorDAO dao;

	
	@Transactional
	@Override
	public void registrar(Proveedor proveedores) {					
		dao.save(proveedores);				
	}

	@Override
	public void modificar(Proveedor proveedores) {
		// TODO Auto-generated method stub
	dao.save(proveedores);	
	}

	@Override
	public void eliminar(int idProveedor) {
		// TODO Auto-generated method stub
		dao.deleteById(idProveedor);
	}

	@Override
	public Proveedor listarId(int idProveedor) {
		// TODO Auto-generated method stub
		//return dao.findOne(idProveedor);
		
		Optional<Proveedor> opt = dao.findById(idProveedor);
		return opt.isPresent() ? opt.get() : new Proveedor();	
	}

	@Override
	public List<Proveedor> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	

}
