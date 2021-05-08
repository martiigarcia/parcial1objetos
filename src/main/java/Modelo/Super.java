package Modelo;

import java.time.LocalDateTime;

public class Super implements Combustible {

    public final double precio = 90;

    @Override
    public double obtenerPrecio() {
        return precio;
    }

    @Override
    public double obtenerDescuentoPorFechaYLitros(double litro) {
        LocalDateTime diaCarga = LocalDateTime.now();
        double monto = litro * precio;

        if (diaCarga.getDayOfWeek().getValue() == 7)
            monto = hacerDescuento(monto, 10);
        if (diaCarga.getDayOfWeek().getValue() == 6 && 20 <= litro)
            monto = hacerDescuento(monto, 12);

        return monto;
    }

    public String toString(){
        return "Combustible Super";
    }

    private double hacerDescuento(double precioSinDescuento, int descuento) {
        return precioSinDescuento - (descuento * precioSinDescuento / 100);

    }

}
