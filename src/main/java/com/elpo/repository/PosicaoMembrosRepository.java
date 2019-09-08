package com.elpo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elpo.domain.PosicaoMembros;

public interface PosicaoMembrosRepository extends JpaRepository<PosicaoMembros, Long>{
	
	@Query("select p from PosicaoMembros p ORDER BY p.descricao ASC")
	public List<PosicaoMembros> findAllOrderDescricaoAsc();
	
}
