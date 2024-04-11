package com.koleapp.service;

import java.util.List;

import com.koleapp.model.Categoria;
import com.koleapp.model.Especialidad;

public interface ICategoriaService {

	void registrar(Categoria categoria);

	void modificar(Categoria categoria);

	void eliminar(int idCategoria);

	Categoria listarId(int idCategoria);

	List<Categoria> listar();

}
