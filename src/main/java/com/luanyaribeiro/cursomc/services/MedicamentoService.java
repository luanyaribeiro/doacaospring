package com.luanyaribeiro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanyaribeiro.cursomc.domain.Medicamento;
import com.luanyaribeiro.cursomc.repositories.MedicamentoRepository;

@Service
public class MedicamentoService {
	
	@Autowired
	private MedicamentoRepository repo;
	
	public Medicamento buscar(Integer codTUSS) {
		Optional<Medicamento> obj = repo.findById(codTUSS);
		return obj.orElse(null);
	}


}
