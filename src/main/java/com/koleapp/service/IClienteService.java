package com.koleapp.service;

import java.util.List;

import com.koleapp.model.Clientes;;

public interface IClienteService {
	
	void registrar(Clientes cliente);

	void modificar(Clientes cliente);

	void eliminar(int idCliente);

	Clientes listarId(int idCliente);

	List<Clientes> listar();
	
	List<Clientes> consultaNombre(String nombreCliente);

}
