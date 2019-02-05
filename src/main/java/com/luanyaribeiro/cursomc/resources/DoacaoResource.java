package com.luanyaribeiro.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luanyaribeiro.cursomc.domain.Doacao;

@RestController
@RequestMapping(value="/doacoes")
public class DoacaoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Doacao> listar() {
		
		Doacao doa1 = new Doacao(1,"Paracetamol");
		Doacao doa2 = new Doacao(2,"Polaramine");
		
		List<Doacao> lista = new ArrayList<>();
		lista.add(doa1);
		lista.add(doa2);
		
		return lista;
	}

}
