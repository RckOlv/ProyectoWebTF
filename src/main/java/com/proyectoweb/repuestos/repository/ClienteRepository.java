package com.proyectoweb.repuestos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoweb.repuestos.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
