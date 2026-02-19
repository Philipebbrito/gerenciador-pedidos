package com.philipeborges.gerenciador_pedidos.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    public Pedido() {
    }

    public Pedido(LocalDate data) {
        this.data = data;
    }

    public Pedido(Long id, LocalDate data) {
        this.id = id;
        this.data = data;
    }
}
