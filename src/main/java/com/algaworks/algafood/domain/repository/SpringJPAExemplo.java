package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Funcionarios;

@Repository
@EnableJpaRepositories
public interface SpringJPAExemplo extends JpaRepository<Funcionarios, Long>{
	
	List<Funcionarios> findFisrtFuncionariosByNomeContaining(String nome);
	
	List<Funcionarios> findByNome(String nome);
	
	//List<Funcionarios> findByLastName(String lastName);

	Funcionarios findById(long id);

}
