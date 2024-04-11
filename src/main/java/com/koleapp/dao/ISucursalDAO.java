package com.koleapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koleapp.model.Empleados;
import com.koleapp.model.Sucursal;

@Repository
public interface ISucursalDAO extends JpaRepository<Sucursal, String> {

	//Busco si un empleado tiene la sucursal asociada para no eliminar
	@Query(value ="select * from empleados where id_sucursal=:idSucursal", nativeQuery = true)
	List<Empleados> findEmpleadoBeforeDelete(@Param("idSucursal") String idSucursal);
	
	
}
