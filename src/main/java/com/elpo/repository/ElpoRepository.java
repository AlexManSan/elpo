package com.elpo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.elpo.domain.Elpo;
import com.elpo.domain.Paciente;

public interface ElpoRepository extends JpaRepository<Elpo, Long>{

//	outra opção com os próprios atributos
	@Transactional(readOnly=true)
	public List<Elpo> findAllByPaciente(Paciente paciente);
	
//	@Query("select c from Comorbidade c ORDER BY c.descricao ASC")
//	public List<Comorbidade> findAllOrderDescricaoAsc();
}
