package com.luanyaribeiro.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luanyaribeiro.cursomc.domain.Doacao;
import com.luanyaribeiro.cursomc.repositories.DoacaoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private DoacaoRepository doacaoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Doacao doa1 = new Doacao(null, "Paracetamol");
		Doacao doa2 = new Doacao(null, "Polaramine");
		
		doacaoRepository.saveAll(Arrays.asList(doa1, doa2));
	}

}

