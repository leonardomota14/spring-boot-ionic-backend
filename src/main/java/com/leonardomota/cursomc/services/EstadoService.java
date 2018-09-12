package com.leonardomota.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardomota.cursomc.domain.Estado;
import com.leonardomota.cursomc.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;

	public List<Estado> findAllByOrderByNome(){
		return repo.findAllByOrderByNome();
	}
}
