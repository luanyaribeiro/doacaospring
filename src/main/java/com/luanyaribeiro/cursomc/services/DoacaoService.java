package com.luanyaribeiro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.luanyaribeiro.cursomc.domain.Doacao;
import com.luanyaribeiro.cursomc.dto.DoacaoDTO;
import com.luanyaribeiro.cursomc.repositories.DoacaoRepository;
import com.luanyaribeiro.cursomc.services.exception.DataIntegratyException;
import com.luanyaribeiro.cursomc.services.exception.ObjectNotFoundException;

@Service
public class DoacaoService {
	
	@Autowired
	private DoacaoRepository repo;
	
	public Optional<Doacao> find(Integer id) {
		Optional<Doacao> obj = repo.findById(id);
		
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id
					+ " Tipo: " + Doacao.class.getName());
		} else {
			return obj;
		}
	}
	
	public Doacao insert(Doacao obj) {
		obj.setCodDoacao(null);
		return repo.save(obj);
	}
	
	public Doacao update(Doacao obj) {
		find(obj.getCodDoacao());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegratyException("Não é possível excluir uma Doacao que possui um medicamento");
		}
	}
	
	public Doacao fromDTO(DoacaoDTO objDTO) {
		return new Doacao(objDTO.getCodDoacao(), objDTO.getDescricao());
	}
	
}
