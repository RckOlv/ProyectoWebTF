package com.proyectoweb.repuestos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoweb.repuestos.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Ejemplo: buscar por nombre
    Producto findByNombre(String nombre);
}
