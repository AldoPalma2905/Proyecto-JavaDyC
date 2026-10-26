package com.example.ms_compras.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idUsuario;
    private Long idVideojuego;
    private Double montoTotal;
    private LocalDateTime fechaCompra;

    public Compra() {}

    public Compra(Long idUsuario, Long idVideojuego, Double montoTotal, LocalDateTime fechaCompra) {
        this.idUsuario = idUsuario;
        this.idVideojuego = idVideojuego;
        this.montoTotal = montoTotal;
        this.fechaCompra = fechaCompra;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getIdVideojuego() { return idVideojuego; }
    public void setIdVideojuego(Long idVideojuego) { this.idVideojuego = idVideojuego; }

    public Double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(Double montoTotal) { this.montoTotal = montoTotal; }

    public LocalDateTime getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(LocalDateTime fechaCompra) { this.fechaCompra = fechaCompra; }
}