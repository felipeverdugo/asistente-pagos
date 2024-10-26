package com.demo.asistentepagos.controller;

import com.demo.asistentepagos.model.Usuario;
import com.demo.asistentepagos.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SuppressWarnings("deprecation")
public class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    private Usuario usuario1;
    private Usuario usuario2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setEmail("test1@example.com");

        usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setEmail("test2@example.com");
    }

    @Test
    public void testCrearUsuario() {
        when(usuarioService.crearUsuario(any(Usuario.class))).thenReturn(usuario1);

        Usuario result = usuarioController.crearUsuario(usuario1).getBody();

        assert result != null;
        assertEquals(usuario1.getEmail(), result.getEmail());
        verify(usuarioService, times(1)).crearUsuario(any(Usuario.class));
    }

    @Test
    public void testObtenerUsuarios() {
        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);
        when(usuarioService.obtenerUsuarios()).thenReturn(usuarios);

        List<Usuario> result = usuarioController.obtenerUsuarios();

        assertEquals(2, result.size());
        assertEquals(usuario1, result.get(0));
        assertEquals(usuario2, result.get(1));
        verify(usuarioService, times(1)).obtenerUsuarios();
    }

    @Test
    public void testObtenerUsuarioPorId() {
        when(usuarioService.obtenerUsuarioPorId(1L)).thenReturn(Optional.of(usuario1));

        ResponseEntity<Usuario> response = usuarioController.obtenerUsuarioPorId(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(usuario1, response.getBody());
    }

    @Test
    public void testObtenerUsuarioPorIdNotFound() {
        when(usuarioService.obtenerUsuarioPorId(1L)).thenReturn(Optional.empty());

        ResponseEntity<Usuario> response = usuarioController.obtenerUsuarioPorId(1L);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void testActualizarUsuario() {
        when(usuarioService.actualizarUsuario(any(Long.class), any(Usuario.class))).thenReturn(usuario1);

        ResponseEntity<Usuario> response = usuarioController.actualizarUsuario(1L, usuario1);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(usuario1, response.getBody());
    }

    @Test
    public void testActualizarUsuarioNotFound() {
        when(usuarioService.actualizarUsuario(any(Long.class), any(Usuario.class))).thenReturn(null);

        ResponseEntity<Usuario> response = usuarioController.actualizarUsuario(1L, usuario1);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void testEliminarUsuario() {
        doNothing().when(usuarioService).eliminarUsuario(1L);

        ResponseEntity<Void> response = usuarioController.eliminarUsuario(1L);

        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    public void testObtenerUsuarioPorEmail() {
        when(usuarioService.obtenerUsuarioPorEmail("test1@example.com")).thenReturn(Optional.of(usuario1));

        ResponseEntity<Usuario> response = usuarioController.obtenerUsuarioPorEmail("test1@example.com");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(usuario1, response.getBody());
    }

    @Test
    public void testObtenerUsuarioPorEmailNotFound() {
        when(usuarioService.obtenerUsuarioPorEmail("test1@example.com")).thenReturn(Optional.empty());

        ResponseEntity<Usuario> response = usuarioController.obtenerUsuarioPorEmail("test1@example.com");

        assertEquals(404, response.getStatusCodeValue());
    }
}
