package com.elpo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elpo.domain.TpCirurgia;

public interface TpCirurgiaRepository extends JpaRepository<TpCirurgia, Long>{
	
	@Query("select c from TpCirurgia c ORDER BY c.descricao ASC")
	public List<TpCirurgia> findAllOrderDescricaoAsc();
	
}
