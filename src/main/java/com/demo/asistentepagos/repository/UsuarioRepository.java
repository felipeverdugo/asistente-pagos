package com.demo.asistentepagos.repository;


import com.demo.asistentepagos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos personalizados si son necesarios


    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByNombre(String nombre);

    List<Usuario> findByTelefono(int telefono);

    List<Usuario> findByDireccion(String direccion);

    List<Usuario> findByFechaNacimiento(Date fechaNacimiento);

    List<Usuario> findByNombreAndTelefono(String nombre, int telefono);


}
