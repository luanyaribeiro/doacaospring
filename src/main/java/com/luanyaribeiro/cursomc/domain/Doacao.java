package com.luanyaribeiro.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Doacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codDoacao;
	private String descricao;
	
	@OneToOne
	@JoinColumn(name="medicamento_codTUSS")
	private Medicamento medicamento;


	public Doacao() {
	}

	public Doacao(Integer codDoacao, String descricao) {
		super();
		this.codDoacao = codDoacao;
		this.descricao = descricao;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codDoacao == null) ? 0 : codDoacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doacao other = (Doacao) obj;
		if (codDoacao == null) {
			if (other.codDoacao != null)
				return false;
		} else if (!codDoacao.equals(other.codDoacao))
			return false;
		return true;
	}
	
	
}
