package com.luanyaribeiro.cursomc.dto;

import java.io.Serializable;

public class EstabelecimentoDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private String cnes;
	private String nome;
	private String sigla;
	private String nomeConta;
	
	public EstabelecimentoDTO() {
	}
	
	public EstabelecimentoDTO(EstabelecimentoDTO obj) {
		this.cnpj = obj.getCnpj();
		this.cnes = obj.getCnes();
		this.nome = obj.getNome();
		this.sigla = obj.getSigla();
		this.nomeConta = obj.getNomeConta();
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
	
	

}
