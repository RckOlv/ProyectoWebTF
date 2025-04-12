package com.proyectoweb.repuestos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoweb.repuestos.entity.Permiso;

public interface PermisoRepository extends JpaRepository<Permiso, Long> {
    Permiso findByNombre(String nombre);
}
