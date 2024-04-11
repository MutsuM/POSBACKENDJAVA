package com.koleapp.service;

import java.util.List;

import com.koleapp.model.Productos;;

public interface IProductoService {
	
	void registrar(Productos producto);

	void modificar(Productos producto);

	Integer eliminar(int idProducto);

	Productos listarId(int idProducto);

	List<Productos> listar();

}
