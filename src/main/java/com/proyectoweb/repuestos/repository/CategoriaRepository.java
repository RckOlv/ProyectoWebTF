package com.proyectoweb.repuestos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoweb.repuestos.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
