package com.proyectoweb.repuestos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoweb.repuestos.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    // Métodos adicionales pueden ser añadidos aquí si es necesario
}
