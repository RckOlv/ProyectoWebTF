package com.proyectoweb.repuestos.service;

import java.util.List;
import java.util.Optional;

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
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        return clienteOpt.orElse(null);  // Retorna el cliente o null si no lo encuentra
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        // Si necesitas agregar validaciones personalizadas, puedes hacerlo aquí
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteExistenteOpt = clienteRepository.findById(id);
        if (clienteExistenteOpt.isPresent()) {
            Cliente clienteExistente = clienteExistenteOpt.get();
            // Aquí puedes actualizar los atributos del cliente existente con los del nuevo cliente
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setApellido(cliente.getApellido());
            clienteExistente.setDni(cliente.getDni());
            clienteExistente.setTelefono(cliente.getTelefono());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setFechaRegistro(cliente.getFechaRegistro());
            clienteExistente.setEstado(cliente.getEstado());
            return clienteRepository.save(clienteExistente);  // Guarda el cliente actualizado
        } else {
            return null;  // Retorna null si no se encuentra el cliente
        }
    }

    @Override
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);  // Elimina el cliente por id
    }
}
