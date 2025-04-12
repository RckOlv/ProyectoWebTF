package com.proyectoweb.repuestos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoweb.repuestos.entity.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    List<DetalleVenta> findByVentaId(Long ventaId); // útil para obtener los detalles de una venta
}
