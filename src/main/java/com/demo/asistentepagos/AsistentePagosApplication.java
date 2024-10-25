package com.demo.asistentepagos;

import com.demo.asistentepagos.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsistentePagosApplication implements CommandLineRunner {

    @Autowired
    private PagoService pagoService;

    public static void main(String[] args) {

        SpringApplication.run(AsistentePagosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Llamar al metodo para insertar datos
        pagoService.insertarDatos();
        System.out.println("Datos insertados exitosamente.");
    }

}
