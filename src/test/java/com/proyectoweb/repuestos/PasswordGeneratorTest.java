package com.proyectoweb.repuestos;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGeneratorTest {

    @Test
    public void generarPassword() {
        String password = "admin123";
        String encoded = new BCryptPasswordEncoder().encode(password);
        System.out.println("Password encriptada: " + encoded);
    }
}
