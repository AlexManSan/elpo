package com.elpo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.elpo.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

//	outra opção com os próprios atributos 
//	public List<Comorbidade> findAllOrderByDescricaoAsc();
	
	@Transactional(readOnly=true) //não será envolvida nas transações do banco de dados ficando mais rápido
	@Query("select p from Paciente p ORDER BY p.nome ASC")
	public List<Paciente> findAllOrderNomeAsc();
	
	@Transactional(readOnly=true) //não será envolvida nas transações do banco de dados ficando mais rápido
	public Paciente findByProntuario(Integer prontuario);
	
	@Transactional(readOnly=true) //não será envolvida nas transações do banco de dados ficando mais rápido
	public Paciente findByNomeContains(String nome);
}
