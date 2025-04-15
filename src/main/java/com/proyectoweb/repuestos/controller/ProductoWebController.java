package com.proyectoweb.repuestos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectoweb.repuestos.entity.Producto;
import com.proyectoweb.repuestos.repository.ProductoRepository;

@Controller
public class ProductoWebController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos")
    public String mostrarProductosPublico(Model model) {
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "productos/lista"; // Crea esta vista en templates/productos/lista.html
    }
}
