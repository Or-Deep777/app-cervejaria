package com.example.api.rest.cerveja.service;

import com.example.api.rest.cerveja.dto.ItemPedidoDTO;
import com.example.api.rest.cerveja.dto.PedidoDTO;
import com.example.api.rest.cerveja.model.Beer;
import com.example.api.rest.cerveja.model.ItemPedido;
import com.example.api.rest.cerveja.model.Pedido;
import com.example.api.rest.cerveja.repository.BeerRepository;
import com.example.api.rest.cerveja.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private BeerRepository beerRepository;

    public Pedido salvar(PedidoDTO dto){
        Pedido pedido = new Pedido();

        pedido.setMesa(dto.getMesa());

        List<ItemPedido> itens = new ArrayList<>();

        for (ItemPedidoDTO itemDTO: dto.getItens()){
            Beer beer = beerRepository.findById(itemDTO.getBeerId()).orElseThrow();

            ItemPedido item = new ItemPedido();

            item.setBeer(beer);
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPedido(pedido);

            itens.add(item);
        }
        pedido.setItens(itens);

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarTodos(){
        return pedidoRepository.findAll();
    }
}
