package com.koleapp.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.koleapp.model.Complementos;

@Repository
public interface ComplementosDAO extends JpaRepository<Complementos, Integer> {
	
	
	

}
