package com.proyectoweb.repuestos.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "puntos_acumulados")
public class PuntosAcumulados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_puntos")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;

    private Integer puntosAcumulados;

    private LocalDate fechaAcumulacion;

    // Getters y Setters

    public Long getIdPuntos() {
        return id;
    }

    public void setIdPuntos(Long idPuntos) {
        this.id = idPuntos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Integer getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(Integer puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public LocalDate getFechaAcumulacion() {
        return fechaAcumulacion;
    }

    public void setFechaAcumulacion(LocalDate fechaAcumulacion) {
        this.fechaAcumulacion = fechaAcumulacion;
    }
}
