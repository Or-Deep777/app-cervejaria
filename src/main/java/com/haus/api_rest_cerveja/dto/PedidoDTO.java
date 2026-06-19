package com.haus.api_rest_cerveja.dto;


import java.util.List;

public class PedidoDTO {

    private Integer mesa;

    private List<ItemPedidoDTO> itens;

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public List<ItemPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }
}
