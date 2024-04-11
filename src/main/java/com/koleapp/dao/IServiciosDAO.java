package com.koleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koleapp.model.Servicios;

@Repository
public interface IServiciosDAO extends JpaRepository<Servicios, Integer> {
	
			//obtengo la descripción del tipo de servicio a utilizar
			@Query(value = "SELECT descripcion FROM servicios where id_servicios=:idItem ", nativeQuery = true)
			String getDescripcion(@Param("idItem") Integer idItem);

}
