package com.luanyaribeiro.cursomc.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Medicamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codTUSS;
	private String nomeComercial;
	private String nomeQuimico;
	private String substanciaAtiva;
	private String dataValidade;
	
	@ManyToOne
	@JoinColumn(name="estabelecimento_cnpj")
	private Estabelecimento estabelecimento;
	
	@OneToOne(mappedBy="medicamento")
	private Doacao doacao;
	
	public Medicamento() {
	}

	public Medicamento(Integer codTUSS, String nomeComercial, String nomeQuimico, String substanciaAtiva,
			String dataValidade) {
		super();
		this.codTUSS = codTUSS;
		this.nomeComercial = nomeComercial;
		this.nomeQuimico = nomeQuimico;
		this.substanciaAtiva = substanciaAtiva;
		this.dataValidade = dataValidade;
	}

	public Integer getCodTUSS() {
		return codTUSS;
	}

	public void setCodTUSS(Integer codTUSS) {
		this.codTUSS = codTUSS;
	}

	public String getNomeComercial() {
		return nomeComercial;
	}

	public void setNomeComercial(String nomeComercial) {
		this.nomeComercial = nomeComercial;
	}

	public String getNomeQuimico() {
		return nomeQuimico;
	}

	public void setNomeQuimico(String nomeQuimico) {
		this.nomeQuimico = nomeQuimico;
	}

	public String getSubstanciaAtiva() {
		return substanciaAtiva;
	}

	public void setSubstanciaAtiva(String substanciaAtiva) {
		this.substanciaAtiva = substanciaAtiva;
	}

	public LocalDate getDataValidade() {
		return LocalDate.parse(this.dataValidade);
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codTUSS == null) ? 0 : codTUSS.hashCode());
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
		Medicamento other = (Medicamento) obj;
		if (codTUSS == null) {
			if (other.codTUSS != null)
				return false;
		} else if (!codTUSS.equals(other.codTUSS))
			return false;
		return true;
	}
	
	
	
	
	

}
