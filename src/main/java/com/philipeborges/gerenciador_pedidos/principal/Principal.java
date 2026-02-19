package com.philipeborges.gerenciador_pedidos.principal;

import com.philipeborges.gerenciador_pedidos.model.Categoria;
import com.philipeborges.gerenciador_pedidos.model.Pedido;
import com.philipeborges.gerenciador_pedidos.model.Produto;
import com.philipeborges.gerenciador_pedidos.repository.CategoriaRepository;
import com.philipeborges.gerenciador_pedidos.repository.PedidoRepository;
import com.philipeborges.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Principal implements CommandLineRunner {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {
        

        Produto produto = new Produto("Celuar", 415.0);
        produtoRepository.save(produto);

        Categoria categoria = new Categoria("Eletnico");
        categoriaRepository.save(categoria);

        Pedido pedido = new Pedido(LocalDate.now());
        pedidoRepository.save(pedido);

        System.out.println("Dados salvos com sucesso!");
    }

}
