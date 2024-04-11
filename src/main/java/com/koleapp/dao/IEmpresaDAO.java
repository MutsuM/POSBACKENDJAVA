package com.koleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.koleapp.model.Empresa;

@Repository
public interface IEmpresaDAO extends JpaRepository<Empresa, String>{
	
		//SE LISTAN ELEMENTOS EN UNA VENTA ASOCIADOS A UN PRODUCTO ANTES DE ELIMINAR
		@Query(value = "select * from empresa where id_empresa =:idEmpresa", nativeQuery = true)		
		Empresa traerDatos(@Param("idEmpresa") Integer idEmpresa);
		
		//SE LISTAN ELEMENTOS EN UNA VENTA ASOCIADOS A UN PRODUCTO ANTES DE ELIMINAR
		@Modifying
		@Query(value = "update empresa set logo=:logo, nombre_imagen=:nombreImagen, type=:type  where id_empresa =:idEmpresa", nativeQuery = true)		
		void actualizarImagen(@Param("idEmpresa") Integer idEmpresa, @Param("logo") byte[] logo, @Param("nombreImagen") String nombreImagen, @Param("type") String type);

}
