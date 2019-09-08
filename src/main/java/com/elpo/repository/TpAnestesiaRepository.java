package com.elpo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elpo.domain.TpAnestesia;

public interface TpAnestesiaRepository extends JpaRepository<TpAnestesia, Long>{
	
	@Query("select a from TpAnestesia a ORDER BY a.descricao ASC")
	public List<TpAnestesia> findAllOrderDescricaoAsc();
	
}