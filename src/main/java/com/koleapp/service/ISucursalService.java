package com.koleapp.service;

import java.util.List;
import com.koleapp.model.Sucursal;



public interface ISucursalService {

	void registrar(Sucursal sucursal);

	void modificar(Sucursal sucursal);

	Integer eliminar(String idSucursal);

	Sucursal listarId(String idSucursal);

	List<Sucursal> listar();
	
	}