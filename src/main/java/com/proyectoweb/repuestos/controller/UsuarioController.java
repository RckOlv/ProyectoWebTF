package com.proyectoweb.repuestos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoweb.repuestos.entity.Usuario;
import com.proyectoweb.repuestos.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCreado = usuarioService.guardarUsuario(usuario);  // Cambié el método a guardarUsuario
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodosUsuarios();  // Cambié el método a obtenerTodosUsuarios
        return ResponseEntity.ok(usuarios);
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable long id) {
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Actualizar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioService.obtenerUsuarioPorId(id);
        if (usuarioExistente.isPresent()) {
            usuario.setIdUsuario(id);  // Asegúrate de no cambiar el ID
            Usuario usuarioActualizado = usuarioService.guardarUsuario(usuario);  // Cambié el método a guardarUsuario
            return ResponseEntity.ok(usuarioActualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable long id) {
        Optional<Usuario> usuarioExistente = usuarioService.obtenerUsuarioPorId(id);
        if (usuarioExistente.isPresent()) {
            usuarioService.eliminarUsuario(id);  // Método correcto
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
