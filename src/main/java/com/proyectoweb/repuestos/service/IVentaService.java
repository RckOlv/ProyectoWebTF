package com.proyectoweb.repuestos.service;

import java.util.List;

import com.proyectoweb.repuestos.entity.Venta;

public interface IVentaService {
    List<Venta> listarVentas();
    Venta obtenerVentaPorId(Long id);
    Venta guardarVenta(Venta venta);
    Venta actualizarVenta(Venta venta);
    void eliminarVenta(Long id);
    Venta crearVenta(Venta venta);
    void cancelarVenta(Long id);
}
