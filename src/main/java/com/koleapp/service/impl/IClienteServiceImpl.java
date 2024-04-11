package com.koleapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koleapp.dao.IClienteDAO;
import com.koleapp.model.Clientes;
import com.koleapp.model.Empleados;
import com.koleapp.service.IClienteService;

@Service
public class IClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteDAO dao;

	@Override
	public void registrar(Clientes cliente) {
		// TODO Auto-generated method stub		
		dao.save(cliente);		
	}

	@Override
	public void modificar(Clientes cliente) {
		// TODO Auto-generated method stub
		dao.save(cliente);
	}

	@Override
	public void eliminar(int idCliente) {
		// TODO Auto-generated method stub
		dao.deleteById(idCliente);
	}

	@Override
	public Clientes listarId(int idCliente) {
		// TODO Auto-generated method stub
		//return dao.findOne(idCliente);
		
		Optional<Clientes> opt = dao.findById(idCliente);
		return opt.isPresent() ? opt.get() : new Clientes();
	}

	@Override
	public List<Clientes> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
		
	}

	@Override
	public List<Clientes> consultaNombre(String nombreCliente) {
		// TODO Auto-generated method stub
		StringBuilder str= new StringBuilder();
		str.append('%');
		str.append(nombreCliente);
		str.append('%');	
		return dao.getClientesMatch(str.toString().toUpperCase());
		//return dao.getClientesMatch(nombreCliente.toUpperCase());
	}
	
	

	
}
