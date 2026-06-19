package com.haus.api_rest_cerveja.service;


import com.haus.api_rest_cerveja.dto.ItemPedidoDTO;
import com.haus.api_rest_cerveja.dto.PedidoDTO;
import com.haus.api_rest_cerveja.model.Beer;
import com.haus.api_rest_cerveja.model.ItemPedido;
import com.haus.api_rest_cerveja.model.Pedido;
import com.haus.api_rest_cerveja.repository.BeerRepository;
import com.haus.api_rest_cerveja.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

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

        for(ItemPedidoDTO itemDTO: dto.getItens()){

            Beer beer = beerRepository.findById(itemDTO.getBeerId())
                    .orElseThrow();

            ItemPedido item = new ItemPedido();

            item.setBeer(beer);
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPedido(pedido);

            itens.add(item);
        }

        pedido.setItens(itens);

        return pedidoRepository.save(pedido);
    }


    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
}
