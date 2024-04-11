package com.koleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koleapp.model.FormaPago;

@Repository
public interface IFormaPagoProveedorDAO extends JpaRepository<FormaPago, Integer> {

}
