package com.koleapp.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koleapp.model.Caja;

@Repository
public interface ICajaDAO extends JpaRepository<Caja, Integer> {
	
	//Metodo para traer el último ID de la caja	
	@Query(value="select MAX(idCaja) from caja",nativeQuery=true)
	int getLastId();

	//Metodo que trae la caja a operar
	@Query(value = "select * from caja where estado = true", nativeQuery=true)
	Caja getCajaActiva();
	
	//Metodo que lista todas las cajas cerradas para consulta
	@Query(value = "select * from caja where estado = false order by fechaapertura DESC", nativeQuery=true)
	List<Caja> getCajasHistorico();
	
	@Query(value = "select * from fn_resumencaja(:idCaja)", nativeQuery= true)
	List<Object[]> listarResumenCaja(@Param("idCaja") Integer idCaja);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE CAJA SET DESCUADRE =:descuadre, FECHACIERRE =:fechacierre, CAJA=:cajacierre, PROXIMACAJA =:proximacaja, INGRESONOVENTAS =:ingresonoventas"
			+ ", INGRESOVENTAS =:ingresoventas, ESTADO =:estado   WHERE IDCAJA =:idCaja", nativeQuery= true)
	void cierreCaja(@Param("idCaja") Integer idCaja, @Param("descuadre") Double descuadre,
			@Param("cajacierre") Double cajacierre,@Param("proximacaja") Double proximacaja, 
			@Param("fechacierre") LocalDateTime fechacierre,@Param("ingresonoventas") Double ingresonoventas,
			@Param("ingresoventas") Double ingresoventas,@Param("estado") Boolean estado);
	
	@Query(value = "select * from fn_resmovimientos(:idCaja)", nativeQuery= true)
	List<Object[]> listarMovimientoResumen(@Param("idCaja") Integer idCaja);
	
	
	@Query(value="select * from caja ORDER BY IDCAJA DESC LIMIT 1", nativeQuery=true)
	Caja getUltimacaja();
	
	
	

}
