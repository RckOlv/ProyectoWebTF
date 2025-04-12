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

import com.proyectoweb.repuestos.entity.Venta;
import com.proyectoweb.repuestos.service.IVentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping
    public List<Venta> listar() {
        return ventaService.listarVentas();
    }

    @GetMapping("/{id}")
    public Venta buscarPorId(@PathVariable Long id) {
        return ventaService.obtenerVentaPorId(id);
    }

    @PostMapping
    public Venta guardar(@RequestBody Venta venta) {
        return ventaService.guardarVenta(venta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
    }
}
