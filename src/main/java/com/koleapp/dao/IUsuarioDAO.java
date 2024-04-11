package com.koleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koleapp.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {
	
	Usuario findOneByUsername(String username);
}