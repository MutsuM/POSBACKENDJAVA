package com.koleapp.dao;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.koleapp.model.PlatosOrden;

@Repository
public interface PlatosOrdenDAO extends JpaRepository<PlatosOrden, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM platos_orden pl where pl.id_orden =:idOrden",nativeQuery = true)
	void eliminarVenta(@Param("idOrden") int idOrden);
	
	

}