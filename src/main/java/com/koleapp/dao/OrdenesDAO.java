package com.koleapp.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koleapp.model.Ordenes;

@Repository
public interface OrdenesDAO extends JpaRepository<Ordenes, Integer> {
	
	@Modifying
	@Query(value ="UPDATE ordenes set estado =:idEstado WHERE id_orden =:idOrden",nativeQuery = true)
	void actualizarEstado(@Param("idOrden") int idOrden, @Param("idEstado") int idEstado);
	
	
	@Query(value ="SELECT pla.cantidad, pla.notas, pl.nombre from platos_orden pla "
			+ "LEFT JOIN platos pl on pl.id_plato = pla.id_plato "
			+ "WHERE pla.id_orden =:idOrden",nativeQuery = true)
	List<Object[]> getDetallesPlatoComanda(@Param("idOrden") int idOrden);
	
	
	

}
