package com.koleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koleapp.model.PlatoComplemento;

@Repository
public interface PlatosComplementoDAO extends JpaRepository<PlatoComplemento, Integer> {

}
