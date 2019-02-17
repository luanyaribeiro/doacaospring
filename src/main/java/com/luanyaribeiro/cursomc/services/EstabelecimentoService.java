package com.luanyaribeiro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.luanyaribeiro.cursomc.domain.Estabelecimento;
import com.luanyaribeiro.cursomc.dto.EstabelecimentoDTO;
import com.luanyaribeiro.cursomc.repositories.EstabelecimentoRepository;
import com.luanyaribeiro.cursomc.services.exception.DataIntegratyException;

@Service
public class EstabelecimentoService {
	
	@Autowired
	private EstabelecimentoRepository repo;
	
	public Estabelecimento find(String cnpj) {
		Optional<Estabelecimento> obj = repo.findById(cnpj);
		return obj.orElse(null);
	}

	public Estabelecimento insert(Estabelecimento obj) {
		return repo.save(obj);
	}
	
	public Estabelecimento update(Estabelecimento obj) {
		find(obj.getCnpj());
		return repo.save(obj);
	}
	
	public void delete(String cnpj) {
		try {
			repo.deleteById(cnpj);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegratyException("Não é possível excluir uma Estabelecimento que possui medicamentos");
		}
	}
	
	public Estabelecimento fromDTO(EstabelecimentoDTO objDTO) {
		return new Estabelecimento(objDTO.getCnpj(), objDTO.getCnes(), objDTO.getNome(), objDTO.getSigla(), objDTO.getNomeConta());
	}
	
	


}
