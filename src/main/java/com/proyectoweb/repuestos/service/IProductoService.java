package com.proyectoweb.repuestos.service;

import java.util.List;

import com.proyectoweb.repuestos.entity.Producto;

public interface IProductoService {

    Producto guardar(Producto producto);

    Producto actualizar(Producto producto);  // Asegúrate de que este método esté en la interfaz

    Producto buscarPorId(Long id);

    void eliminar(Long id);

    List<Producto> listarTodos();
}
