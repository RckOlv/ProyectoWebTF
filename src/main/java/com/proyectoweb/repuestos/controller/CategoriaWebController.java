package com.proyectoweb.repuestos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectoweb.repuestos.entity.Categoria;
import com.proyectoweb.repuestos.service.ICategoriaService;

@Controller
@RequestMapping("/admin/categorias")
public class CategoriaWebController {

    @Autowired
    private ICategoriaService categoriaService;

    // Listar todas las categorías
    @GetMapping
    public String listarCategorias(Model model) {
        var categorias = categoriaService.listarTodas();
        model.addAttribute("categorias", categorias);
        return "admin/categorias/lista";  // Vista que mostrará las categorías
    }

    // Mostrar formulario para agregar una nueva categoría
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("categoria", new Categoria());  // Crear un objeto vacío para el formulario
        return "admin/categorias/formulario";  // Vista para crear una nueva categoría
    }

    // Guardar una nueva categoría
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.guardar(categoria);  // Guardamos la categoría
        return "redirect:/admin/categorias";  // Redirigir a la lista de categorías
    }

    // Mostrar formulario para editar una categoría existente
    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.buscarPorId(id);  // Buscar la categoría por su ID
        model.addAttribute("categoria", categoria);
        return "admin/categorias/formulario";  // Vista para editar una categoría
    }

    // Eliminar una categoría
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminar(id);  // Eliminar la categoría
        return "redirect:/admin/categorias";  // Redirigir a la lista de categorías
    }
}
