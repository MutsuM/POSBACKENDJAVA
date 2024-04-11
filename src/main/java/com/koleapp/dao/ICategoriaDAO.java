package com.koleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koleapp.model.Categoria;

@Repository
public interface ICategoriaDAO extends JpaRepository<Categoria, Integer> {

}
