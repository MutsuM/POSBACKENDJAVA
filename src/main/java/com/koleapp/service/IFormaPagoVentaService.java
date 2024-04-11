package com.koleapp.service;

import java.util.List;

import com.koleapp.model.Caja;
import com.koleapp.model.FormaPagoVenta;



public interface IFormaPagoVentaService {

	void registrar(FormaPagoVenta fpv);

	void modificar(FormaPagoVenta fpv);

	void eliminar(int idFormaPagoVenta);

	FormaPagoVenta listarId(int idFormaPagoVenta);

	List<FormaPagoVenta> listar();
	
	

}
