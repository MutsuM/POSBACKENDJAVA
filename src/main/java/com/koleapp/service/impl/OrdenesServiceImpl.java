package com.koleapp.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.koleapp.dao.OrdenesDAO;
import com.koleapp.dao.PlatosOrdenDAO;
import com.koleapp.dto.ComandaDTO;
import com.koleapp.dto.OrdenesDTO;
import com.koleapp.model.Ordenes;
import com.koleapp.model.PlatosOrden;
import com.koleapp.service.OrdenesService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class OrdenesServiceImpl implements OrdenesService {

	// COCINA REGISTRA LAS ORDENES EN ESTADO 2
	// PEDIDOS DESDE LA WEB INGRESAN LAS ORDENES EN ESTADO 1

	@Autowired
	private OrdenesDAO ordenDAO;

	@Autowired
	private PlatosOrdenDAO plaOrdenDAO;

	@Autowired
	ModelMapper modelMapper;

	@Override
	@Transactional
	public Ordenes registrar(OrdenesDTO orden) {
		// TODO Auto-generated method stub
		Ordenes ord = modelMapper.map(orden, Ordenes.class);

		if (orden.getListaPlatos().size() > 0) {
			// guardamos la orden y obtenemos el ID
			this.ordenDAO.save(ord);

			// recorremos los platos y los guardamos
			List<PlatosOrden> lista = orden.getListaPlatos();
			for (PlatosOrden platosOrden : lista) {
				platosOrden.setIdOrden(ord.getIdOrden());
				this.plaOrdenDAO.save(platosOrden);
			}
		}
		return ord;
	}

	@Override
	public Ordenes actualizar(OrdenesDTO orden) throws Exception {
		// consultar el estado de la orden antes de hacer el cambio
		Optional<Ordenes> ord1 = this.ordenDAO.findById(orden.getIdOrden());
		try {

			if (orden.getListaPlatos().size() > 0) {

				// SOLO SI ESTADO ES MENOR A 3 (PREPARACIÓN) SE PERMITE LA ACTUALIZACIÓN, DE LO
				// CONTRARIO NO SE PERMITE EL CAMBIO
				if (ord1.get().getEstado().getIdEstado() < 3) {
					Ordenes ord = modelMapper.map(orden, Ordenes.class);
					// guardamos la orden y obtenemos el ID
					this.ordenDAO.save(ord);
					// recorremos los platos y los guardamos
					List<PlatosOrden> lista = orden.getListaPlatos();

					// eliminamos los platos asociados a la orden
					this.plaOrdenDAO.eliminarVenta(orden.getIdOrden());

					for (PlatosOrden platosOrden : lista) {
						// consultar cada plato si aún no ha iniciado su preparación y permitir su
						// eliminación de ser el caso
						platosOrden.setIdOrden(orden.getIdOrden());
						this.plaOrdenDAO.save(platosOrden);
					}

					return ord1.isPresent() ? ord1.get() : new Ordenes();

				} else {
					throw new Exception("No se puede actualizar la orden, consulta con el administrador");

				}
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
			// TODO: handle exception
		}
		return ord1.isPresent() ? ord1.get() : new Ordenes();

	}

	@Override
	@Transactional
	public void actualizarEstado(OrdenesDTO orden) throws Exception {
		this.ordenDAO.actualizarEstado(orden.getIdOrden(), orden.getEstado().getIdEstado());

	}

	@Override
	public List<Ordenes> listarOrdenes() {
		// TODO Auto-generated method stub
		return this.ordenDAO.findAll();
	}

	@Override
	public Ordenes listById(int idOrden) {
		// TODO Auto-generated method stub
		Optional<Ordenes> orden = this.ordenDAO.findById(idOrden);
		return orden.isPresent() ? orden.get() : new Ordenes();
	}

	@Override
	public byte[] generarReporte(int idOrden) {
		// TODO Auto-generated method stub

		List<ComandaDTO> lista = new ArrayList<>();
		Optional<Ordenes> orden = this.ordenDAO.findById(idOrden);
		HashMap param = new HashMap<>();
		List<Object[]> detalles = this.ordenDAO.getDetallesPlatoComanda(idOrden);
		detalles.stream().forEach((record) -> {
			ComandaDTO co = new ComandaDTO();
			co.setCantidad(record[0].toString());
			co.setNotas(record[1].toString());
			co.setPlato(record[2].toString());
			lista.add(co);

		});
		byte[] data = null;

		try {

			File file = new ClassPathResource("/reports/comanda.jasper").getFile();
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(lista);

			// JasperPrint print = JasperFillManager.fillReport(jasperReport,
			// null,jrBeanCollectionDataSource);
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), param,
					new JRBeanCollectionDataSource(lista));
			data = JasperExportManager.exportReportToPdf(print);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
