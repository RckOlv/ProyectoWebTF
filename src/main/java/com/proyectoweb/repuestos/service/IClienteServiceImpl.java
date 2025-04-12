package com.proyectoweb.repuestos.service;

import java.util.List;

import com.proyectoweb.repuestos.entity.Cliente;

public interface IClienteServiceImpl {
    List<Cliente> listarTodos();
    Cliente guardar(Cliente cliente);
    Cliente buscarPorId(Long id);
    void eliminar(Long id);
}
