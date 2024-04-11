package com.koleapp.service;

import java.util.List;

import com.koleapp.model.Servicios;;

public interface IServicioService {
	
	void registrar(Servicios servicio);

	void modificar(Servicios servicio);

	Integer eliminar(int idServicio);

	Servicios listarId(int idServicio);

	List<Servicios> listar();

}
