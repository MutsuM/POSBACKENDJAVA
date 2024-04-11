package com.koleapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koleapp.model.Plato;

@Repository
public interface PlatoDAO extends JpaRepository<Plato, Integer> {
	
	/*@Modifying
	@Transactional
	@Query(value="DELETE FROM Platos de where de.id_plato =:idPlato",nativeQuery = true)
	void eliminarPlato(@Param("idPlatp") Integer idPlato);
	*/

}
