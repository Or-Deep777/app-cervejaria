package com.example.api.rest.cerveja.controller;

import com.example.api.rest.cerveja.model.Beer;
import com.example.api.rest.cerveja.service.BeerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BeerController {

    private final BeerService service;

    public BeerController(BeerService service) {
        this.service = service;
    }

    @PostMapping
    public Beer cadastrar(@RequestBody Beer beer){
        return service.salvar(beer);
    }
}
