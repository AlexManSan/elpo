package com.elpo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.elpo.domain.Recomendacoes;
import com.elpo.domain.TpPosicaoCirurgica;

public interface RecomendacoesRepository extends JpaRepository<Recomendacoes, Long>{

//	outra opção com os próprios atributos 
//	public List<Comorbidade> findAllOrderByDescricaoAsc();
	
	@Query("select r from Recomendacoes r ORDER BY r.regiaoCorpo ASC")
	public List<Recomendacoes> findAllOrderRegiaoCorpoAsc();
	
	@Transactional(readOnly=true)
	public List<Recomendacoes> findByTpPosicaoCirurgica(TpPosicaoCirurgica obj);
}
