package com.philipeborges.gerenciador_pedidos.repository;

import com.philipeborges.gerenciador_pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
