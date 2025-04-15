package com.proyectoweb.repuestos.service;

import java.util.List;

import com.proyectoweb.repuestos.entity.Producto;

public interface IProductoService {
    List<Producto> listarTodos();
    Producto buscarPorId(Long id);
    Producto guardar(Producto producto);
    Producto actualizar(Producto producto);
    void eliminar(Long id);
}
