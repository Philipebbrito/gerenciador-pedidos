package com.philipeborges.gerenciador_pedidos.principal;

import com.philipeborges.gerenciador_pedidos.model.Categoria;
import com.philipeborges.gerenciador_pedidos.model.Fornecedor;
import com.philipeborges.gerenciador_pedidos.model.Pedido;
import com.philipeborges.gerenciador_pedidos.model.Produto;
import com.philipeborges.gerenciador_pedidos.repository.CategoriaRepository;
import com.philipeborges.gerenciador_pedidos.repository.FornecedorRepository;
import com.philipeborges.gerenciador_pedidos.repository.PedidoRepository;
import com.philipeborges.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Principal {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public void principal() {

        Categoria categoriaEletronicos = new Categoria(1L, "Eletrônicos");
        Categoria categoriaLivros = new Categoria(2L, "Livros");
        categoriaRepository.saveAll(List.of(categoriaEletronicos, categoriaLivros));


        Fornecedor fornecedorTech = new Fornecedor("Tech Supplier");
        Fornecedor fornecedorLivros = new Fornecedor("Livraria Global");
        fornecedorRepository.saveAll(List.of(fornecedorTech, fornecedorLivros));

        Produto produto1 = new Produto("Notebook", 3500.0, categoriaEletronicos);
        Produto produto2 = new Produto("Smartphone", 2500.0, categoriaEletronicos);
        Produto produto3 = new Produto("Livro de Java", 100.0, categoriaLivros);
        produto1.setFornecedor(fornecedorTech);
        produto2.setFornecedor(fornecedorTech);
        produto3.setFornecedor(fornecedorLivros);
        produtoRepository.saveAll(List.of(produto1, produto2, produto3));


        Pedido pedido1 = new Pedido(1L, LocalDate.now());
        pedido1.setProdutos(List.of(produto1, produto3));
        Pedido pedido2 = new Pedido(2L, LocalDate.now().minusDays(1));
        pedido2.setProdutos(List.of(produto2));
        pedidoRepository.saveAll(List.of(pedido1, pedido2));


        System.out.println("Produtos na categoria Eletrônicos:");
        categoriaRepository.findById(1L).ifPresent(categoria ->
                categoria.getProdutos().forEach(produto ->
                        System.out.println(" - " + produto.getNome())
                )
        );

        System.out.println("\nPedidos e seus produtos:");
        pedidoRepository.findAll().forEach(pedido -> {
            System.out.println("Pedido " + pedido.getId() + ":");
            pedido.getProdutos().forEach(produto ->
                    System.out.println(" - " + produto.getNome())
            );
        });

        System.out.println("\nProdutos e seus fornecedores:");
        produtoRepository.findAll().forEach(produto ->
                System.out.println("Produto: " + produto.getNome() +
                        ", Fornecedor: " + produto.getFornecedor().getNome())
        );
    }
}