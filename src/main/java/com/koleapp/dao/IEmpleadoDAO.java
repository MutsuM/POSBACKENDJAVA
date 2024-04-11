package com.koleapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koleapp.model.DetalleVentas;
import com.koleapp.model.Empleados;

@Repository
public interface IEmpleadoDAO extends JpaRepository<Empleados, Integer> {
	
	//SE LISTAN ELEMENTOS EN UNA VENTA ASOCIADOS A UN PRODUCTO ANTES DE ELIMINAR
	@Query(value = "select * from detalleventas where id_empleado=:idEmpleado", nativeQuery = true)		
	List<DetalleVentas> findProductoBeforeDelete(@Param("idEmpleado") Integer idEmpleado);

}
