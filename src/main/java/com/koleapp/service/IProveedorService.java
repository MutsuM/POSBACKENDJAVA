package com.koleapp.service;

import java.util.List;

import com.koleapp.model.Proveedor;

public interface IProveedorService {
	
	void registrar(Proveedor proveedores);

	void modificar(Proveedor proveedores);

	void eliminar(int idProveedor);

	Proveedor listarId(int idProveedor);

	List<Proveedor> listar();

}
