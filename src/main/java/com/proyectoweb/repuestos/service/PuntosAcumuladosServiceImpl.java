package com.proyectoweb.repuestos.service;

import com.proyectoweb.repuestos.entity.PuntosAcumulados;
import com.proyectoweb.repuestos.repository.PuntosAcumuladosRepository;
import com.proyectoweb.repuestos.service.IPuntosAcumuladosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuntosAcumuladosServiceImpl implements IPuntosAcumuladosService {

    @Autowired
    private PuntosAcumuladosRepository puntosRepo;

    @Override
    public List<PuntosAcumulados> listarTodos() {
        return puntosRepo.findAll();
    }

    @Override
    public PuntosAcumulados guardar(PuntosAcumulados puntos) {
        return puntosRepo.save(puntos);
    }

    @Override
    public PuntosAcumulados obtenerPorId(Long id) {
        Optional<PuntosAcumulados> optional = puntosRepo.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        puntosRepo.deleteById(id);
    }
}
