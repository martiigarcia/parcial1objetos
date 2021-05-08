package Main;

import Graficos.PantallaPrincipal;
import Modelo.Implementador;
import Modelo.Persistencia;
import Persistence.*;

public class segundoMain {

    public static void main(String[] args) {

        Persistencia persistencia = new PersistenciaTextoPlano("archivoTextoPlano.txt");
        Implementador implementador = new Implementador(persistencia);
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(implementador);
        pantallaPrincipal.setVisible(true);
    }
}
