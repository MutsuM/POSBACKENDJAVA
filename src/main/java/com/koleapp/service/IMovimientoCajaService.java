package com.koleapp.service;

import java.util.List;

import com.koleapp.model.Caja;
import com.koleapp.model.MovimientosCaja;
import com.koleapp.model.Ventas;



public interface IMovimientoCajaService {
	
	
	void registrar(MovimientosCaja movi);
	
	void registrarFromVenta(Ventas ve );

	void modificar(MovimientosCaja movi);

	void eliminar(MovimientosCaja movi);
	
	List<MovimientosCaja> listar();
	
	MovimientosCaja listarId(int idMovimiento);
	
	void eliminarMovimientoVenta(Integer idVenta);
	
}
