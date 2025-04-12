package com.proyectoweb.repuestos.service;

import java.util.List;

import com.proyectoweb.repuestos.entity.Cliente;

public interface IClienteService {
    List<Cliente> listarTodos();  // Método para listar todos los clientes
    Cliente guardar(Cliente cliente);  // Guardar un cliente
    Cliente buscarPorId(Long id);  // Buscar cliente por ID
    void eliminar(Long id);  // Eliminar cliente por ID
}
