package com.elpo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Comorbidades
 * @author Alex
 */
@SuppressWarnings("serial")
@Entity
public class Comorbidade extends GenericDomain {
	
	// Obs posso validar aqui uma mensagem para cada atributo ou personalizar num arquivo ValidationMessages.properties 
	// em conjunto com o messages.properties para modificações dos nomes dos atributos quando necessário
    @NotNull
    @Size(min = 3, max = 200)
    @Column(nullable = false)
    private String descricao;
    
    @NotNull(message = "O campo SCORE é obrigatório.")
    @Column(nullable = false)
    private Integer score;
    
    /**
     * Método Cosntrutor Vazio
     */
    public Comorbidade() {}
    
    /**
     * Método Construtor com atributos
     * @param descricao
     * @param score
     */
    public Comorbidade(@NotNull @Size(min = 3, max = 200) String descricao,
			@NotNull(message = "O campo SCORE é obrigatório.") Integer score) {
		super();
		this.descricao = descricao;
		this.score = score;
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
}
