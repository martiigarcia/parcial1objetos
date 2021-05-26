package modelo;

import java.time.LocalDateTime;
import java.util.List;

public class EstacionDeServicio {

    private final RegistroDeVentas registroDeVentas;

    public EstacionDeServicio(RegistroDeVentas registroDeVentas) {
        this.registroDeVentas = registroDeVentas;
    }

    public void agregarVenta(LocalDateTime fecha, String litrosCargados, Combustible combustible) {
        registroDeVentas.cargarVenta(new PagoDeUnaVenta(fecha, litrosCargados, combustible));
    }

    public double calcularMontoDeLaVenta(LocalDateTime fecha, String litrosCargados, Combustible combustible){
        return new PagoDeUnaVenta(fecha, litrosCargados, combustible).calcularMontoAbonado();
    }

    public List<PagoDeUnaVenta> recuperarListaDeVentasPagadasEntreFechas(String fecha1, String fecha2){
        if(fecha1 == null ||fecha1.isEmpty() || fecha2 == null || fecha2.isEmpty())
            throw new RuntimeException("Las fechas no fueron ingresadas correctamente.");
        return registroDeVentas.obtenerListaVentasPagadasEntreFechas(fecha1, fecha2);
    }

    public List<PagoDeUnaVenta> recuperarListaDeVentas(){
        return registroDeVentas.obtenerListaVentasPagadas();
    }

}
