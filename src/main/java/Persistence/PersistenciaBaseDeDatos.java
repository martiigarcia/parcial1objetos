package Persistence;

import JDBC.*;
import Modelo.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaBaseDeDatos implements Persistencia {

    JDBCVenta ventaJDBC = new JDBCVenta();


    @Override
    public List<Venta> obtenerListaVentas() {
        return ventaJDBC.recuperarListaVentas();
    }

   public void cargarVenta(LocalDateTime fecha, String litrosCargados, Combustible combustible) {

        ventaJDBC.cargarVenta(
                new Venta(
                        fecha, Double.parseDouble(litrosCargados),
                        combustible.obtenerDescuentoPorFechaYLitros(Double.parseDouble(litrosCargados))));
    }

    public double calcularMonto(String litrosCargados, Combustible combustible){
        return combustible.obtenerDescuentoPorFechaYLitros(Double.parseDouble(litrosCargados));
    }

    public List<Venta> compararFechas(String fecha1, String fecha2){

        List<Venta>filtro= new ArrayList<>();
        List<Venta>ventas = ventaJDBC.recuperarListaVentas();

        LocalDate f1 = LocalDate.parse(fecha1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate f2 = LocalDate.parse(fecha2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        for(Venta ve : ventas){
            if((ve.fecha().toLocalDate().isAfter(f1) && ve.fecha().toLocalDate().isBefore(f2))
            ||ve.fecha().toLocalDate().equals(f1) || ve.fecha().toLocalDate().equals(f2))
                filtro.add(ve);

        }

        return filtro;
    }
}
