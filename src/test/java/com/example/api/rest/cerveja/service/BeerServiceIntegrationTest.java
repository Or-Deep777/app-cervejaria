package com.example.api.rest.cerveja.service;

import com.example.api.rest.cerveja.model.Beer;
import com.example.api.rest.cerveja.repository.BeerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BeerServiceIntegrationTest {

    @Autowired
    private BeerService service;

    @Autowired
    private BeerRepository repository;

    @Test
    void deveSalvarNoBanco(){
        Beer beer = new Beer();
        beer.setNome("Skol");
        beer.setQuantidade(100);

        Beer salvo = service.salvar(beer);

        assertNotNull(salvo.getId());
    }
}
