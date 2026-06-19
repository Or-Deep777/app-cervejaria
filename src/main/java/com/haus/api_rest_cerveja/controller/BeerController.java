package com.haus.api_rest_cerveja.controller;


import ch.qos.logback.core.model.Model;
import com.haus.api_rest_cerveja.model.Beer;
import com.haus.api_rest_cerveja.service.BeerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beers")
@CrossOrigin(origins = {
        "http://localhost:8081","http://localhost:3000"},
methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE
})
public class BeerController {

    private final BeerService service;


    public BeerController(BeerService service) {
        this.service = service;
    }

    @PostMapping
    public Beer cadastrar(@Valid @RequestBody Beer beer){

        return service.salvar(beer);
    }

    @GetMapping
    public List<Beer> listar(){

        return service.listar();
    }

    @GetMapping("/{id}")
    public Beer buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Beer atualizar(
            @PathVariable Long id,
            @RequestBody Beer beer
    ){
        return service.atualizar(id,beer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }


}
