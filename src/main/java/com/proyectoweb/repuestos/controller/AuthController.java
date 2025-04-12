package com.proyectoweb.repuestos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // busca login.html en templates
    }
}
