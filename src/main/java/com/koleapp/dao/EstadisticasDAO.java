package com.koleapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.koleapp.dto.EmpleadoDetalleDTO;
import com.koleapp.dto.EstadisticasDTO;
import com.koleapp.model.Servicios;

@Repository
public class EstadisticasDAO {
	
	
	
	@PersistenceContext
    private EntityManager em;
		
		public List<EstadisticasDTO> listarVentas(EstadisticasDTO esta) {						
		StringBuilder strSQL = new StringBuilder();
		strSQL.append("SELECT CASE EXTRACT(MONTH FROM FECHA) ");
		strSQL.append("WHEN 1  THEN 'ENERO' ");
		strSQL.append("WHEN 2  THEN 'FEBRERO' ");
		strSQL.append("WHEN 3  THEN 'MARZO' ");
		strSQL.append("WHEN 4  THEN 'ABRIL' ");
		strSQL.append("WHEN 5  THEN 'MAYO' ");
		strSQL.append("WHEN 6  THEN 'JUNIO' ");
		strSQL.append("WHEN 7  THEN 'JULIO' ");
		strSQL.append("WHEN 8  THEN 'AGOSTO' ");
		strSQL.append("WHEN 9  THEN 'SEPTIEMBRE' ");
		strSQL.append("WHEN 10  THEN 'OCTUBRE' ");
		strSQL.append("WHEN 11  THEN 'NOVIEMBRE' ");
		strSQL.append("WHEN 12  THEN 'DICIEMBRE' ");
		strSQL.append("END AS MES, CAST(EXTRACT(MONTH FROM FECHA) AS INTEGER) ORDEN, SUM(TOTAL) AS TOTAL FROM VENTAS ");
		strSQL.append("WHERE FECHA BETWEEN ");
		strSQL.append("'");
		strSQL.append(esta.getFechaDesde());
		strSQL.append("'");
		strSQL.append(" AND ");
		strSQL.append("'");
		strSQL.append(esta.getFechaHasta());
		strSQL.append("'");
		strSQL.append(" GROUP BY 1,2 ORDER BY ORDEN ");	
		System.out.println(strSQL.toString());		
		List<EstadisticasDTO> listaElementos = new ArrayList<>();//LISTADO DONDE SE ALMACENARAN LOS IDS DE VENTA ENCONTRADOS		
		List<Object[]> resultado = em.createNativeQuery(strSQL.toString()).getResultList();
		resultado.stream().forEach((record)->{
			EstadisticasDTO dto = new EstadisticasDTO();
			dto.setMes((String) record[0]);
			dto.setOrden((Integer)record[1]);
			dto.setTotal((Double)record[2]);					
			listaElementos.add(dto);					
		});			
		return listaElementos;				
	}
		
	
		public List<EstadisticasDTO> listarVentasResumen(EstadisticasDTO esta) {			
			StringBuilder strSQL = new StringBuilder();
			strSQL.append("SELECT * FROM public.fn_estadistica_general(DATE('");
			strSQL.append(esta.getFechaDesde());
			strSQL.append("'),DATE('");
			strSQL.append(esta.getFechaHasta());
			strSQL.append("'))");			
			System.out.println(strSQL.toString());			
			List<EstadisticasDTO> listaElementos = new ArrayList<>();//LISTADO DONDE SE ALMACENARAN LOS IDS DE VENTA ENCONTRADOS
			List<Object[]> resultado = em.createNativeQuery(strSQL.toString()).getResultList();
			resultado.stream().forEach((record)->{
				EstadisticasDTO dto = new EstadisticasDTO();
				dto.setTotal((Double) record[0]);
				dto.setDescripcion((String) record[1]);												
				listaElementos.add(dto);				
			});						
			return listaElementos;
		}	
		
		
		public List<EstadisticasDTO> listarVentasEmpleados(EstadisticasDTO esta) {			
			StringBuilder strSQL = new StringBuilder();
			strSQL.append("SELECT * FROM public.fn_estadistica_empleados(DATE('");
			strSQL.append(esta.getFechaDesde());
			strSQL.append("'),DATE('");
			strSQL.append(esta.getFechaHasta());
			strSQL.append("'))");			
			System.out.println(strSQL.toString());			
			List<EstadisticasDTO> listaElementos = new ArrayList<>();//LISTADO DONDE SE ALMACENARAN LOS IDS DE VENTA ENCONTRADOS
			List<Object[]> resultado = em.createNativeQuery(strSQL.toString()).getResultList();
			resultado.stream().forEach((record)->{
				EstadisticasDTO dto = new EstadisticasDTO();
				dto.setMes((String )record[0]);
				dto.setOrden((Integer )record[1]);
				dto.setNombresEmpleado((String )record[2]);
				dto.setTotal((Double) record[3]);
				dto.setIdEmpleado((Integer )record[4]);												
				listaElementos.add(dto);				
			});						
			return listaElementos;
			
}
		
