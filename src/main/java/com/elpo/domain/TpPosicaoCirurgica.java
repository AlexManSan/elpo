package com.elpo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Tipo de Posição Cirurgica
 * @author Alex
 */
@SuppressWarnings("serial")
@Entity
public class TpPosicaoCirurgica extends GenericDomain {
    
    @NotNull(message = "O campo 'DESCRIÇÃO' é obrigatório.")
    @Column(length = 100, nullable = false)
    private String descricao;
    
    @NotNull(message = "O campo 'SCORE' é obrigatório.")
    @Column(nullable = false)
    private Integer score;
    
 	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tpPosicaoCirurgica")
 	@Fetch(FetchMode.SUBSELECT)
 	private List<Recomendacoes> recomendacoes;

 	/**
 	 * Método Construtor Vazio
 	 */
 	public TpPosicaoCirurgica() {}
 	
 	/**
 	 * Método cosntrutor com atributos
 	 * @param descricao
 	 * @param score
 	 * @param recomendacoes
 	 */
    public TpPosicaoCirurgica(@NotNull(message = "O campo 'DESCRIÇÃO' é obrigatório.") String descricao,
			@NotNull(message = "O campo 'SCORE' é obrigatório.") Integer score, List<Recomendacoes> recomendacoes) {
		super();
		this.descricao = descricao;
		this.score = score;
		this.recomendacoes = recomendacoes;
	}
    
	public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
    public List<Recomendacoes> getRecomendacoes() {
		return recomendacoes;
	}
    public void setRecomendacoes(List<Recomendacoes> recomendacoes) {
		this.recomendacoes = recomendacoes;
	}
}
