package com.luanyaribeiro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luanyaribeiro.cursomc.domain.Doacao;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {

}
