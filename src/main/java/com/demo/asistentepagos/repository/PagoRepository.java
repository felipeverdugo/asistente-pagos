package com.demo.asistentepagos.repository;


import com.demo.asistentepagos.model.MetodoDePago;
import com.demo.asistentepagos.model.Pago;
import com.demo.asistentepagos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Métodos personalizados si son necesarios
    List<Pago> findByMonto(Double monto);

    List<Pago> findByMetodoPago(MetodoDePago metodoPago);

    List<Pago> findByEmisor(Usuario emisor);

    List<Pago> findByReceptor(Usuario receptor);

    List<Pago> findByEmisorAndReceptor(Usuario emisor, Usuario receptor);

    List<Pago> findByEmisorAndMonto(Usuario emisor, Double monto);

    List<Pago> findByReceptorAndMonto(Usuario receptor, Double monto);

    List<Pago> findByEmisorAndMetodoPago(Usuario emisor, MetodoDePago metodoPago);

    List<Pago> findByReceptorAndMetodoPago(Usuario receptor, MetodoDePago metodoPago);

    List<Pago> findByEmisorAndReceptorAndMonto(Usuario emisor, Usuario receptor, Double monto);

    List<Pago> findByEmisorAndReceptorAndMetodoPago(Usuario emisor, Usuario receptor, MetodoDePago metodoPago);

    List<Pago> findByEmisorAndMontoAndMetodoPago(Usuario emisor, Double monto, MetodoDePago metodoPago);

    List<Pago> findByReceptorAndMontoAndMetodoPago(Usuario receptor, Double monto, MetodoDePago metodoPago);

    List<Pago> findByEmisorAndReceptorAndMontoAndMetodoPago(Usuario emisor, Usuario receptor, Double monto, MetodoDePago metodoPago);

    List<Pago> findByEmisorAndReceptorAndMetodoPagoAndMonto(Usuario emisor, Usuario receptor, MetodoDePago metodoPago, Double monto);

    List<Pago> findByEmisorAndMetodoPagoAndMonto(Usuario emisor, MetodoDePago metodoPago, Double monto);

    List<Pago> findByReceptorAndMetodoPagoAndMonto(Usuario receptor, MetodoDePago metodoPago, Double monto);


}
