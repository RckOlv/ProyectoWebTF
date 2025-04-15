package com.proyectoweb.repuestos.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "puntos_asociados")
    private Integer puntosAsociados;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoProducto estado;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    // Getters y Setters

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
        // Calcular puntos asociados basado en el precio
        this.puntosAsociados = (int) (precio / 1000);  // 1 punto por cada $1000
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPuntosAsociados() {
        return puntosAsociados;
    }

    // No setter para puntosAsociados porque ya es calculado automáticamente
    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setPuntosAsociados(Integer puntosAsociados) {
        this.puntosAsociados = puntosAsociados;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
