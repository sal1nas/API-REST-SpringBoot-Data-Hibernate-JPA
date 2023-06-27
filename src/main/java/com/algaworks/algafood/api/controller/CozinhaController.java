package com.algaworks.algafood.api.controller;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;


@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	//listar tudo
	@GetMapping
	public List<Cozinha> listar(){
		return cozinhaRepository.listar();
		
	}
	
	//listar por id
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
		
		if(cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//adicionar
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionar(@RequestBody Cozinha cozinha) {
		cadastroCozinha.salvar(cozinha);
	}
	
	//atualizar
	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha){
		Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);
		
		
		if(cozinhaAtual != null) {
			
			//cozinhaAtual.setNome(cozinha.getNome());
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
			
			cadastroCozinha.salvar(cozinhaAtual);
			
			return ResponseEntity.ok(cozinhaAtual);
		
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//deletar
	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId){
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
		
		if(cozinha !=null) {
			cozinhaRepository.remover(cozinha);
			
			return ResponseEntity.noContent().build();
		
		}
		
		return ResponseEntity.notFound().build();
	}
	
	

}
