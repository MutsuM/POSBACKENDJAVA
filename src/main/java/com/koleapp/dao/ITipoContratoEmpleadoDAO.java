package com.koleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koleapp.model.TipoContratoEmpleados;

@Repository
public interface ITipoContratoEmpleadoDAO extends JpaRepository<TipoContratoEmpleados, String> {

	
}
