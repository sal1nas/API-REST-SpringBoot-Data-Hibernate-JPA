package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;


@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
		
	//listar tudo
	@GetMapping
	public List<Restaurante> listar(){
		return restauranteRepository.listar();
		
	}
	
	//listar por id
	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
		
		Restaurante restaurante = restauranteRepository.buscar(restauranteId);
		
		if(restaurante != null) {
			return ResponseEntity.ok(restaurante);
			
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurante adicionar(@RequestBody Restaurante restaurante){
		
		return cadastroRestaurante.salvar(restaurante);
	}

}
