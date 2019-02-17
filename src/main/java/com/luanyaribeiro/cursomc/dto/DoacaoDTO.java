package com.luanyaribeiro.cursomc.dto;

import java.io.Serializable;

import com.luanyaribeiro.cursomc.domain.Doacao;

public class DoacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer codDoacao;
	private String descricao;
	
	public DoacaoDTO() {
	}
	
	public DoacaoDTO(Doacao doacao) {
		this.codDoacao = doacao.getCodDoacao();
		this.descricao = doacao.getDescricao();
	}

	public Integer getCodDoacao() {
		return codDoacao;
	}

	public void setCodDoacao(Integer codDoacao) {
		this.codDoacao = codDoacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
