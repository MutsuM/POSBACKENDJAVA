package com.koleapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koleapp.dao.IEmpleadoDAO;
import com.koleapp.model.DetalleVentas;
import com.koleapp.model.Empleados;
import com.koleapp.model.FormaPagoVenta;
import com.koleapp.service.IEmpleadoService;

@Service
public class IEmpleadoServiceImpl implements IEmpleadoService {
	
	@Autowired
	private IEmpleadoDAO dao;

	@Override
	public void registrar(Empleados empleados) {
		// TODO Auto-generated method stub
		dao.save(empleados);		
	}

	@Override
	public void modificar(Empleados empleados) {
		// TODO Auto-generated method stub
		dao.save(empleados);		
	}

	@Override
	public Integer eliminar(int idEmpleado) {
				
		 //1. METODO PARA VALIDAR SI EL EMPLEADO NO TIENE RELACIÓN ALGUNA CON UNA VENTA		
		List<DetalleVentas> lista = this.dao.findProductoBeforeDelete(idEmpleado);
		if(lista.isEmpty()) {
			dao.deleteById(idEmpleado);
			return 1;
		}
		else {
			return 0;
		}
		
	}

	@Override
	public Empleados listarId(int idEmpleado) {
		// TODO Auto-generated method stub
		//return dao.findOne(idEmpleado);
		Optional<Empleados> opt = dao.findById(idEmpleado);
		return opt.isPresent() ? opt.get() : new Empleados();	
	}

	@Override
	public List<Empleados> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}	
}