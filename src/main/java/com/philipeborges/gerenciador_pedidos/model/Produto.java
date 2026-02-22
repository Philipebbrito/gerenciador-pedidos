package com.philipeborges.gerenciador_pedidos.model;

import jakarta.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    private String nome;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Produto() {}

    public Produto (String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(String nome, Double preco, Categoria categoria){
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Produto(String nome, Double preco, Categoria categoria, Fornecedor fornecedor) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.fornecedor = fornecedor;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
