package com.koleapp.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.koleapp.dao.EstadisticasDAO;
import com.koleapp.dto.EmpleadoDetalleDTO;
import com.koleapp.dto.EmpleadoDetalleResumenDTO;
import com.koleapp.dto.EstadisticasDTO;
import com.koleapp.service.IEstadisticasService;

@Service
public class IEstadisticasServiceImpl implements IEstadisticasService {
	
	@PersistenceContext
    private EntityManager em;
	
	@Autowired 
	private EstadisticasDAO estaDAO;

	
	
	//METODO PARA LISTAR LAS VENTAS DE FORMA GENERAL
	@Override
	public List<EstadisticasDTO> listarVentas(EstadisticasDTO esta) {
		
		
		
		ArrayList<String> mesesLista = new ArrayList<>();
		mesesLista.add(" ");//COMODIN, LA BASE DE DATOS RETORNA DE 1 A 12, TODA LISTA EMPIEZA DESDE 0, ENTONCES NE LOS LOOPS SE TOMA EN CUENTA DESDE 1
		mesesLista.add("ENERO");
		mesesLista.add("FEBRERO");
		mesesLista.add("MARZO");
		mesesLista.add("ABRIL");
		mesesLista.add("MAYO");
		mesesLista.add("JUNIO");
		mesesLista.add("JULIO");
		mesesLista.add("AGOSTO");
		mesesLista.add("SEPTIEMBRE");
		mesesLista.add("OCTUBRE");
		mesesLista.add("NOVIEMBRE");
		mesesLista.add("DICIEMBRE");
		
				
		ArrayList<Double> totalLista = new ArrayList<>();
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
													
		List<EstadisticasDTO> listaElementos = this.estaDAO.listarVentas(esta);					
			for (EstadisticasDTO estaReturn : listaElementos) {											
				int indice = mesesLista.indexOf(estaReturn.getMes().toUpperCase());
				if (indice != -1) {					
					totalLista.set(indice, estaReturn.getTotal());
				} 							
			}
			List<EstadisticasDTO> listaElementosResultante= new ArrayList<>();
			for (int i = 1; i < totalLista.size(); i++) {
				EstadisticasDTO estaD= new EstadisticasDTO();
				estaD.setMes(mesesLista.get(i));
				estaD.setTotal(totalLista.get(i));
				listaElementosResultante.add(estaD);
			}		
		return listaElementosResultante;				
	}
	
	public List<EstadisticasDTO> listarVentasResumen(EstadisticasDTO esta) {		
		List<EstadisticasDTO> listaElementos = this.estaDAO.listarVentasResumen(esta);		
		return listaElementos;
	}
	
public List<EstadisticasDTO> listarVentasEmpleados(EstadisticasDTO esta) {		
		List<EstadisticasDTO> listaElementos = this.estaDAO.listarVentasEmpleados(esta);		
		return listaElementos;
	}

@Override
public List<EstadisticasDTO> listarProductosEmpleados(EstadisticasDTO param) {
	List<EstadisticasDTO> listaElementos = this.estaDAO.listarProductosEmpleados(param);	
	return listaElementos;
}

@Override
public List<EstadisticasDTO> listarServiciosEmpleados(EstadisticasDTO param) {
	List<EstadisticasDTO> listaElementos = this.estaDAO.listarServiciosEmpleados(param);	
	return listaElementos;
	}

@Override
public EmpleadoDetalleResumenDTO listaDetalleEmpleado(EstadisticasDTO param) {
	// TODO Auto-generated method stub
	EmpleadoDetalleResumenDTO resumen = new EmpleadoDetalleResumenDTO();
	Double totalServicios=0.0;
	Double totalProductos=0.0;
	Double totalaPagar=0.0;
	
	List<EmpleadoDetalleDTO> listaElementos = this.estaDAO.listarPagoEmpleado(param);
	for (EmpleadoDetalleDTO empleadoDetalleDTO : listaElementos) {	
		if(!StringUtils.isEmpty(empleadoDetalleDTO.getTipoElemento())) {
			if(empleadoDetalleDTO.getTipoElemento().equals("1")) {
				totalServicios+=totalServicios+ Double.parseDouble(empleadoDetalleDTO.getValorVenta());
			}else {
				totalProductos=+totalProductos+ Double.parseDouble(empleadoDetalleDTO.getValorVenta());
			}	
		}	
		totalaPagar+=totalaPagar+Double.parseDouble(empleadoDetalleDTO.getValorAPagar());		
	}
	resumen.setListaEmpleadoDetalle(listaElementos);
	
	resumen.setTotalProductos(String.valueOf(totalProductos));
	resumen.setTotalServicios(String.valueOf(totalServicios));
	resumen.setTotalAPagar(String.valueOf(totalaPagar));
	
	
	return resumen;
}


}