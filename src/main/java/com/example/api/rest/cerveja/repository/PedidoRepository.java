package com.example.api.rest.cerveja.repository;

import com.example.api.rest.cerveja.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
