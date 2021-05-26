package main;

import graficos.PantallaPrincipal;
import modelo.EstacionDeServicio;
import modelo.RegistroDeVentas;
import persistence.*;

public class PrimerMain {

    public static void main(String[] args) {

        RegistroDeVentas persistencia = new RegistroDeVentasBaseDeDatos();
        EstacionDeServicio estacionDeServicio = new EstacionDeServicio(persistencia);
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(estacionDeServicio);
        pantallaPrincipal.setVisible(true);
    }


}
