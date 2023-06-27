package com.algaworks.algafood.jpa;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;


public class ConsultaCozinhaMain {

	public static void main(String[] args) {
		org.springframework.context.ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class).web(WebApplicationType.NONE).run(args);
		
		CozinhaRepository cadastroCozinha = ((BeanFactory) applicationContext).getBean(CozinhaRepository.class);
		
		List<Cozinha> cozinhas = cadastroCozinha.listar();
		
		for(Cozinha cozinha: cozinhas) {
			System.out.println(cozinha.getNome());
		}
	}
}
