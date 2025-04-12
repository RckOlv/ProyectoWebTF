package com.proyectoweb.repuestos.service;

import java.util.List;
import java.util.Optional;

import com.proyectoweb.repuestos.entity.Usuario;

public interface IUsuarioService {

    List<Usuario> obtenerTodosUsuarios();

    Optional<Usuario> obtenerUsuarioPorId(Long id);

    Usuario guardarUsuario(Usuario usuario);

    void eliminarUsuario(Long id);

    Optional<Usuario> buscarPorEmail(String email);
}
