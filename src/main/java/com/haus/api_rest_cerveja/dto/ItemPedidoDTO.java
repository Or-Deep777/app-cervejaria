package com.haus.api_rest_cerveja.dto;

public class ItemPedidoDTO {

    private Long beerId;
    private Integer quantidade;


    public Long getBeerId() {
        return beerId;
    }

    public void setBeerId(Long beerId) {
        this.beerId = beerId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
