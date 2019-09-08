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