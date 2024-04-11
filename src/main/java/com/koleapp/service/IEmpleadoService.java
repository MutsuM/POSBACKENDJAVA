package com.koleapp.service;

import java.util.List;

import com.koleapp.model.Caja;
import com.koleapp.model.Empleados;



public interface IEmpleadoService {

	void registrar(Empleados empleados);

	void modificar(Empleados empleados);

	Integer eliminar(int idEmpleado);

	Empleados listarId(int idEmpleado);

	List<Empleados> listar();
	
	}