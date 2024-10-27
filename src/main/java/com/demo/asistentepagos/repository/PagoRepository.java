package com.demo.asistentepagos.repository;


import com.demo.asistentepagos.model.MetodoDePago;
import com.demo.asistentepagos.model.Pago;
import com.demo.asistentepagos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Métodos personalizados si son necesarios
    List<Pago> findByMonto(Double monto);

    List<Pago> findByMetodoDePago(MetodoDePago metodoDePago);

    List<Pago> findByEmisor(Usuario emisor);

    List<Pago> findByReceptor(Usuario receptor);

    List<Pago> findByEmisorAndReceptor(Usuario emisor, Usuario receptor);

    List<Pago> findByEmisorAndMonto(Usuario emisor, Double monto);

    List<Pago> findByReceptorAndMonto(Usuario receptor, Double monto);

    List<Pago> findByEmisorAndMetodoDePago(Usuario emisor, MetodoDePago metodoDePago);

    List<Pago> findByReceptorAndMetodoDePago(Usuario receptor, MetodoDePago metodoDePago);

    List<Pago> findByEmisorAndReceptorAndMonto(Usuario emisor, Usuario receptor, Double monto);

    List<Pago> findByEmisorAndReceptorAndMetodoDePago(Usuario emisor, Usuario receptor, MetodoDePago metodoDePago);

    List<Pago> findByEmisorAndMontoAndMetodoDePago(Usuario emisor, Double monto, MetodoDePago metodoDePago);

    List<Pago> findByReceptorAndMontoAndMetodoDePago(Usuario receptor, Double monto, MetodoDePago metodoDePago);

    List<Pago> findByEmisorAndReceptorAndMontoAndMetodoDePago(Usuario emisor, Usuario receptor, Double monto, MetodoDePago metodoDePago);

    List<Pago> findByEmisorAndReceptorAndMetodoDePagoAndMonto(Usuario emisor, Usuario receptor, MetodoDePago metodoDePago, Double monto);

    List<Pago> findByEmisorAndMetodoDePagoAndMonto(Usuario emisor, MetodoDePago metodoDePago, Double monto);

    List<Pago> findByReceptorAndMetodoDePagoAndMonto(Usuario receptor, MetodoDePago metodoDePago, Double monto);


}
