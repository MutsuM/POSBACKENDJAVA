package com.koleapp.service;

import java.util.List;

import javax.validation.Valid;

import com.koleapp.dto.ResumenCajaDTO;
import com.koleapp.dto.ResumenMovimientosDTO;
import com.koleapp.model.Caja;
import com.koleapp.model.Empleados;
import com.koleapp.model.MovimientosCaja;



public interface ICajaService {

	MovimientosCaja registrar(MovimientosCaja movimientoCaja);

	void modificar(Caja caja);

	void eliminar(int idCaja);

	Caja listarId(int idCaja);

	List<Caja> listar();
	
	int getLastId();
	
	ResumenCajaDTO listarResumenCaja(int idCaja);
	
	Caja getCajaActiva();
	
	List<ResumenMovimientosDTO> listarMovimientoResumen(int idCaja);
	
	Caja getUltimacaja();

	

}