		public List<EstadisticasDTO> listarServiciosEmpleados(EstadisticasDTO esta) {			
			StringBuilder strSQL = new StringBuilder();
			strSQL.append(" SELECT   de.cantidad, ser.descripcion, de.importe from ventas ve ");
			strSQL.append(" left join detalleventas de on de.id_venta = ve.id_venta ");
			strSQL.append(" left join empleados em on em.id_empleado = ve.id_empleado ");
			strSQL.append(" left join servicios ser on ser.id_servicios = de.id_item ");
			strSQL.append(" WHERE EXTRACT(MONTH FROM VE.FECHA) = ");
			strSQL.append( esta.getIndiceMes() );
			strSQL.append(" AND ");
			strSQL.append(" em.id_empleado = ");
			strSQL.append( esta.getIdEmpleado() );			
			strSQL.append("AND EXTRACT(YEAR FROM VE.FECHA) =");
			strSQL.append( esta.getAño());
										
			System.out.println(strSQL.toString());			
			List<EstadisticasDTO> listaElementos = new ArrayList<>();//LISTADO DONDE SE ALMACENARAN LOS IDS DE VENTA ENCONTRADOS
			List<Object[]> resultado = em.createNativeQuery(strSQL.toString()).getResultList();
			
			resultado.stream().forEach((record)->{
				EstadisticasDTO dto = new EstadisticasDTO();				
				dto.setCantidad((Integer)record[0]);
				dto.setDescripcion((String)record[1]);
				dto.setTotal((Double)record[2]);															
				listaElementos.add(dto);				
			});						
			return listaElementos;
			
}
		
		
		
		public List<EstadisticasDTO> listarProductosEmpleados(EstadisticasDTO esta) {			
			StringBuilder strSQL = new StringBuilder();
			strSQL.append(" SELECT de.cantidad, pro.descripcion, de.importe, pro.preciocosto from ventas ve ");
			strSQL.append(" left join detalleventas de on de.id_venta = ve.id_venta ");
			strSQL.append(" left join empleados em on em.id_empleado = ve.id_empleado ");
			strSQL.append(" left join productos pro on pro.id_productos = de.id_item ");
			strSQL.append(" WHERE EXTRACT(MONTH FROM VE.FECHA) = ");
			strSQL.append( esta.getIndiceMes() );
			strSQL.append(" AND ");
			strSQL.append(" em.id_empleado = ");
			strSQL.append( esta.getIdEmpleado() );			
			strSQL.append("AND EXTRACT(YEAR FROM VE.FECHA) =");
			strSQL.append( esta.getAño());
			strSQL.append(" AND DE.ID_TIPODETALLEVENTA = 2");
										
			System.out.println(strSQL.toString());			
			List<EstadisticasDTO> listaElementos = new ArrayList<>();//LISTADO DONDE SE ALMACENARAN LOS IDS DE VENTA ENCONTRADOS
			List<Object[]> resultado = em.createNativeQuery(strSQL.toString()).getResultList();
			
			resultado.stream().forEach((record)->{
				EstadisticasDTO dto = new EstadisticasDTO();				
				dto.setCantidad((Integer)record[0]);
				dto.setDescripcion((String)record[1]);
				dto.setTotal((Double)record[2]);
				dto.setPrecioCosto((Double)record[3]);
				listaElementos.add(dto);				
			});						
			return listaElementos;
			
}
		
		
		
		public List<EmpleadoDetalleDTO> listarPagoEmpleado(EstadisticasDTO esta) {			
			StringBuilder strSQL = new StringBuilder();
			strSQL.append("SELECT * FROM public.fn_listado_pagos_empleado(DATE('");
			strSQL.append(esta.getFechaDesde());
			strSQL.append("'),DATE('");
			strSQL.append(esta.getFechaHasta());
			//strSQL.append("'))");
			strSQL.append("'),");
			strSQL.append(esta.getIdEmpleado());
			strSQL.append(")");
			System.out.println(strSQL.toString());			
			List<EmpleadoDetalleDTO> listaElementos = new ArrayList<>();//LISTADO DONDE SE ALMACENARAN LOS IDS DE VENTA ENCONTRADOS
			List<Object[]> resultado = em.createNativeQuery(strSQL.toString()).getResultList();
			resultado.stream().forEach((record)->{
				EmpleadoDetalleDTO dto = new EmpleadoDetalleDTO();				
				dto.setFecha((String )record[0]);
				dto.setTipoElemento((String )record[1]);				
				dto.setElemento((String )record[2]);
				dto.setPorcentaje((String )record[3]);
				dto.setValorVenta((String )record[4]);
				dto.setValorAPagar((String )record[5]);																	
				listaElementos.add(dto);				
			});									
			return listaElementos;
			
}
		
		
		
		
		
}