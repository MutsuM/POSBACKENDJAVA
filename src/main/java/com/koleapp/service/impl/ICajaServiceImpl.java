package com.koleapp.service.impl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koleapp.dao.ICajaDAO;
import com.koleapp.dao.IMovimientoCajaDAO;
import com.koleapp.dto.ResumenCajaDTO;
import com.koleapp.dto.ResumenMovimientosDTO;
import com.koleapp.model.Caja;
import com.koleapp.model.Empleados;
import com.koleapp.model.MovimientosCaja;
import com.koleapp.model.TipoMovimiento;
import com.koleapp.service.ICajaService;

@Service
public class ICajaServiceImpl implements ICajaService {
	
	@Autowired
	private ICajaDAO dao;
	
	@Autowired
	private IMovimientoCajaDAO moviDao;
	
	//METODO PARA REGISTRO DE UNA NUEVA CAJA Y MOVIMIENTO DE APERTURA
	@Transactional
	@Override
	public MovimientosCaja registrar(MovimientosCaja movimientoCaja) {
		// TODO Auto-generated method stub
		LocalDateTime fechaMovimiento = LocalDateTime.now();
		MovimientosCaja movi = new MovimientosCaja();
		TipoMovimiento tipoMovimiento = new TipoMovimiento();
		Empleados empleados = new Empleados();
		empleados.setIdEmpleado(movimientoCaja.getEmpleados().getIdEmpleado());
		tipoMovimiento.setIdTipomov(5);//se registra movimiento de tipo inicio de caja
		
		//REGISTRO DE CAJA CON METODO SAVEANDFLUSH 
		Caja caja= new Caja();
		caja.setFechaApertura(fechaMovimiento);
		//caja.setFechaCierre(fechaMovimiento);//para que n
		caja.setCajainicial(movimientoCaja.getTotal());
		caja.setEstado(true);			
		Caja toSave= dao.saveAndFlush(caja);		
					
		//LUEGO DE APERTURAR LA CAJA, REGISTRAR UN MOVIMIENTO CON EL TIPO APERTURA DE CAJA Y EL MONTO DE APERTURA							
		movi.setCaja(toSave);
		movi.setTipoMovimiento(tipoMovimiento);
		movi.setIdOperacion(0);//ID =0, VALOR CUANDO NO ESTA ASOCIADO A UNA VENTA
		movi.setFecha(fechaMovimiento);
		movi.setEmpleados(empleados);
		movi.setDescripcion(movimientoCaja.getDescripcion());
		movi.setTotal(movimientoCaja.getTotal());
		return moviDao.save(movi);
	}
	
	@Override
	public int getLastId() {
		// TODO Auto-generated method stub
		return dao.getLastId();
	}

	@Transactional
	@Override
	public void modificar(Caja caja) {
		// TODO Auto-generated method stub
		LocalDateTime fecha = LocalDateTime.now();		
		
		//INICIO - MOVIMIENTO CIERRRE			
		MovimientosCaja movi = new MovimientosCaja();
		TipoMovimiento tipoMovimiento = new TipoMovimiento();		
		Empleados emp = new Empleados();
		Caja cajaMov= new Caja();
		emp.setIdEmpleado(caja.getIdEmpleado());
		tipoMovimiento.setIdTipomov(6);
		cajaMov.setIdCaja(caja.getIdCaja());
									
		movi.setCaja(cajaMov);
		movi.setTipoMovimiento(tipoMovimiento);
		movi.setIdOperacion(0);//ID =0, VALOR CUANDO NO ESTA ASOCIADO A UNA VENTA
		movi.setFecha(fecha);
		movi.setEmpleados(emp);
		movi.setDescripcion("cierre de caja");
		movi.setTotal(caja.getCajacierre());
		moviDao.saveAndFlush(movi);
		//FIN REGISTRO MOVIMIENTO DE CIERRE
		
		
		Caja cajaUp= new Caja();
		cajaUp.setCajacierre(caja.getCajacierre());
		cajaUp.setDescuadre(caja.getDescuadre());
		cajaUp.setEstado(caja.getEstado());
		cajaUp.setFechaCierre(fecha);
		cajaUp.setIdCaja(caja.getIdCaja());
		cajaUp.setIngresosNoventas(caja.getIngresosNoventas());
		cajaUp.setIngresoVentas(caja.getIngresoVentas());					
		dao.cierreCaja(caja.getIdCaja(), caja.getDescuadre(), caja.getCajacierre(), caja.getProximacaja(), caja.getFechaCierre(),caja.getIngresosNoventas(),caja.getIngresoVentas(),caja.getEstado());
		//dao.save(cajaUp);
	}

	@Override
	public void eliminar(int idCaja) {
		// TODO Auto-generated method stub
		dao.deleteById(idCaja);
	}

	@Override
	public Caja listarId(int idCaja) {
		// TODO Auto-generated method stub				
		Optional<Caja> opt = dao.findById(idCaja);
		return opt.isPresent() ? opt.get() : new Caja();
	}

	@Override
	public List<Caja> listar() {
		// TODO Auto-generated method stub
		return dao.getCajasHistorico();
	}

	@Override
	public ResumenCajaDTO listarResumenCaja(int idCaja) {
		// TODO Auto-generated method stub		
		ResumenCajaDTO resumen = new ResumenCajaDTO();
		dao.listarResumenCaja(idCaja).forEach(x->{
			resumen.setIdcaja(Integer.parseInt(String.valueOf(x[0])));
			resumen.setVentasefectivo(Double.parseDouble(String.valueOf(x[1])));
			resumen.setIngresoscaja(Double.parseDouble(String.valueOf(x[2])));
			resumen.setCajainicial(Double.parseDouble(String.valueOf(x[3])));
			resumen.setEgresos(Double.parseDouble(String.valueOf(x[4])));	
			resumen.setCaja(Double.parseDouble(String.valueOf(x[5])));
			resumen.setDescuadre(Double.parseDouble(String.valueOf(x[6])));
			resumen.setProximacaja(Double.parseDouble(String.valueOf(x[7])));
		});				
		return resumen;
	}

	@Override
	public Caja getCajaActiva() {
		// TODO Auto-generated method stub
		
		return dao.getCajaActiva();
	}

	@Override
	public List<ResumenMovimientosDTO> listarMovimientoResumen(int idCaja) {
		
		
		List<ResumenMovimientosDTO> listaResumen = new ArrayList<ResumenMovimientosDTO>();
		dao.listarMovimientoResumen(idCaja).forEach(x->{
			ResumenMovimientosDTO resumen = new ResumenMovimientosDTO();
			resumen.setIdVenta(Integer.parseInt(String.valueOf(x[0])));
			resumen.setDetalledescripcion(String.valueOf(x[1]));
			resumen.setCliente(String.valueOf(x[2]));
			resumen.setEmpleado(String.valueOf(x[3]));
			resumen.setFecha(String.valueOf(x[4]));
			resumen.setTipomovimiento(String.valueOf(x[5]));
			resumen.setImporte(String.valueOf(x[6]));
			resumen.setFormapago(String.valueOf(x[7]));
			listaResumen.add(resumen);
		});
		
		return listaResumen;
	}

	@Override
	public Caja getUltimacaja() {
		// TODO Auto-generated method stub
		return dao.getUltimacaja();
	}
	
	
	
	
}
