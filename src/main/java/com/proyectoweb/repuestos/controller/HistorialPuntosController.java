package com.proyectoweb.repuestos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoweb.repuestos.entity.HistorialPuntos;
import com.proyectoweb.repuestos.service.IHistorialPuntosService;

@RestController
@RequestMapping("/api/historial-puntos")
public class HistorialPuntosController {

    @Autowired
    private IHistorialPuntosService historialService;

    @GetMapping
    public List<HistorialPuntos> listar() {
        return historialService.listar();
    }

    @GetMapping("/{id}")
    public HistorialPuntos buscarPorId(@PathVariable Long id) {
        return historialService.buscarPorId(id);
    }

    @PostMapping
    public HistorialPuntos guardar(@RequestBody HistorialPuntos historial) {
        return historialService.guardar(historial);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        historialService.eliminar(id);
    }
}
