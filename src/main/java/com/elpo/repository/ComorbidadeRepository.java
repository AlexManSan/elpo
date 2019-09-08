package com.elpo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elpo.domain.Comorbidade;

public interface ComorbidadeRepository extends JpaRepository<Comorbidade, Long>{

//	outra opção com os próprios atributos 
//	public List<Comorbidade> findAllOrderByDescricaoAsc();
	
	@Query("select c from Comorbidade c ORDER BY c.descricao ASC")
	public List<Comorbidade> findAllOrderDescricaoAsc();
}
