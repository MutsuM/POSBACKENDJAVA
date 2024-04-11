package com.koleapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koleapp.dao.IFormaPagoVentaDAO;
import com.koleapp.model.FormaPagoVenta;
import com.koleapp.model.MovimientosCaja;
import com.koleapp.service.IFormaPagoVentaService;

@Service
public class IFormaPagoVentaServiceImpl implements IFormaPagoVentaService {

	@Autowired
	private IFormaPagoVentaDAO dao;
	
	@Override
	public void registrar(FormaPagoVenta fpv) {
		// TODO Auto-generated method stub
		dao.save(fpv);
	}

	@Override
	public void modificar(FormaPagoVenta fpv) {
		// TODO Auto-generated method stub
		dao.save(fpv);
	}

	@Override
	public void eliminar(int idFormaPagoVenta) {
		// TODO Auto-generated method stub
		dao.deleteById(idFormaPagoVenta);
	}

	@Override
	public FormaPagoVenta listarId(int idFormaPagoVenta) {
		// TODO Auto-generated method stub
		//return dao.findOne(idFormaPagoVenta);
		
		
		Optional<FormaPagoVenta> opt = dao.findById(idFormaPagoVenta);
		return opt.isPresent() ? opt.get() : new FormaPagoVenta();	
	}

	@Override
	public List<FormaPagoVenta> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	

	
	
}
