package com.proyectoweb.repuestos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectoweb.repuestos.entity.Cliente;
import com.proyectoweb.repuestos.service.IClienteService;

@Controller
@RequestMapping("/admin/clientes")
public class ClientesWebController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public String listarClientes(Model model) {
        var clientes = clienteService.listarTodos();
        model.addAttribute("clientes", clientes);
        return "admin/clientes/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "admin/clientes/formulario";
    }

    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteService.guardar(cliente);
        return "redirect:/admin/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.buscarPorId(id);
        model.addAttribute("cliente", cliente);
        return "admin/clientes/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.eliminar(id);
        return "redirect:/admin/clientes";
    }
}
