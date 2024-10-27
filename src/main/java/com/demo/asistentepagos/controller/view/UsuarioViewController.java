package com.demo.asistentepagos.controller.view;

import com.demo.asistentepagos.model.Usuario;
import com.demo.asistentepagos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsuarioViewController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.obtenerUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuario/index"; // Renderiza la plantilla "index.html"
    }
}
