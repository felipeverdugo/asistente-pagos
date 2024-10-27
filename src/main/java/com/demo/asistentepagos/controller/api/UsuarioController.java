package com.demo.asistentepagos.controller.api;

import com.demo.asistentepagos.model.Usuario;
import com.demo.asistentepagos.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return ResponseEntity.status(201).body(nuevoUsuario); // 201 Created
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404 si no se encuentra
    }

    // Actualizar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        Usuario usuario = usuarioService.actualizarUsuario(id, usuarioActualizado);
        return usuario != null
                ? ResponseEntity.ok(usuario) // 200 OK
                : ResponseEntity.notFound().build(); // 404 si no se encuentra
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    // Obtener un usuario por email
    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> obtenerUsuarioPorEmail(@PathVariable String email) {
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorEmail(email);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404 si no se encuentra
    }

    @GetMapping("/telefono/{telefono}")
    public List<Usuario> obtenerUsuariosPorTelefono(@PathVariable int telefono) {
        return usuarioService.obtenerUsuariosPorTelefono(telefono);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Usuario> obtenerUsuariosPorNombre(@PathVariable String nombre) {
        return usuarioService.obtenerUsuariosPorNombre(nombre);
    }

    @GetMapping("/direccion/{direccion}")
    public List<Usuario> obtenerUsuariosPorDireccion(@PathVariable String direccion) {
        return usuarioService.obtenerUsuariosPorDireccion(direccion);
    }

    @GetMapping("/fechaNacimiento/{fechaNacimiento}")
    public List<Usuario> obtenerUsuariosPorFechaNacimiento(@PathVariable Date fechaNacimiento) {
        return usuarioService.obtenerUsuariosPorFechaNacimiento(fechaNacimiento);
    }

    @GetMapping("/nombre/{nombre}/telefono/{telefono}")
    public List<Usuario> obtenerUsuariosPorNombreYTelefono(@PathVariable String nombre, @PathVariable int telefono) {
        return usuarioService.obtenerUsuariosPorNombreYTelefono(nombre, telefono);
    }
}
