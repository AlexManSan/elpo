/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elpo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Tipos de Cirurgias
 * @author Alex
 */
@SuppressWarnings("serial")
@Entity
public class TpCirurgia extends GenericDomain {
    
    @NotNull(message = "O campo 'DESCRIÇÃO' é obrigatório.")
    @Column(length = 100, nullable = false)
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
