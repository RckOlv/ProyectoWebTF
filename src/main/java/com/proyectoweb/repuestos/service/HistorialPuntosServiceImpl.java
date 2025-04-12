package com.proyectoweb.repuestos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoweb.repuestos.entity.HistorialPuntos;
import com.proyectoweb.repuestos.repository.HistorialPuntosRepository;

@Service
public class HistorialPuntosServiceImpl implements IHistorialPuntosService {

    @Autowired
    private HistorialPuntosRepository historialRepo;

    @Override
    public List<HistorialPuntos> listar() {
        return historialRepo.findAll();
    }

    @Override
    public HistorialPuntos guardar(HistorialPuntos historial) {
        return historialRepo.save(historial);
    }

    @Override
    public void eliminar(Long id) {
        historialRepo.deleteById(id);
    }

    @Override
    public HistorialPuntos buscarPorId(Long id) {
        return historialRepo.findById(id).orElse(null);
    }
}
