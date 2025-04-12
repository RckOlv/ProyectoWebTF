package com.proyectoweb.repuestos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoweb.repuestos.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    // Podés agregar métodos personalizados más adelante si necesitás
}
