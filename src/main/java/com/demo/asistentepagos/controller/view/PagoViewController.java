package com.demo.asistentepagos.controller.view;


import com.demo.asistentepagos.model.Pago;
import com.demo.asistentepagos.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PagoViewController {

    @Autowired
    private PagoService pagoService;

    @GetMapping("/pagos")
    public String listarPagos(Model model) {
        List<Pago> pagos = pagoService.obtenerPagos();
        model.addAttribute("pagos", pagos);
        return "pago/index"; // Renderiza la plantilla "index.html"
    }
}
