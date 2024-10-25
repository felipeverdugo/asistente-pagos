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


    public void obtenerUsuarioPorEmail(String email) {
        usuarioRepository.findByEmail(email);
    }

    public void obtenerUsuarioPorNombre(String nombre) {
        usuarioRepository.findByNombre(nombre);
    }

    public void obtenerUsuarioPorTelefono(int telefono) {
        usuarioRepository.findByTelefono(telefono);
    }

    public void obtenerUsuarioPorDireccion(String direccion) {
        usuarioRepository.findByDireccion(direccion);
    }

    public void obtenerUsuarioPorFechaNacimiento(Date fechaNacimiento) {
        usuarioRepository.findByFechaNacimiento(fechaNacimiento);
    }

    public void obtenerUsuarioPorNombreYTelefono(String nombre, int telefono) {
        usuarioRepository.findByNombreAndTelefono(nombre, telefono);
    }


}
