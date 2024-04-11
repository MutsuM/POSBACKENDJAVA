package com.koleapp.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koleapp.dao.IMovimientoCajaDAO;
import com.koleapp.model.Caja;
import com.koleapp.model.Empleados;
import com.koleapp.model.MovimientosCaja;
import com.koleapp.model.Productos;
import com.koleapp.model.TipoMovimiento;
import com.koleapp.model.Ventas;
import com.koleapp.service.ICajaService;
import com.koleapp.service.IMovimientoCajaService;

@Service
public class IMovimientosCajaImpl implements IMovimientoCajaService {
	
	@Autowired
	private ICajaService cajaService;
		
	@Autowired
	private IMovimientoCajaDAO dao;;

	@Override
	public void registrar(MovimientosCaja movi) {
		//TipoMovimiento tMov = new TipoMovimiento();
		//tMov.setIdTipomov(2);
		
		 /*
		 1	"EXTRACCIÓN"
		 2	"VENTA"
		 3	"INGRESO"
	  	 4	"DEUDA"
		 5	"APERTURA DE CAJA"
		 6	"CIERRE DE CAJA"		 		 	
		 */
					
		//id operación = 0, CUANDO NO SE REGISTRA DE UNA VENTA
		
		// se tiene que validar si la caja está abierta o cerrada para permitir o no movimientos		
		LocalDateTime fecha = LocalDateTime.now();
		
		
		
		if(movi.getCaja()==null){			
			Caja caja= new Caja();
			caja.setIdCaja(this.cajaService.getLastId());
			movi.setCaja(caja);	
			
		}			
		movi.setFecha(fecha);
		dao.save(movi);						
	}

	@Override
	public void modificar(MovimientosCaja movi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(MovimientosCaja movi) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public List<MovimientosCaja> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	

	@Override
	public MovimientosCaja listarId(int idMovimiento) {
		// TODO Auto-generated method stub
		//return dao.findOne(idMovimiento);
		
		Optional<MovimientosCaja> opt = dao.findById(idMovimiento);
		return opt.isPresent() ? opt.get() : new MovimientosCaja();	
		
		
	}

	//metodo para registrar movimientos desde ventas de tipo efectivo
	@Override
	public void registrarFromVenta(Ventas ventas) {
		
		//valores de la forma de pago, 1 = efectivo, 2 = tarjeta
		
		
		LocalDateTime fecha = LocalDateTime.now();			
		TipoMovimiento tMov = new TipoMovimiento();
		tMov.setIdTipomov(2);//tipo 2 = venta, 1 = extracción, 3 = ingreso, 4 = deuda
		MovimientosCaja movC= new MovimientosCaja();
		Caja caja= new Caja();
		caja.setIdCaja(this.cajaService.getLastId());//obtienes el valor de la última caja abierta, que debe ser sobre la cual se está trabajando
		movC.setFecha(fecha);
		movC.setTipoMovimiento(tMov);
		movC.setIdOperacion(ventas.getIdVenta());
		movC.setEmpleados(ventas.getEmpleado());
		movC.setTotal(ventas.getTotal());
		movC.setCaja(caja);
		this.dao.save(movC);			
	}

	@Override
	public void eliminarMovimientoVenta(Integer idVenta) {
		this.dao.eliminarMovimiento(idVenta);
		
	}
	
	
	
	
}
