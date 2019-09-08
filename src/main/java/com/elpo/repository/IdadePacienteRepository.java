package com.elpo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elpo.domain.IdadePaciente;

public interface IdadePacienteRepository extends JpaRepository<IdadePaciente, Long>{

	@Query("select i from IdadePaciente i ORDER BY i.idade ASC")
	public List<IdadePaciente> findAllOrderIdadeAsc();
}
