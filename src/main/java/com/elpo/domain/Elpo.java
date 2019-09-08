package com.elpo.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Model ELPO
 * @author Alex
 */
@SuppressWarnings("serial")
@Entity
public class Elpo extends GenericDomain{
	 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	private Integer totalScore;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id", nullable = true)
	private Paciente paciente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id", nullable = true)
	private TpPosicaoCirurgica tpPosicaoCirurgica;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id", nullable = true)
	private SuperficieSuporte superficieSuporte;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id", nullable = true)
	private TpCirurgia tpCirurgia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id", nullable = true)
	private PosicaoMembros posicaoMembros;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id", nullable = true)
	private TpAnestesia tpAnestesia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id", nullable = true)
	private IdadePaciente idadePaciente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id", nullable = true)
	private Comorbidade comorbidade;

	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public TpPosicaoCirurgica getTpPosicaoCirurgica() {
		return tpPosicaoCirurgica;
	}

	public void setTpPosicaoCirurgica(TpPosicaoCirurgica tpPosicaoCirurgica) {
		this.tpPosicaoCirurgica = tpPosicaoCirurgica;
	}

	public SuperficieSuporte getSuperficieSuporte() {
		return superficieSuporte;
	}

	public void setSuperficieSuporte(SuperficieSuporte superficieSuporte) {
		this.superficieSuporte = superficieSuporte;
	}

	public TpCirurgia getTpCirurgia() {
		return tpCirurgia;
	}

	public void setTpCirurgia(TpCirurgia tpCirurgia) {
		this.tpCirurgia = tpCirurgia;
	}

	public PosicaoMembros getPosicaoMembros() {
		return posicaoMembros;
	}

	public void setPosicaoMembros(PosicaoMembros posicaoMembros) {
		this.posicaoMembros = posicaoMembros;
	}

	public TpAnestesia getTpAnestesia() {
		return tpAnestesia;
	}

	public void setTpAnestesia(TpAnestesia tpAnestesia) {
		this.tpAnestesia = tpAnestesia;
	}

	public IdadePaciente getIdadePaciente() {
		return idadePaciente;
	}

	public void setIdadePaciente(IdadePaciente idadePaciente) {
		this.idadePaciente = idadePaciente;
	}

	public Comorbidade getComorbidade() {
		return comorbidade;
	}

	public void setComorbidade(Comorbidade comorbidade) {
		this.comorbidade = comorbidade;
	}
	
}
