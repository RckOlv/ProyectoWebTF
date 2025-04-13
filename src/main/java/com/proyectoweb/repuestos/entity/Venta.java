package com.proyectoweb.repuestos.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ventas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long id;

    @Column(name = "fecha_venta")
    private LocalDate fechaVenta;

    private Double total;

    @Enumerated(EnumType.STRING)
    private EstadoVenta estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private Set<DetalleVenta> detalles = new HashSet<>();

    // Establecer fecha actual si no se especifica al guardar
    @PrePersist
    public void prePersist() {
        if (this.fechaVenta == null) {
            this.fechaVenta = LocalDate.now();
        }
    }

    // Calcular total de la venta
    public Double calcularTotal() {
        double totalVenta = 0.0;
        for (DetalleVenta detalle : detalles) {
            totalVenta += detalle.getCantidad() * detalle.getPrecioUnitario();
        }
        return totalVenta;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Set<DetalleVenta> getDetalles() {
        return detalles;
    }

    public Long getId() {
        return id;
    }

    public EstadoVenta getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setEstado(EstadoVenta estado) {
        this.estado = estado;
    }
}
