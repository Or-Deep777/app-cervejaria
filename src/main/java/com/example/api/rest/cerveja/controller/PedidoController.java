package com.example.api.rest.cerveja.controller;

import com.example.api.rest.cerveja.dto.PedidoDTO;
import com.example.api.rest.cerveja.model.Pedido;
import com.example.api.rest.cerveja.service.PedidoService;
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
