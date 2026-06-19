package com.haus.api_rest_cerveja.repository;

import com.haus.api_rest_cerveja.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends
        JpaRepository<ItemPedido,Long> {
}
