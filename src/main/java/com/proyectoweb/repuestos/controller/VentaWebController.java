package com.proyectoweb.repuestos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectoweb.repuestos.entity.Venta;
import com.proyectoweb.repuestos.service.IClienteService;
import com.proyectoweb.repuestos.service.IVentaService;

@Controller
@RequestMapping("/admin/ventas")
public class VentaWebController {

    private static final Logger logger = LoggerFactory.getLogger(VentaWebController.class);

    @Autowired
    private IVentaService ventaService;

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public String verVentas(Model model) {
        model.addAttribute("ventas", ventaService.listarVentas());
        return "admin/ventas/lista";
    }

    @GetMapping("/agregar")
    public String agregarVenta(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("clientes", clienteService.listarTodos());
        return "admin/ventas/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editarVenta(@PathVariable("id") Long id, Model model) {
        Venta venta = ventaService.obtenerVentaPorId(id);
        if (venta != null) {
            model.addAttribute("venta", venta);
            model.addAttribute("clientes", clienteService.listarTodos());
        }
        logger.info("Venta: {}", venta);
        if (venta != null && venta.getCliente() != null) {
            logger.info("Cliente: {}", venta.getCliente());
        } else {
            logger.warn("El cliente de la venta es nulo.");
        }
        return "admin/ventas/formulario";
    }

    @PostMapping("/guardar")
    public String guardarVenta(@ModelAttribute("venta") Venta venta) {
        logger.info("Venta (antes de guardar): {}", venta);
        if (venta.getCliente() != null) {
            logger.info("Cliente asociado: {}", venta.getCliente());
        } else {
            logger.warn("No se ha asociado un cliente a la venta.");
        }

        // Verificar si el estado es valido antes de guardar
        if (venta.getEstado() == null) {
            logger.error("El estado de la venta no puede ser nulo.");
            return "redirect:/admin/ventas?error=estado_invalido";
        }

        if (venta.getId() != null) {
            ventaService.actualizarVenta(venta);
        } else {
            venta.setTotal(venta.calcularTotal());
            ventaService.guardarVenta(venta);
        }
        return "redirect:/admin/ventas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarVenta(@PathVariable("id") Long id) {
        ventaService.eliminarVenta(id);
        return "redirect:/admin/ventas";
    }

    // NUEVO: Ver detalles de una venta
    @GetMapping("/ver/{id}")
    public String verDetalleVenta(@PathVariable("id") Long id, Model model) {
        Venta venta = ventaService.obtenerVentaPorId(id);
        if (venta != null) {
            model.addAttribute("venta", venta);
            return "admin/ventas/detalle"; // Asegurate de crear esta vista
        }
        return "redirect:/admin/ventas";
    }
}
