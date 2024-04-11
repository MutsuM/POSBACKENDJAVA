package com.koleapp.service;

import java.util.List;

import com.koleapp.dto.PlatoDTO;
import com.koleapp.model.Plato;




public interface PlatoService {
	
	Plato registrar(PlatoDTO plato);

	void modificar(Plato plato);

	void eliminar(int idPlato);

	Plato listarId(int idPlato);

	List<Plato> listar();

}
