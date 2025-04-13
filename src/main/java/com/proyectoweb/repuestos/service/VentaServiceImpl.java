package com.proyectoweb.repuestos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoweb.repuestos.entity.EstadoVenta;
import com.proyectoweb.repuestos.entity.Venta;
import com.proyectoweb.repuestos.repository.VentaRepository;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta actualizarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public void eliminarVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public Venta crearVenta(Venta venta) {
        venta.setEstado(EstadoVenta.PENDIENTE);  // Establecer estado a PENDIENTE por defecto
        return ventaRepository.save(venta);
    }

    @Override
    public void cancelarVenta(Long id) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada con ID: " + id));
        venta.setEstado(EstadoVenta.CANCELADA);
        ventaRepository.save(venta);
    }
}
