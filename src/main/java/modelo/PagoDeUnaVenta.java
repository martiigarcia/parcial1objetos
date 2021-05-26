package modelo;

import java.time.LocalDateTime;

public class PagoDeUnaVenta extends Venta{

    private double monto;
    private final LocalDateTime fecha;

    public PagoDeUnaVenta(LocalDateTime fecha, String litrosCargados, Combustible combustible) {
        super(litrosCargados, combustible);
        if (esDatoNulo(fecha) || esDatoVacio(fecha))
            throw new RuntimeException("La fecha no se ingreso correctamente.");
        this.fecha = fecha;
    }

    public PagoDeUnaVenta(LocalDateTime fecha, double litrosCargados, Combustible combustible, double montoRecuperado) {
        super(litrosCargados, combustible);
        if (esDatoNulo(fecha) || esDatoVacio(fecha))
            throw new RuntimeException("La fecha no se ingreso correctamente.");
        this.fecha = fecha;

        if (esDatoNulo(montoRecuperado) || esDatoVacio(montoRecuperado))
            throw new RuntimeException("El monto no es valido.");
        this.monto = montoRecuperado;
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

    public double calcularMontoAbonado() {
        return (this.monto = super.calcularMonto(this.fecha));
    }



}
