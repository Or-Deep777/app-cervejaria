package com.haus.api_rest_cerveja.service;

import com.haus.api_rest_cerveja.model.Beer;
import com.haus.api_rest_cerveja.repository.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BeerService {


    private final BeerRepository repository;

    public BeerService(BeerRepository repository) {
        this.repository = repository;
    }

    public Beer salvar(Beer beer){
        if(beer.getQuantidade() < 0) {
            throw new RuntimeException(("Quantidade invalida"));

        }
        return repository.save(beer);
    }


    public List<Beer> listar() {

        return repository.findAll();
    }

    public Beer buscarPorId(Long id){
        return repository.findById(id).
                orElseThrow(()-> new RuntimeException("Cerveja não encontrada"));
    }

    public Beer atualizar(Long id, Beer beer){

        Beer beerExistente = repository.findById(id).
                orElseThrow(()-> new RuntimeException("Cerveja não encontrada"));

        beerExistente.setNome(beer.getNome());
        beerExistente.setPreco(beer.getPreco());
        beerExistente.setQuantidade(beer.getQuantidade());
        beerExistente.setImagem(beer.getImagem());

        return repository.save(beerExistente);
    }


    public void excluir(Long id){
        if(!repository.existsById((id))){
            throw new RuntimeException("Cerveja não encontrada");
        }

        repository.deleteById(id);
    }


}
