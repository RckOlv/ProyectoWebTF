package com.proyectoweb.repuestos.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "historial_puntos")
public class HistorialPuntos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    private Integer puntos;

    @Enumerated(EnumType.STRING)
    private TipoMovimientoPuntos tipo; // 'ACUMULADO' o 'UTILIZADO'

    private LocalDate fecha;

    // Getters y Setters

    public Long getIdHistorial() {
        return id;
    }

    public void setIdHistorial(Long idHistorial) {
        this.id = idHistorial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public TipoMovimientoPuntos getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimientoPuntos tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
