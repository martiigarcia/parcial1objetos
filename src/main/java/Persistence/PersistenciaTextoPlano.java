package Persistence;

import Modelo.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersistenciaTextoPlano implements Persistencia{

    private final File file;

    public PersistenciaTextoPlano(String path) {
        this.file = new File(path);
    }

    @Override
    public List<Venta> obtenerListaVentas() {

        List<Venta> ventas = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            for (String venta : reader.lines().collect(Collectors.toList())) {
                String[] partesDeLasVentas = venta.split(", ");
                Venta e = new Venta(
                        LocalDateTime.parse(partesDeLasVentas[0], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                            Double.parseDouble(partesDeLasVentas[1]),
                                    Double.parseDouble(partesDeLasVentas[2]));
                ventas.add(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error.", e);
        }
        return ventas;
    }

    @Override
    public void cargarVenta(LocalDateTime fecha, String litrosCargados, Combustible combustible) {
        try {

            double litros = Double.parseDouble(litrosCargados);
            Venta venta = new Venta(fecha, litros,
                    combustible.obtenerDescuentoPorFechaYLitros(litros));

            Writer writer = new FileWriter(file, true);
            writer.write(venta.fecha().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ", "
                    + venta.litrosCargados() + ", " + venta.MontoFacturado() + "\n");
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException("No pudo registrarse la venta.", e);
        }

    }

    @Override
    public double calcularMonto(String litrosCargados, Combustible combustible){
        return combustible.obtenerDescuentoPorFechaYLitros(Double.parseDouble(litrosCargados));
    }

    @Override
    public List<Venta> compararFechas(String fecha1, String fecha2) {
        List<Venta> ventas = new ArrayList<>();

        LocalDate f1 = LocalDate.parse(fecha1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate f2 = LocalDate.parse(fecha2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            for (String venta : reader.lines().collect(Collectors.toList())) {
                String[] partesDeLasVentas = venta.split(", ");
                Venta ve = new Venta(
                        LocalDateTime.parse(partesDeLasVentas[0], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                        Double.parseDouble(partesDeLasVentas[1]),
                        Double.parseDouble(partesDeLasVentas[2]));

                if((ve.fecha().toLocalDate().isAfter(f1) && ve.fecha().toLocalDate().isBefore(f2))
                        ||ve.fecha().toLocalDate().equals(f1) || ve.fecha().toLocalDate().equals(f2))
                    ventas.add(ve);


            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error.", e);
        }
        return ventas;
    }




}
