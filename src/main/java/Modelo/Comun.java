package Modelo;

import java.time.LocalDateTime;

public class Comun implements Combustible {

    public final double precio = 70;

    @Override
    public double obtenerPrecio() {
        return precio;
    }

    @Override
    public double obtenerDescuentoPorFechaYLitros(double litro) {
        LocalDateTime horarioCarga = LocalDateTime.now();
        double monto = litro * precio;

        if (8 <= horarioCarga.getHour() && horarioCarga.getHour() <= 10)
            monto = hacerDescuento(monto);

        return monto;
    }

    private double hacerDescuento(double precioSinDescuento) {
        return precioSinDescuento - (5 * precioSinDescuento / 100);

    }

    public String toString(){
        return "Combustible Comun";
    }
}
