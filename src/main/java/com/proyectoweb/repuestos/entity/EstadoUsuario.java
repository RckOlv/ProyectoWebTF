package com.proyectoweb.repuestos.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EstadoUsuario {
    ACTIVO,
    INACTIVO;

    @JsonCreator
    public static EstadoUsuario fromString(String value) {
        if (value != null) {
            try {
                return EstadoUsuario.valueOf(value.toUpperCase());
            } catch (IllegalArgumentException e) {
                // Si el valor no es válido, puedes devolver un valor predeterminado o lanzar una excepción personalizada.
                throw new IllegalArgumentException("Valor no válido para EstadoUsuario: " + value);
            }
        }
        return null; // o un valor predeterminado como EstadoUsuario.INACTIVO
    }
}
