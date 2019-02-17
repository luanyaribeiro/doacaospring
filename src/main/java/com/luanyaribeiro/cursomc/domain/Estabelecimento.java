package com.luanyaribeiro.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estabelecimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String cnpj;
	private String cnes;
	private String nome;
	private String sigla;
	private String nomeConta;
	
	@OneToMany(mappedBy="estabelecimento")
	List<Medicamento> medicamentos = new ArrayList<>();
	
	
	public Estabelecimento() {
	}

	public Estabelecimento(String cnpj, String cnes, String nome, String sigla, String nomeConta) {
		super();
		this.cnpj = cnpj;
		this.cnes = cnes;
		this.nome = nome;
		this.sigla = sigla;
		this.nomeConta = nomeConta;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCnes() {
		return cnes;
	}

	public void setCnes(String cnes) {
		this.cnes = cnes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Estabelecimento other = (Estabelecimento) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
	
	
}
