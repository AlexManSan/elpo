package com.elpo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Posição dos Membros
 * @author Alex
 */
@SuppressWarnings("serial")
@Entity
public class PosicaoMembros extends GenericDomain {
    
    @NotNull(message = "O campo 'DESCRIÇÃO' é obrigatório.")
    @Column(nullable = false)
    private String descricao;
    
    @NotNull(message = "O campo 'SCORE' é obrigatório.")
    @Column(nullable = false)
    private Integer score;

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
