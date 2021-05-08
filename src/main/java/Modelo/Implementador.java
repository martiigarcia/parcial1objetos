package Modelo;

import java.time.LocalDateTime;
import java.util.List;

public class Implementador {

    private final Persistencia persistencia;

    public Implementador (Persistencia persistencia){
        this.persistencia = persistencia;
    }

    public void registrarUnaVenta(LocalDateTime fecha, String litrosCargados, Combustible combustible){
        persistencia.cargarVenta(fecha, litrosCargados, combustible);
    }

    public boolean seRegistroVenta(LocalDateTime fecha, String litrosCargados, Combustible combustible){
        List<Venta> listaVentas = persistencia.obtenerListaVentas();
        return listaVentas.contains(new Venta(
                fecha, Double.parseDouble(litrosCargados),
                combustible.obtenerDescuentoPorFechaYLitros(Double.parseDouble(litrosCargados))));
    }

    public List<Venta> recuperarListaVentas(){
        return persistencia.obtenerListaVentas();
    }

    public List<Venta> recuperarListaVentasEntreFechas(String fecha_inicio, String fecha_fin){
        return persistencia.compararFechas(fecha_inicio, fecha_fin);
    }

    public double CalcularMontoTotal(double litros, Combustible combustible){
        return combustible.obtenerDescuentoPorFechaYLitros(litros);
    }

}
