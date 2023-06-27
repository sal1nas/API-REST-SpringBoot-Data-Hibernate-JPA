package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Funcionarios;
import com.algaworks.algafood.domain.repository.SpringJPAExemplo;

@RestController
@RequestMapping("/teste")
public class TesteController {
	
	@Autowired
	private SpringJPAExemplo springJPA;
	
	@GetMapping("/funcionarios/por-nome")
	public List<Funcionarios> funcionarioPorNome(String nome){
		return springJPA.findByNome(nome);
	}
	
	@GetMapping("/funcionarios/por-nome-unico")
	public List<Funcionarios> findFisrtFuncionariosByNomeContaining(String nome){
		return springJPA.findFisrtFuncionariosByNomeContaining(nome);
	}

}
