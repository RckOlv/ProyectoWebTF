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

import com.proyectoweb.repuestos.entity.DetalleVenta;
import com.proyectoweb.repuestos.service.IDetalleVentaService;

@RestController
@RequestMapping("/api/detalles-venta")
public class DetalleVentaController {

    @Autowired
    private IDetalleVentaService detalleService;

    @GetMapping
    public List<DetalleVenta> listar() {
        return detalleService.listarDetalles();
    }

    @GetMapping("/{id}")
    public DetalleVenta buscarPorId(@PathVariable Long id) {
        return detalleService.obtenerPorId(id);
    }

    @PostMapping
    public DetalleVenta guardar(@RequestBody DetalleVenta detalle) {
        return detalleService.guardar(detalle);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        detalleService.eliminar(id);
    }
}
