package com.proyectoweb.repuestos.service;

import java.util.List;

import com.proyectoweb.repuestos.entity.DetalleVenta;

public interface IDetalleVentaService {
    List<DetalleVenta> listarDetalles();
    DetalleVenta obtenerPorId(Long id);
    DetalleVenta guardar(DetalleVenta detalleVenta);
    void eliminar(Long id);
}
