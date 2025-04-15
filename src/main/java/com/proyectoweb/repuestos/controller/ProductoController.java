package com.proyectoweb.repuestos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.proyectoweb.repuestos.entity.Categoria;
import com.proyectoweb.repuestos.entity.Producto;
import com.proyectoweb.repuestos.repository.CategoriaRepository;
import com.proyectoweb.repuestos.service.IProductoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public String listarProductos(Model model) {
        // Aquí agregamos los productos y los puntos asociados
        model.addAttribute("productos", productoService.listarTodos());
        return "admin/productos/lista"; // Vista de lista de productos
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        Producto producto = new Producto();
        producto.setCategoria(new Categoria()); // Importante para evitar null en el form
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "admin/productos/formulario"; // Vista para crear nuevo producto
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute("producto") @Valid Producto producto,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriaRepository.findAll());
            return "admin/productos/formulario"; // Si hay errores, se vuelve al formulario
        }
        // Calcula y asigna los puntos asociados antes de guardar
        producto.setPuntosAsociados((int) (producto.getPrecio() / 1000)); // Redondeo hacia abajo
        productoService.guardar(producto);
        return "redirect:/admin/productos"; // Redirige a la lista de productos
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Producto producto = productoService.buscarPorId(id);
        if (producto == null) {
            return "redirect:/admin/productos";
        }
        if (producto.getCategoria() == null) {
            producto.setCategoria(new Categoria());
        }
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "admin/productos/formulario"; // Vista para editar producto
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Long id) {
        productoService.eliminar(id);
        return "redirect:/admin/productos"; // Redirige a la lista de productos después de eliminar
    }
}
