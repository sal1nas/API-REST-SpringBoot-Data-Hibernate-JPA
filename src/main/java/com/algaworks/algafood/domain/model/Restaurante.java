package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Restaurante {
	
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(name="taxa_frete", nullable = false)
	private BigDecimal taxaFrete;

	
	//definindo o campo como chave primaria
	//@Id
		
	//estrategia de geração de tabela autoincremento, repassando a responsabilidade para o BD criar e gerenciar o autoincremento
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	

	@ManyToOne
	@JoinColumn(name="cozinha_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cozinha cozinha;
	

}
