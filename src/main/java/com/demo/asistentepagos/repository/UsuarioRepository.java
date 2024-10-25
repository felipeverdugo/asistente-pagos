package com.demo.asistentepagos.repository;


import com.demo.asistentepagos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos personalizados si son necesarios
    void findByNombre(String nombre);

    void findByEmail(String email);

    void findByTelefono(int telefono);

    void findByDireccion(String direccion);

    void findByFechaNacimiento(Date fechaNacimiento);

    void findByNombreAndTelefono(String nombre, int telefono);


}
