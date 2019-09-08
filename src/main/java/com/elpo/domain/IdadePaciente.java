package com.elpo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Idade do Paciente
 * @author Alex
 */
@SuppressWarnings("serial")
@Entity
public class IdadePaciente extends GenericDomain {
    
    @NotNull(message = "O campo 'IDADE' é obrigatório.")
    @Column(length = 100, nullable = false)
    private String idade;
    
    @NotNull(message = "O campo 'SCORE' é obrigatório.")
    @Column(nullable = false)
    private Integer score;

    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
}
