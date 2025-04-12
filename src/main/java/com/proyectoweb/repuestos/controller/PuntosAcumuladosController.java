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

import com.proyectoweb.repuestos.entity.PuntosAcumulados;
import com.proyectoweb.repuestos.service.IPuntosAcumuladosService;

@RestController
@RequestMapping("/api/puntos")
public class PuntosAcumuladosController {

    @Autowired
    private IPuntosAcumuladosService puntosService;

    @GetMapping
    public List<PuntosAcumulados> listar() {
        return puntosService.listarTodos();
    }

    @GetMapping("/{id}")
    public PuntosAcumulados buscarPorId(@PathVariable Long id) {
        return puntosService.obtenerPorId(id);
    }

    @PostMapping
    public PuntosAcumulados guardar(@RequestBody PuntosAcumulados puntos) {
        return puntosService.guardar(puntos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        puntosService.eliminar(id);
    }
}
