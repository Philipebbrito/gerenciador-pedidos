package com.philipeborges.gerenciador_pedidos.repository;

import com.philipeborges.gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
