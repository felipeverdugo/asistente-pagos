package com.demo.asistentepagos.service;


import com.demo.asistentepagos.model.MetodoDePago;
import com.demo.asistentepagos.model.Pago;
import com.demo.asistentepagos.model.Usuario;
import com.demo.asistentepagos.repository.PagoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PagoService {

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    private PagoRepository pagoRepository;

    // Crear un nuevo pago
    public Pago crearPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    // Obtener todos los pagos
    public List<Pago> obtenerPagos() {
        return pagoRepository.findAll();
    }


    // Obtener un pago por ID
    public Optional<Pago> obtenerPagoPorId(Long id) {
        return pagoRepository.findById(id);
    }

    // Actualizar un pago
    public Pago actualizarPago(Long id, Pago pagoActualizado) {
        pagoActualizado.setId(id);
        return pagoRepository.save(pagoActualizado);
    }

    // Eliminar un pago
    public void eliminarPago(Long id) {
        pagoRepository.deleteById(id);
    }

    // Métodos personalizados

    public List<Pago> obtenerPagosPorMonto(Double monto) {
        return pagoRepository.findByMonto(monto);
    }

    public List<Pago> obtenerPagosPorMetodoPago(MetodoDePago metodoDePago) {
        return pagoRepository.findByMetodoPago(metodoDePago);
    }

    public List<Pago> obtenerPagosPorEmisor(Usuario emisor) {
        return pagoRepository.findByEmisor(emisor);
    }

    public List<Pago> obtenerPagosPorReceptor(Usuario receptor) {
        return pagoRepository.findByReceptor(receptor);
    }


    public List<Pago> obtenerPagosPorEmisorYReceptor(Usuario emisor, Usuario receptor) {
        return pagoRepository.findByEmisorAndReceptor(emisor, receptor);
    }

    public List<Pago> obtenerPagosPorEmisorYMetodoPago(Usuario emisor, MetodoDePago metodoPago) {
        return pagoRepository.findByEmisorAndMetodoPago(emisor, metodoPago);
    }

    public List<Pago> obtenerPagosPorReceptorYMetodoPago(Usuario receptor, MetodoDePago metodoPago) {
        return pagoRepository.findByReceptorAndMetodoPago(receptor, metodoPago);
    }

    public List<Pago> obtenerPagosPorEmisorYMonto(Usuario emisor, Double monto) {
        return pagoRepository.findByEmisorAndMonto(emisor, monto);
    }

    public List<Pago> obtenerPagosPorEmisorYMontoYMetodoPago(Usuario emisor, Double monto, MetodoDePago metodoPago) {
        return pagoRepository.findByEmisorAndMontoAndMetodoPago(emisor, monto, metodoPago);
    }

    public List<Pago> obtenerPagosPorReceptorYMontoYMetodoPago(Usuario receptor, Double monto, MetodoDePago metodoPago) {
        return pagoRepository.findByReceptorAndMontoAndMetodoPago(receptor, monto, metodoPago);
    }

    public List<Pago> obtenerPagosPorReceptorYMonto(Usuario receptor, Double monto) {
        return pagoRepository.findByReceptorAndMonto(receptor, monto);
    }

    public List<Pago> obtenerPagosPorEmisorYReceptorYMonto(Usuario emisor, Usuario receptor, Double monto) {
        return pagoRepository.findByEmisorAndReceptorAndMonto(emisor, receptor, monto);
    }

    public List<Pago> obtenerPagosPorEmisorYReceptorYMetodoPago(Usuario emisor, Usuario receptor, MetodoDePago metodoPago) {
        return pagoRepository.findByEmisorAndReceptorAndMetodoPago(emisor, receptor, metodoPago);
    }

    public List<Pago> obtenerPagosPorEmisorYReceptorYMontoYMetodoPago(Usuario emisor, Usuario receptor, Double monto, MetodoDePago metodoPago) {
        return pagoRepository.findByEmisorAndReceptorAndMontoAndMetodoPago(emisor, receptor, monto, metodoPago);
    }

    public List<Pago> obtenerPagosPorEmisorYReceptorYMetodoPagoYMonto(Usuario emisor, Usuario receptor, MetodoDePago metodoPago, Double monto) {
        return pagoRepository.findByEmisorAndReceptorAndMetodoPagoAndMonto(emisor, receptor, metodoPago, monto);
    }

    public List<Pago> obtenerPagosPorEmisorYMetodoPagoYMonto(Usuario emisor, MetodoDePago metodoPago, Double monto) {
        return pagoRepository.findByEmisorAndMetodoPagoAndMonto(emisor, metodoPago, monto);
    }

    public List<Pago> obtenerPagosPorReceptorYMetodoPagoYMonto(Usuario receptor, MetodoDePago metodoPago, Double monto) {
        return pagoRepository.findByReceptorAndMetodoPagoAndMonto(receptor, metodoPago, monto);
    }


    @Transactional
    public void insertarDatos() {
        if (this.tablaPagosExistenteYVacia()) {
            // Inserta datos de ejemplo
            for (int i = 1; i <= 5; i++) {
                Pago pago = new Pago();
                pago.setEmisor(new Usuario("Emisor " + i, "emisor" + i + "@example.com", new Date(), new Random().nextInt(10000), "Dirección de ejemplo" + i + 1));
                pago.setReceptor(new Usuario("Receptor " + i, "receptor" + i + "@example.com", new Date(), new Random().nextInt(10000), "Dirección de ejemplo" + i + 2));
                pago.setMetodoPago(MetodoDePago.values()[new Random().nextInt(MetodoDePago.values().length)]); // Método de pago aleatorio
                pago.setMonto((double) (100 * i)); // Monto de ejemplo
                pagoRepository.save(pago);


            }
        }
    }

    private boolean tablaPagosExistenteYVacia() {
        // Verifica si la tabla "pagos" existe y está vacía
        try {
            Query query = entityManager.createNativeQuery("SELECT COUNT(*) FROM Pago");
            Long count = (Long) query.getSingleResult();
            return count == 0; // La tabla existe y está vacía
        } catch (Exception e) {
            return false; // La tabla no existe
        }
    }


}
