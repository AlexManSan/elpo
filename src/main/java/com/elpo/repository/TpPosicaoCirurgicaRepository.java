package com.elpo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elpo.domain.TpPosicaoCirurgica;

public interface TpPosicaoCirurgicaRepository extends JpaRepository<TpPosicaoCirurgica, Long>{
	
	@Query("select t from TpPosicaoCirurgica t ORDER BY t.descricao ASC")
	public List<TpPosicaoCirurgica> findAllOrderDescricaoAsc();
	
}
