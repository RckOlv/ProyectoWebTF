package com.proyectoweb.repuestos.service;

import java.util.List;

import com.proyectoweb.repuestos.entity.PuntosAcumulados;

public interface IPuntosAcumuladosService {
    List<PuntosAcumulados> listarTodos();
    PuntosAcumulados guardar(PuntosAcumulados puntos);
    PuntosAcumulados obtenerPorId(Long id);
    void eliminar(Long id);
}
