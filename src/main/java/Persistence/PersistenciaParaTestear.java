package Persistence;

import Modelo.Combustible;
import Modelo.Persistencia;
import Modelo.Venta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaParaTestear implements Persistencia {

    private final List<Venta> listaVentas = new ArrayList<>();

    @Override
    public List<Venta> obtenerListaVentas() {
        return listaVentas;
    }

    @Override
    public void cargarVenta(LocalDateTime fecha, String litrosCargados, Combustible combustible) {
        listaVentas.add(new Venta(fecha,
                Double.parseDouble(litrosCargados),
                combustible.obtenerDescuentoPorFechaYLitros(Double.parseDouble(litrosCargados))));
    }

    @Override
    public double calcularMonto(String litrosCargados, Combustible combustible) {
        return combustible.obtenerDescuentoPorFechaYLitros(Double.parseDouble(litrosCargados));
    }

    @Override
    public List<Venta> compararFechas(String fecha1, String fecha2) {

        List<Venta>filtro = new ArrayList<>();

        LocalDate f1 = LocalDate.parse(fecha1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate f2 = LocalDate.parse(fecha2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        for(Venta ve : listaVentas){
            if((ve.fecha().toLocalDate().isAfter(f1) && ve.fecha().toLocalDate().isBefore(f2))
                    ||ve.fecha().toLocalDate().equals(f1) || ve.fecha().toLocalDate().equals(f2))
                filtro.add(ve);

        }

        return filtro;
    }
    public boolean seRegistroLaVenta(Venta venta){
        return (listaVentas.contains(venta));
    }
}
