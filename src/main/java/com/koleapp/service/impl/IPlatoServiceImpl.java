package com.koleapp.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koleapp.dao.ComplementosDAO;
import com.koleapp.dao.PlatoDAO;
import com.koleapp.dao.PlatosComplementoDAO;
import com.koleapp.dto.PlatoDTO;
import com.koleapp.model.Plato;
import com.koleapp.model.PlatoComplemento;
import com.koleapp.service.PlatoService;

@Service
public class IPlatoServiceImpl implements PlatoService {

	@Autowired
	private PlatoDAO dao;
	
	@Autowired 
	private ComplementosDAO complementoDAO;
	
	@Autowired
	private PlatosComplementoDAO pCompDAO;
	
	@Autowired(required = true)
	private ModelMapper modelMapper;
	
	
	@Override
	@Transactional
	public Plato registrar(PlatoDTO plato) {
		// TODO Auto-generated method stub
		
		int[] comp=plato.getComplementos();
		Plato plat = modelMapper.map(plato, Plato.class);
		//Si se guarda bien el plato, obtenemos el ID y seteamos los complementos
		this.dao.save(plat);
		
		
		//recorremos si tiene complementos
		if(comp.length>0) {
			for (int i : comp) {				
				PlatoComplemento pl = new PlatoComplemento();
				pl.setId_complemento(i);
				pl.setId_plato(plato.getIdPlato());
				this.pCompDAO.save(pl);
			}
			
		}
		return plat;
	}

	@Override
	public void modificar(Plato plato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int idPlato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Plato listarId(int idPlato) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plato> listar() {
		// TODO Auto-generated method stub
		return this.dao.findAll();
	}

	
	
}
