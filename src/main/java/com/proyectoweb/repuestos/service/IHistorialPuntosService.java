package com.proyectoweb.repuestos.service;

import java.util.List;

import com.proyectoweb.repuestos.entity.HistorialPuntos;

public interface IHistorialPuntosService {
    List<HistorialPuntos> listar();
    HistorialPuntos guardar(HistorialPuntos historial);
    void eliminar(Long id);
    HistorialPuntos buscarPorId(Long id);
}
