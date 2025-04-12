package com.proyectoweb.repuestos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyectoweb.repuestos.entity.EstadoVenta;
import com.proyectoweb.repuestos.entity.Venta;
import com.proyectoweb.repuestos.service.IVentaService;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    // Listar ventas
    @GetMapping
    public String listarVentas(Model model) {
        model.addAttribute("ventas", ventaService.listarVentas());
        return "ventas";  // Retorna la vista de listado de ventas
    }

    // Actualizar estado de venta
    @PostMapping("/{id}/actualizarEstado")
    public String actualizarEstadoVenta(@PathVariable Long id, @RequestParam String estado) {
        Venta venta = ventaService.obtenerVentaPorId(id);
        if (venta != null) {
            try {
                // Convertir el string a enum
                EstadoVenta nuevoEstado = EstadoVenta.valueOf(estado);
                venta.setEstado(nuevoEstado);

                // Si el estado es COMPLETADA, calculamos el total
                if (nuevoEstado == EstadoVenta.COMPLETADA) {
                    double total = venta.getDetalles().stream()
                        .mapToDouble(detalle -> detalle.getCantidad() * detalle.getPrecioUnitario())
                        .sum();
                    venta.setTotal(total);
                }

                ventaService.actualizarVenta(venta);
            } catch (IllegalArgumentException e) {
                // Si el estado es inválido, podrías manejar el error o agregar un mensaje de error
                return "error"; // Puedes redirigir a una página de error o hacer algo más
            }
        } else {
            // Si la venta no se encuentra, redirige o muestra un mensaje de error
            return "redirect:/ventas?error=notfound";
        }
        return "redirect:/ventas"; // Redirige al listado de ventas
    }
}
