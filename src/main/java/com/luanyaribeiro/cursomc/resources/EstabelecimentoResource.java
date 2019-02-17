package com.luanyaribeiro.cursomc.resources;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luanyaribeiro.cursomc.domain.Estabelecimento;
import com.luanyaribeiro.cursomc.dto.EstabelecimentoDTO;
import com.luanyaribeiro.cursomc.services.EstabelecimentoService;

@RestController
@RequestMapping(value="/estabelecimentos")
public class EstabelecimentoResource {

	@Autowired
	private EstabelecimentoService service;

	@RequestMapping(value="/{cnpj}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String cnpj) {
		Estabelecimento obj = service.find(cnpj);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{cnpj}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody EstabelecimentoDTO objDTO, @PathVariable String cnpj) {
		Estabelecimento obj = service.fromDTO(objDTO);
		obj.setCnpj(cnpj);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{cnpj}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String cnpj) {
		service.delete(cnpj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody EstabelecimentoDTO objDTO) {
		Estabelecimento obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				  .path("/{cnpj}").buildAndExpand(obj.getCnpj()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
