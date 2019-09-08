package com.elpo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elpo.domain.SuperficieSuporte;

public interface SuperficieSuporteRepository extends JpaRepository<SuperficieSuporte, Long>{
	
	@Query("select s from SuperficieSuporte s ORDER BY s.descricao ASC")
	public List<SuperficieSuporte> findAllOrderDescricaoAsc();
	
}
