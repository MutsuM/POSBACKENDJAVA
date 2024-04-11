package com.koleapp.service.impl;



import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.koleapp.dao.ICajaDAO;
import com.koleapp.dao.IDetalleVentasDAO;
import com.koleapp.dao.IProductosDAO;
import com.koleapp.dao.IServiciosDAO;
import com.koleapp.dao.IVentasDAO;
import com.koleapp.dto.CriteriosConsultaVentasDTO;
import com.koleapp.dto.TicketDTO;
import com.koleapp.model.Caja;
import com.koleapp.model.Clientes;
import com.koleapp.model.DetalleVentas;
import com.koleapp.model.Empleados;
import com.koleapp.model.FormaPagoVenta;
import com.koleapp.model.MovimientosCaja;
import com.koleapp.model.TipoMovimiento;
import com.koleapp.model.Ventas;
import com.koleapp.service.ICajaService;
import com.koleapp.service.IDetalleVentaService;
import com.koleapp.service.IMovimientoCajaService;
import com.koleapp.service.IVentaService;
import com.koleapp.util.Constantes;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class IVentaServiceImpl implements IVentaService {

	@Autowired
	private IVentasDAO dao;

	@Autowired
	private IProductosDAO daoProductos;

	@Autowired
	private IServiciosDAO daoServicios;

	@Autowired
	private ICajaService cajaService;

	@Autowired
	private IMovimientoCajaService movimientoService;

	@Autowired
	private IDetalleVentaService detalleVentaService;
	
	
	@Autowired
	private IDetalleVentasDAO daoDetalleVenta;	
	
	
	@PersistenceContext
    private EntityManager em;
	
	private Constantes constantes;
	
	//VALORES 
	//valor 1=servicios, 2=productos,3=gift card 
		
	@Transactional
	@Override
	public Ventas registrar(Ventas ventas) {
		// TODO Auto-generated method stub
		
		LocalDateTime fecha = LocalDateTime.now();//la fecha es automática, no se selecciona en el FRONT
		Ventas ve = new Ventas();
		ve.setFecha(fecha);
		ventas.setFecha(fecha);
		ventas.getDetalleVenta().forEach(x -> x.setVenta(ventas));
		ve = dao.save(ventas);

		// por cada venta realizada, se registrará un movimiento en caja
		// Si la venta es pago en efectivo, se realizará como movimiento en caja
		// id de la venta
		// id de caja
		if (1 == ventas.getPagoVenta().getIdFormapagoventa()) {// 1 = tipo de pago efectivo
			this.movimientoService.registrarFromVenta(ventas);
		}

		return dao.save(ve);
	}

	@Transactional
	@Override
	public void modificar(Ventas ventas) {
		// solo se debe permitir la edición de las ventas de la caja del día, no de las cajas pasadas
					
		//obtener el ID de la venta
		Ventas ve = new Ventas();		
		ve.setDetalleVenta(ventas.getDetalleVenta());
		ve.setCliente(ventas.getCliente());
		ve.setDescuento(ventas.getDescuento());
		ve.setEmpleado(ventas.getEmpleado());
		ve.setImpuesto(ventas.getImpuesto());
		ve.setFecha(ventas.getFecha());//validar si se obtiene la fecha del front o se deja la fecha del sistema
		ve.setNotas(ventas.getNotas());
		ve.setTotal(ventas.getTotal());
		ve.setPagoVenta(ventas.getPagoVenta());
		ve.setSubtotal(ventas.getSubtotal());
		
		
		//eliminar los detalles de la venta
		this.detalleVentaService.eliminarDetallesVenta(ventas.getIdVenta());
					
		//eliminar el movimiento de caja asociado a la venta
		this.movimientoService.eliminarMovimientoVenta(ventas.getIdVenta());
		this.dao.eliminarVenta(ventas.getIdVenta());
		//this.registrar(ve);								
		//debería actualizar las ventas
		
		
		Ventas veUpdate = new Ventas();
		ve.getDetalleVenta().forEach(x -> x.setVenta(ve));
		veUpdate = dao.save(ve);

		
		if (constantes.TIPO_PAGO_VENTA_EFECTIVO == ve.getPagoVenta().getIdFormapagoventa()) {// 1 = tipo de pago efectivo
			this.movimientoService.registrarFromVenta(ve);
		}
		
					
	}

	@Override
	public void eliminar(int idVenta) {
		// TODO Auto-generated method stub
		dao.deleteById(idVenta);
	}

	@Override
	public Ventas listarId(int idVenta) {
		// TODO Auto-generated method stub

		Optional<Ventas> opt = dao.findById(idVenta);
		return opt.isPresent() ? opt.get() : new Ventas();

	}

	@Override
	public List<Ventas> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<DetalleVentas> listarDetalle(Integer idVenta) {
		// TODO Auto-generated method stub

		List<DetalleVentas> listaDetalle = new ArrayList<DetalleVentas>();
		listaDetalle = detalleVentaService.listarDetalle(idVenta);

		// recorrer por cada lista y obtener la descripción del producto/servicio y
		// asignarlo a cada elemento
		for (DetalleVentas detalleVentas : listaDetalle) {

			Integer idItem = detalleVentas.getTipoItem().getIdTipoDetalleventas();
			String descripcion;
			switch (idItem) {
			case 1:// si es servicio
				descripcion = this.daoServicios.getDescripcion(detalleVentas.getIdItem());
				detalleVentas.setDescripcion(descripcion);
				break;

			case 2:// si es productos
				descripcion = this.daoProductos.getDescripcion(detalleVentas.getIdItem());
				detalleVentas.setDescripcion(descripcion);
				break;
			default:
				descripcion="SIN DATOS";
			}
		}

		return detalleVentaService.listarDetalle(idVenta);
	}

	@Override
	public byte[] generarReporte(Integer idVenta) {
		
		//consulta de la venta por ID
		
		//Optional<Mapas> opt= iMapas.findById(idMapas);
		//return opt.isPresent()?opt.get():new Mapas();
		
		Optional<Ventas> opt= this.dao.findById(idVenta);		
		System.out.println(opt.get());
		
		
		System.out.println();
		
		HashMap param= new HashMap<>();
		param.put("cliente", opt.get().getCliente().getNombres()+" "+opt.get().getCliente().getApellidoPat() + " "+opt.get().getCliente().getApellidoMat());
		param.put("boleta","#"+opt.get().getIdVenta());
		param.put("fecha","#"+opt.get().getFecha());
		
		
		//param.put("cliente", "Leslie Sanchez Tirado" );
		//param.put("boleta", "#11111" );
		//param.put("fecha", "10/01/2020" );
		
		
		
		List<TicketDTO> lista= new ArrayList<>();
					
		StringBuilder str = new StringBuilder();
		str.append("SELECT de.precioventa,CASE WHEN de.id_tipodetalleventa = 1 THEN ser.descripcion WHEN de.id_tipodetalleventa = 2 THEN pro.descripcion END AS descripcion ");
		str.append("FROM   detalleventas de LEFT JOIN productos pro ON pro.id_productos = de.id_item LEFT JOIN servicios ser ON ser.id_servicios = de.id_item ");
		str.append("WHERE DE.ID_VENTA = ");
		str.append(idVenta);
		
		//SE TRAEN LOS VALORES DE LA BASE DE DATOS
		List<Object[]> detalles= em.createNativeQuery(str.toString()).getResultList();
		
		//RECORRO EL LISTADO DEL DETALLE Y LO ASIGNO AL VALOR DE TICKETDTO PARA ENVIARLO AL REPORTE
		detalles.stream().forEach((record)->{
			TicketDTO ti = new TicketDTO();
			ti.setServicio((String)record[1]);
			ti.setPrecio((Double)record[0]);
			lista.add(ti);					
		});
				
		byte[] data = null;
		try {
			
			//String reportPath = "E:\\CURSOS ONLINE\\Mitocode\\Java Full Stack\\Semana 6\\mediapp-backend\\src\\main\\resources\\reports";

			// Compile the Jasper report from .jrxml to .japser
			//JasperReport jasperReport = JasperCompileManager.compileReport(reportPath + "\\report.jrxml");
			
			File file = new ClassPathResource("/reports/reporte.jasper").getFile();
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(lista);

			//JasperPrint print = JasperFillManager.fillReport(jasperReport, null,jrBeanCollectionDataSource);
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), param, new JRBeanCollectionDataSource(lista));
			data = JasperExportManager.exportReportToPdf(print);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<Ventas> listarCriterio(CriteriosConsultaVentasDTO criterio) {
		List<Ventas> listaV=null;
		
		//public List<Ventas> listarCriterio() {

		//VARIABLES
		//fecha desde
		//fecha hasta
		//numero de ticket
		//nombre del cliente
		//apellidos del cliente
		//empleado
		 boolean condicion=false;
		
		//1.VALIDAR PARAMETROS A CONSULTAR
		StringBuilder strSQL = new StringBuilder();
		
		//SE ARMA LA CONSULTA
		strSQL.append("SELECT VE.ID_VENTA FROM VENTAS VE WHERE ");		
		
		//SE ARMAN LOS CRITERIOS
		if(criterio.getFechaDesde() != null) {
			if(condicion) {
				strSQL.append(" AND ");
			}
			strSQL.append(" VE.fecha >= ");
			strSQL.append("'");
			strSQL.append(criterio.getFechaDesde());
			strSQL.append("'");
			condicion=true;
		}
		if(criterio.getFechaHasta() != null) {
			if(condicion) {
				strSQL.append(" AND ");
			}
			strSQL.append(" VE.fecha <= ");
			strSQL.append("'");
			strSQL.append(criterio.getFechaHasta());
			strSQL.append("'");
		}		
		//SI SE RECIBE UN NÚMERO DE TICKET, SOLO SE HARÁ LA CONSULTA POR ESTE VALOR Y SE ANULA EL RESTO
		if(criterio.getNumeroTicket() != null) {
			if(condicion) {
				strSQL.append(" AND ");
			}
			strSQL.append(" VE.id_venta = ");
			strSQL.append(criterio.getNumeroTicket());
		}
		if(criterio.getIdEmpleado() != null) {
			if(condicion) {
				strSQL.append(" AND ");
			}
			strSQL.append(" VE.id_empleado = ");
			strSQL.append(criterio.getIdEmpleado());
		}
		
		System.out.println("SQL:"+strSQL.toString());
		
							
				
		List<Integer> list = new ArrayList<>();//LISTADO DONDE SE ALMACENARAN LOS IDS DE VENTA ENCONTRADOS		
		List<Integer> resultado = em.createNativeQuery(strSQL.toString()).getResultList();
		resultado.stream().forEach((record)->{
			System.out.println(record);
			list.add(record);			
		});
		
		if(!resultado.isEmpty()) {
			 listaV = dao.getVentasCriterio(list);						
			return listaV;
		}else {
			return listaV;
		}			
	}	
}
