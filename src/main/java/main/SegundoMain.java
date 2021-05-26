package main;

import graficos.PantallaPrincipal;
import modelo.EstacionDeServicio;
import modelo.RegistroDeVentas;
import persistence.*;

public class SegundoMain {

    public static void main(String[] args) {

        RegistroDeVentas persistencia = new RegistroDeVentasTextoPlano("archivoTextoPlano.txt");
        EstacionDeServicio estacionDeServicio = new EstacionDeServicio(persistencia);
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(estacionDeServicio);
        pantallaPrincipal.setVisible(true);
    }
}
