package com.koleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koleapp.model.FormaPagoVenta;

@Repository
public interface IFormaPagoVentaDAO extends JpaRepository<FormaPagoVenta, Integer> {

}
