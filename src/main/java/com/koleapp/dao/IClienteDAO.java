package com.koleapp.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koleapp.model.Clientes;

@Repository
public interface IClienteDAO extends JpaRepository<Clientes, Integer> {	
	@Query(value="select * from clientes where upper(nombres) like ?1 or  upper(apellidopat) like ?1 or upper(apellidomat) like  ?1",nativeQuery=true)
	List<Clientes> getClientesMatch(String dato);
}