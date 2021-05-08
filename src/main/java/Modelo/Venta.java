package Modelo;

import java.time.LocalDateTime;

public class Venta {

    private final LocalDateTime fecha;
    private final double litrosCargados;
    private final double montoFacturado;

    public Venta(LocalDateTime fecha, double litrosCargados, double montoFacturado) {

        if (esDatoNulo(fecha) || esDatoVacio(fecha))
            throw new RuntimeException("La fecha no se ingreso correctamente.");
        if (esDatoVacio(litrosCargados))
            throw new RuntimeException("Laa cantidad de litros cragados no se ingreso correctamente.");
        if (esDatoVacio(montoFacturado))
            throw new RuntimeException("El monto facturado no se ingreso correctamente.");

        this.fecha = fecha;
        this.litrosCargados = litrosCargados;
        this.montoFacturado = montoFacturado;
    }

    private boolean esDatoVacio(Object dato) {
        return dato.equals("");
    }

    private boolean esDatoNulo(Object dato) {
        return dato == null;
    }

    public LocalDateTime fecha(){
        return this.fecha;
    }
    public double litrosCargados(){
        return this.litrosCargados;
    }
    public double MontoFacturado(){
        return this.montoFacturado;
    }

}
