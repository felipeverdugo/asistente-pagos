package com.demo.asistentepagos.model;

public enum MetodoDePago {
    TARJETA_CREDITO("Tarjeta de Crédito"),
    TARJETA_DEBITO("Tarjeta de Débito"),
    TRANSFERENCIA_BANCARIA("Transferencia Bancaria"),
    PAYPAL("PayPal"),
    EFECTIVO("Efectivo");

    private final String nombre;

    MetodoDePago(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
