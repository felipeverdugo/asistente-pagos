package com.demo.asistentepagos.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AplicationViewController {

    @GetMapping("/")
    public String index() {
        return "index"; // Renderiza la plantilla "index.html"
    }

}
