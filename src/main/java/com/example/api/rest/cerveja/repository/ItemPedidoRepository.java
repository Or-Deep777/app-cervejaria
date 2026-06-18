package com.example.api.rest.cerveja.repository;

import com.example.api.rest.cerveja.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
