package com.koleapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koleapp.model.Ventas;

@Repository
public interface IVentasDAO extends JpaRepository<Ventas, Integer> {
	
	
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM Ventas de where de.id_venta =:idVenta",nativeQuery = true)
	void eliminarVenta(@Param("idVenta") Integer idVenta);
		
	@Transactional
	@Query(value="SELECT * FROM VENTAS WHERE ID_VENTA IN (:ids)", nativeQuery=true)
	List<Ventas> getVentasCriterio(@Param("ids") List<Integer> ids);
		
}
