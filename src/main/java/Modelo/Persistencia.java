package Modelo;

import Modelo.*;

import java.time.LocalDateTime;
import java.util.List;

public interface Persistencia {

    List<Venta> obtenerListaVentas ();

    void cargarVenta (LocalDateTime fecha, String litrosCargados, Combustible combustible);

    double calcularMonto(String litrosCargados, Combustible combustible);

    List<Venta> compararFechas(String fecha1, String fecha2);
}
