package com.proyectoweb.repuestos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoweb.repuestos.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByNombre(String nombre); //util para busar roles por nombre
}
