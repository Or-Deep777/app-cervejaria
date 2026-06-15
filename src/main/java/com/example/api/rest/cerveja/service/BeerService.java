package com.example.api.rest.cerveja.service;

import com.example.api.rest.cerveja.model.Beer;
import com.example.api.rest.cerveja.repository.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    private final BeerRepository repository;

    public BeerService(BeerRepository repository) {
        this.repository = repository;
    }

    public Beer salvar(Beer beer){
        if (beer.getQuantidade() < 0) {
            throw new RuntimeException(("Quantidade invalida"));
        }
        return repository.save(beer);
    }

    public List<Beer> listar(){
        return repository.findAll();
    }
}
