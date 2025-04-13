package com.proyectoweb.repuestos.service;

import java.util.List;

import com.proyectoweb.repuestos.entity.Cliente;

public interface IClienteService {

    List<Cliente> listarTodos();

    Cliente buscarPorId(Long id);

    Cliente guardar(Cliente cliente); // Para nuevo cliente

    Cliente actualizar(Long id, Cliente cliente); // Para modificar cliente existente

    void eliminar(Long id);
}
