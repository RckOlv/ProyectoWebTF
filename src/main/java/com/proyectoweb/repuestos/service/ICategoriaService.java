package com.proyectoweb.repuestos.service;

import java.util.List;

import com.proyectoweb.repuestos.entity.Categoria;

public interface ICategoriaService {
    List<Categoria> listarTodas();
    Categoria guardar(Categoria categoria);
    Categoria buscarPorId(Long id);
    void eliminar(Long id);
    Categoria actualizar(Categoria categoria);  // Añadir método de actualización
}
