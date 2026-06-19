package com.haus.api_rest_cerveja.controller;


import com.haus.api_rest_cerveja.dto.PedidoDTO;
import com.haus.api_rest_cerveja.model.Pedido;
import com.haus.api_rest_cerveja.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin("*")
public class PedidoController {


    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido criarPedido(@RequestBody PedidoDTO dto){
        return pedidoService.salvar(dto);
    }

    @GetMapping
    public List<Pedido> listar(){
        return pedidoService.listarTodos();
    }
}
