package com.koleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koleapp.model.Proveedor;

@Repository
public interface IProveedorDAO extends JpaRepository<Proveedor, Integer>  {

}
