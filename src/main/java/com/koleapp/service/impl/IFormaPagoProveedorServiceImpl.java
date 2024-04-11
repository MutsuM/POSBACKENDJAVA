package com.koleapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koleapp.dao.IFormaPagoProveedorDAO;
import com.koleapp.model.FormaPago;
import com.koleapp.service.IFormaPagoProveedorService;

@Service
public class IFormaPagoProveedorServiceImpl implements IFormaPagoProveedorService {

	@Autowired
	private IFormaPagoProveedorDAO dao;
	
	@Override
	public List<FormaPago> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}