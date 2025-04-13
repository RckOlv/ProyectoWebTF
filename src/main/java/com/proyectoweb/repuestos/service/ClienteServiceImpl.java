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
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizar(Long id, Cliente clienteActualizado) {
        Cliente existente = clienteRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(clienteActualizado.getNombre());
            existente.setApellido(clienteActualizado.getApellido());
            existente.setDni(clienteActualizado.getDni());
            existente.setTelefono(clienteActualizado.getTelefono());
            existente.setEmail(clienteActualizado.getEmail());
            existente.setEstado(clienteActualizado.getEstado());
            // no se modifica la fecha de registro
            return clienteRepository.save(existente);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
}
