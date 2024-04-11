package com.koleapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koleapp.model.DetalleVentas;


@Repository
public interface IDetalleVentasDAO extends JpaRepository<DetalleVentas, Integer> {
	
	
		//listado de todos los detalles de las ventas
		@Query(value = "SELECT * FROM detalleventas  where id_venta=:idVenta ORDER BY id_detalleventa", nativeQuery = true)
		List<DetalleVentas> listarDetallesVenta(@Param("idVenta") Integer idVenta);
		
		
		@Modifying
		@Transactional
		@Query(value="DELETE FROM DetalleVentas de where de.id_venta =:idVenta",nativeQuery = true)
		void eliminarDetalleVentas(@Param("idVenta") Integer idVenta);
		
		
		//SE LISTAN ELEMENTOS EN UNA VENTA ASOCIADOS A UN SERVICIO ANTES DE ELIMINAR
		@Query(value = "select * from detalleventas where id_tipodetalleventa = 1 and id_item=:idServicio", nativeQuery = true)		
		List<DetalleVentas> findServioceBeforeDelete(@Param("idServicio") Integer idServicio);
		
		//SE LISTAN ELEMENTOS EN UNA VENTA ASOCIADOS A UN PRODUCTO ANTES DE ELIMINAR
		@Query(value = "select * from detalleventas where id_tipodetalleventa = 2 and id_item=:idProducto", nativeQuery = true)		
		List<DetalleVentas> findProductoBeforeDelete(@Param("idProducto") Integer idProducto);
		
		
		
		
	
	
	

}
