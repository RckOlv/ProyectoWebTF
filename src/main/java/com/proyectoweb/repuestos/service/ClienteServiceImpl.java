package com.proyectoweb.repuestos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoweb.repuestos.entity.Cliente;
import com.proyectoweb.repuestos.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();  // Devuelve la lista de todos los clientes
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);  // Guarda un cliente
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);  // Busca un cliente por ID
    }

    @Override
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);  // Elimina un cliente por ID
    }
}
