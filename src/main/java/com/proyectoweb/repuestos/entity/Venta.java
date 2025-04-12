package com.proyectoweb.repuestos.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.annotation.PostConstruct;
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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ventas")
@Getter
@Setter
@NoArgsConstructor  // Lombok generará este constructor sin parámetros automáticamente
@AllArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long id;

    private LocalDate fechaVenta;

    private Double total;

    @Enumerated(EnumType.STRING)
    private EstadoVenta estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private Set<DetalleVenta> detalles = new HashSet<>();

    // Inicializar fechaVenta con la fecha actual si está vacía
    @PostConstruct
    public void init() {
        if (this.fechaVenta == null) {
            this.fechaVenta = LocalDate.now();  // Inicializa la fecha al momento de la creación de la venta
        }
    }

    // Método para calcular el total de la venta
    public Double calcularTotal() {
        double totalVenta = 0.0;
        for (DetalleVenta detalle : detalles) {
            totalVenta += detalle.getCantidad() * detalle.getPrecioUnitario();
        }
        return totalVenta;
    }

    // El método setTotal está siendo llamado en el servicio, ya lo tienes en la clase Venta
    public void setTotal(Double total) {
        this.total = total;
    }

    // Métodos getter y setter para detalles
    public Set<DetalleVenta> getDetalles() {
        return detalles;
    }

    public Long getId() {
        return id;
    }
}
