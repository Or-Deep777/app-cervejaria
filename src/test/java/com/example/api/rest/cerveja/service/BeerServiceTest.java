package com.example.api.rest.cerveja.service;

import com.example.api.rest.cerveja.model.Beer;
import com.example.api.rest.cerveja.repository.BeerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BeerServiceTest {

    @Mock
    private BeerRepository repository;

    @InjectMocks
    private BeerService service;

    @Test
    void deveSalvarCervejaComSucesso(){
        Beer beer = new Beer();
        beer.setNome("Skol");
        beer.setQuantidade(100);

        when(repository.save(any())).thenReturn(beer);

        Beer resultado = service.salvar(beer);

        assertNotNull(resultado);

        assertEquals("Skol", resultado.getNome());

        verify(repository, times(1)).save(any());
    }

    @Test
    void deveListarCervejas(){
        List<Beer> lista = List.of(
                new Beer()
        );

        when(repository.findAll()).thenReturn(lista);

        List<Beer> resultado = service.listar();

        assertEquals(1,resultado.size());
    }
}
