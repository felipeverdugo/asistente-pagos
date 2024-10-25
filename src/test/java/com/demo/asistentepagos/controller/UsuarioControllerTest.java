//package com.demo.asistentepagos.controller;
//
//import com.demo.asistentepagos.model.Usuario;
//import com.demo.asistentepagos.service.UsuarioService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Collections;
//import java.util.Optional;
//
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(UsuarioController.class)
//public class UsuarioControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc; // MockMvc para simular peticiones HTTP
//
//    @InjectMocks
//    private UsuarioController usuarioController;
//
//    @Mock
//    private UsuarioService usuarioService;
//
//    private Usuario usuario;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
//
//        usuario = new Usuario();
//        usuario.setId(1L);
//        usuario.setNombre("Juan");
//        usuario.setEmail("juan@example.com");
//        usuario.setTelefono(123456789);
//    }
//
//    @Test
//    public void testCrearUsuario() throws Exception {
//        when(usuarioService.crearUsuario(any(Usuario.class))).thenReturn(usuario);
//
//        mockMvc.perform(post("/api/usuarios")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"nombre\":\"Juan\",\"email\":\"juan@example.com\",\"telefono\":123456789}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.nombre").value("Juan"));
//    }
//
//    @Test
//    public void testObtenerUsuarios() throws Exception {
//        when(usuarioService.obtenerUsuarios()).thenReturn(Collections.singletonList(usuario));
//
//        mockMvc.perform(get("/api/usuarios"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].nombre").value("Juan"));
//    }
//
//    @Test
//    public void testObtenerUsuarioPorId() throws Exception {
//        when(usuarioService.obtenerUsuarioPorId(1L)).thenReturn(Optional.of(usuario));
//
//        mockMvc.perform(get("/api/usuarios/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.email").value("juan@example.com"));
//    }
//
//    // Agrega más pruebas para otros métodos...
//}
