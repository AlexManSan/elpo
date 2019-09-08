package com.elpo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Model Paciente
 * @author Alex
 */
@SuppressWarnings("serial")
@Entity
public class Paciente extends GenericDomain{
	
	@NotNull
    @Size(min = 3, max = 20)
    @Column(nullable = false)
    private String nome;
    
    @NotNull(message = "O campo PRONTUÁRIO é obrigatório.")
    @Column(nullable = false)
    private Integer prontuario;
    
    /**
     * Construtor Vazio
     */
    public Paciente() {	}
    
    /**
     * Construtor com atributos
     * @param nome
     * @param prontuario
     */
	public Paciente(@NotNull @Size(min = 3, max = 20) String nome,
			@NotNull(message = "O campo PRONTUÁRIO é obrigatório.") Integer prontuario) {
		super();
		this.nome = nome;
		this.prontuario = prontuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getProntuario() {
		return prontuario;
	}

	public void setProntuario(Integer prontuario) {
		this.prontuario = prontuario;
	}
}
