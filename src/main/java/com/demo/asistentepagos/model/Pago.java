package com.demo.asistentepagos.model;


import jakarta.persistence.*;

@Entity(name = "Pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) // Guarda el valor del enum como String en la base de datos
    private MetodoDePago metodoPago;
    private Double monto;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "emisor_id")
    private Usuario emisor;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "receptor_id")
    private Usuario receptor;

    public Pago() {
    }


    public Pago(MetodoDePago metodoPago, Double monto, Usuario emisor, Usuario receptor) {
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.emisor = emisor;
        this.receptor = receptor;
    }


    // Getters y Setters

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public MetodoDePago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoDePago metodoPago) {
        this.metodoPago = metodoPago;
    }


    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }


    public Usuario getEmisor() {
        return emisor;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

    public Usuario getReceptor() {
        return receptor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
    }


}
