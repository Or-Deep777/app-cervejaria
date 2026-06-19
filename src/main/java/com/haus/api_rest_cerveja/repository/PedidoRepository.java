package com.haus.api_rest_cerveja.repository;

import com.haus.api_rest_cerveja.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
