package com.elpo.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Recomendacoes extends GenericDomain{

	private String regiaoCorpo;
	private String recomendacoes;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private TpPosicaoCirurgica tpPosicaoCirurgica;
	
	/**
	 * Construtor Vazio
	 */
	public Recomendacoes() {}

	/**
	 * Construtor com atributos
	 * @param regiaoCorpo
	 * @param recomendacoes
	 * @param tpPosicaoCirurgica
	 */
	public Recomendacoes(String regiaoCorpo, String recomendacoes, TpPosicaoCirurgica tpPosicaoCirurgica) {
		super();
		this.regiaoCorpo = regiaoCorpo;
		this.recomendacoes = recomendacoes;
		this.tpPosicaoCirurgica = tpPosicaoCirurgica;
	}
	
	public String getRegiaoCorpo() {
		return regiaoCorpo;
	}
	public void setRegiaoCorpo(String regiaoCorpo) {
		this.regiaoCorpo = regiaoCorpo;
	}
	public String getRecomendacoes() {
		return recomendacoes;
	}
	public void setRecomendacoes(String recomendacoes) {
		this.recomendacoes = recomendacoes;
	}
	public TpPosicaoCirurgica getTpPosicaoCirurgica() {
		return tpPosicaoCirurgica;
	}
	public void setTpPosicaoCirurgica(TpPosicaoCirurgica tpPosicaoCirurgica) {
		this.tpPosicaoCirurgica = tpPosicaoCirurgica;
	}
	
}
