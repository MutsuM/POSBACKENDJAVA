package com.koleapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koleapp.dao.ISucursalDAO;
import com.koleapp.model.Empleados;
import com.koleapp.model.Sucursal;
import com.koleapp.service.ISucursalService;

@Service
public class ISucursalServiceImpl implements ISucursalService {

	@Autowired
	private ISucursalDAO dao;
	
	@Override
	public void registrar(Sucursal sucursal) {
		// TODO Auto-generated method stub
		this.dao.save(sucursal);
		
	}

	@Override
	public void modificar(Sucursal sucursal) {
		// TODO Auto-generated method stub		
		this.dao.save(sucursal);
	}

	
	//METODO POR IMPLEMENTAR, LLAMAR A UNA FUNCION EN BD PARA VALIDAR SI EL REGISTRO TIENE DEPENDENCIA CON ALGUN OTRO, DE LO CONTRARIO NO PERMITE SU ELIMINACIÓN
	@Override
	public Integer eliminar(String idSucursal) {
		// TODO Auto-generated method stub
		List<Empleados> lista = this.dao.findEmpleadoBeforeDelete(idSucursal);
		
		if(lista.isEmpty()) {
			dao.deleteById(idSucursal);
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public Sucursal listarId(String idSucursal) {
		// TODO Auto-generated method stub
		Optional<Sucursal> opt = dao.findById(idSucursal);
		return opt.isPresent() ? opt.get() : new Sucursal();	
	}

	@Override
	public List<Sucursal> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	
	
}
