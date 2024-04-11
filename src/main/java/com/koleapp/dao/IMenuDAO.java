package com.koleapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koleapp.model.Menu;

@Repository
public interface IMenuDAO extends JpaRepository<Menu, Integer>{
	
	//nativequery =true, es para indicar que es codigo sql
	@Query(value="select m.* from menu_rol mr inner join usuario_rol ur on ur.id_rol = mr.id_rol inner join menu m on m.id_menu = mr.id_menu inner join usuario u on u.id_usuario = ur.id_usuario where u.nombre = :nombre", nativeQuery = true)
	List<Object[]> listarMenuPorUsuario(@Param("nombre") String nombre);
	//esto devuelve una listas de objetos
	//por defecto JPA  no sane el tipo de dato a devolver, por defecto entonces retorna una lista
	// de array  de objetos, como es una lista a devolver, se lista abajo las posiciones
	
	//0 | [ 1, 'serach', 'buscar', '/buscar']
	//1 | [ 2, 'register', 'registrar', '/consulta']
}
