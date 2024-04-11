package com.koleapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koleapp.dao.ICategoriaDAO;
import com.koleapp.model.Categoria;
import com.koleapp.model.Clientes;
import com.koleapp.service.ICategoriaService;

@Service
public class ICategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaDAO dao;
	
	
	@Override
	public void registrar(Categoria categoria) {
		// TODO Auto-generated method stub
		dao.save(categoria);
	}

	@Override
	public void modificar(Categoria categoria) {
		// TODO Auto-generated method stub
		dao.save(categoria);
	}

	@Override
	public void eliminar(int idCategoria) {
		// TODO Auto-generated method stub
		dao.deleteById(idCategoria);
		
	}

	@Override
	public Categoria listarId(int idCategoria) {
		// TODO Auto-generated method stub
		//return dao.findOne(idCategoria);
		
		
		Optional<Categoria> opt = dao.findById(idCategoria);
		return opt.isPresent() ? opt.get() : new Categoria();
	}

	@Override
	public List<Categoria> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	
}
