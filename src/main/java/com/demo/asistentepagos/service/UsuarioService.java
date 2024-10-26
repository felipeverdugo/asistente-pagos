package com.demo.asistentepagos.service;

import com.demo.asistentepagos.model.Usuario;
import com.demo.asistentepagos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Crear un nuevo usuario
    public Usuario crearUsuario(Usuario usuario) {

        Optional<Usuario> existingUser = usuarioRepository.findByEmail(usuario.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("Ya existe un usuario con ese mail");
        }
        return usuarioRepository.save(usuario);
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Actualizar un usuario
    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        usuarioActualizado.setId(id);
        return usuarioRepository.save(usuarioActualizado);
    }

    // Eliminar un usuario
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> obtenerUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public List<Usuario> obtenerUsuariosPorTelefono(int telefono) {
        return usuarioRepository.findByTelefono(telefono);
    }

    public List<Usuario> obtenerUsuariosPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    public List<Usuario> obtenerUsuariosPorDireccion(String direccion) {
        return usuarioRepository.findByDireccion(direccion);
    }

    public List<Usuario> obtenerUsuariosPorFechaNacimiento(Date fechaNacimiento) {
        return usuarioRepository.findByFechaNacimiento(fechaNacimiento);
    }

    public List<Usuario> obtenerUsuariosPorNombreYTelefono(String nombre, int telefono) {
        return usuarioRepository.findByNombreAndTelefono(nombre, telefono);
    }


}
