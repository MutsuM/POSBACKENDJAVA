package com.koleapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koleapp.dao.IDetalleVentasDAO;
import com.koleapp.dao.IProductosDAO;
import com.koleapp.model.DetalleVentas;
import com.koleapp.model.Productos;
import com.koleapp.model.Proveedor;
import com.koleapp.service.IProductoService;

@Service
public class IProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductosDAO dao;
	
	@Autowired
	private IDetalleVentasDAO detalleDao;
	
	
	@Override
	public void registrar(Productos producto) {
		// TODO Auto-generated method stub		
		dao.save(producto);		
	}

	@Override
	public void modificar(Productos producto) {
		// TODO Auto-generated method stub
		dao.save(producto);
	}

	@Override
	public Integer eliminar(int idProducto) {
		 //1. METODO PARA VALIDAR SI EL PRODUCTO NO TIENE RELACIÓN ALGUNA CON UNA VENTA		
		List<DetalleVentas> lista = this.detalleDao.findProductoBeforeDelete(idProducto);
		if(lista.isEmpty()) {
			dao.deleteById(idProducto);
			return 1;
		}
		else {
			return 0;
		}
				
	}

	@Override
	public Productos listarId(int idProducto) {
		// TODO Auto-generated method stub
		//return dao.findOne(idProducto);
		
		Optional<Productos> opt = dao.findById(idProducto);
		return opt.isPresent() ? opt.get() : new Productos();	
	}

	@Override
	public List<Productos> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	
	
}
