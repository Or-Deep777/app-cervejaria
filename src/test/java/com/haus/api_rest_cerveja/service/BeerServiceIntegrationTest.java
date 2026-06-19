package com.haus.api_rest_cerveja.service;


import com.haus.api_rest_cerveja.model.Beer;
import com.haus.api_rest_cerveja.repository.BeerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BeerServiceIntegrationTest {

    @Autowired
    private BeerService service;

    @Autowired
    private BeerRepository repository;


    @Test
    void deveSalvarNoBanco(){
        Beer beer = new Beer();
        beer.setNome("Heineken");
        beer.setQuantidade(100);

        Beer salvo = service.salvar(beer);

        assertNotNull(salvo.getId());
    }

}
