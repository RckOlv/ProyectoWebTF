package com.proyectoweb.repuestos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoweb.repuestos.entity.DetalleVenta;
import com.proyectoweb.repuestos.repository.DetalleVentaRepository;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public List<DetalleVenta> listarDetalles() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta obtenerPorId(Long id) {
        Optional<DetalleVenta> detalle = detalleVentaRepository.findById(id);
        return detalle.orElse(null);
    }

    @Override
    public DetalleVenta guardar(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public void eliminar(Long id) {
        detalleVentaRepository.deleteById(id);
    }
}
