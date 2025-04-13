package com.proyectoweb.repuestos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoweb.repuestos.entity.Categoria;
import com.proyectoweb.repuestos.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);  // Guardar nueva categoría
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public Categoria actualizar(Categoria categoria) {
        // Comprobamos si la categoría existe
        Categoria categoriaExistente = categoriaRepository.findById(categoria.getId()).orElse(null);
        if (categoriaExistente != null) {
            // Si existe, actualizamos los campos necesarios
            categoriaExistente.setNombre(categoria.getNombre());
            categoriaExistente.setDescripcion(categoria.getDescripcion());
            return categoriaRepository.save(categoriaExistente);  // Guardamos la categoría actualizada
        }
        return null;  // Si no existe la categoría, podemos lanzar una excepción o manejarlo según lo necesites
    }
}
