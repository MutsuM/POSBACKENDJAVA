package com.koleapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koleapp.dao.IDetalleVentasDAO;
import com.koleapp.model.DetalleVentas;
import com.koleapp.service.IDetalleVentaService;

@Service
public class IDetalleVentaServiceImpl implements IDetalleVentaService {
	
	@Autowired
	private IDetalleVentasDAO detalleDAO;

	@Override
	public List<DetalleVentas> listarDetalle(Integer idVenta) {
		// TODO Auto-generated method stub
		return this.detalleDAO.listarDetallesVenta(idVenta);
	}

	@Override
	public void eliminarDetallesVenta(Integer idVenta) {
		this.detalleDAO.eliminarDetalleVentas(idVenta);
		
	}

}
