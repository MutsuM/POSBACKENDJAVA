package com.koleapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koleapp.model.MovimientosCaja;

@Repository
public interface IMovimientoCajaDAO extends JpaRepository<MovimientosCaja, Integer>{
	
	//metodo para elminar el movimiento asociado a las ventas
	@Modifying
	@Transactional
	@Query("DELETE FROM MovimientosCaja de where de.idOperacion =:idVenta")
	void eliminarMovimiento(@Param("idVenta") Integer idVenta);
	
	

}
