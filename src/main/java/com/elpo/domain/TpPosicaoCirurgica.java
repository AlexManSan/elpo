package com.elpo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

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
    
    @NotNull(message = "O campo 'IMG' é obrigatório.")
    @Column(nullable = false)
    private String img;
    
// 	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tpPosicaoCirurgica")
// 	@Fetch(FetchMode.SUBSELECT)
// 	private List<Recomendacoes> recomendacoes;

 	/**
 	 * Método Construtor Vazio
 	 */
 	public TpPosicaoCirurgica() {}
 	
 	
    /**
     * Método cosntrutor com atributos
     * @param descricao
     * @param score
     * @param img
     * @param recomendacoes
     */
	public TpPosicaoCirurgica(@NotNull(message = "O campo 'DESCRIÇÃO' é obrigatório.") String descricao,
			@NotNull(message = "O campo 'SCORE' é obrigatório.") Integer score,
			@NotNull(message = "O campo 'IMG' é obrigatório.") String img) {
		super();
		this.descricao = descricao;
		this.score = score;
		this.img = img;
//		this.recomendacoes = recomendacoes;
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
    public String getImg() {
		return img;
	}
    public void setImg(String img) {
		this.img = img;
	}
//    public List<Recomendacoes> getRecomendacoes() {
//		return recomendacoes;
//	}
//    public void setRecomendacoes(List<Recomendacoes> recomendacoes) {
//		this.recomendacoes = recomendacoes;
//	}
}
