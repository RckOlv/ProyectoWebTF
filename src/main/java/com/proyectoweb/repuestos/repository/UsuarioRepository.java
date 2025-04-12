package com.proyectoweb.repuestos.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoweb.repuestos.entity.Usuario;

public interface  UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional <Usuario> findByEmail(String email); // util para login
}
