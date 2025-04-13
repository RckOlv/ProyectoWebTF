package com.proyectoweb.repuestos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoweb.repuestos.entity.Producto;
import com.proyectoweb.repuestos.repository.ProductoRepository;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizar(Producto producto) {
        // Verifica si el producto ya existe en la base de datos
        Producto productoExistente = productoRepository.findById(producto.getId())
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        // Actualiza los campos del producto
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setStock(producto.getStock());
        productoExistente.setCategoria(producto.getCategoria());
        productoExistente.setPuntosAsociados(producto.getPuntosAsociados());
        productoExistente.setEstado(producto.getEstado());
        
        // Guarda el producto actualizado
        return productoRepository.save(productoExistente);
    }

    @Override
    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }
}
