import Modelo.*;
import Persistence.PersistenciaParaTestear;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class ImplementadorTest {


    @Test
    public void verificarRegistroDeVentaCombustibleComunSINDescuento(){
        Implementador implementador =  new Implementador(new PersistenciaParaTestear());
        implementador.registrarUnaVenta(LocalDateTime.of(2021, 5,4,23,23),
                "20", new Comun());

        assertTrue(
                implementador.seRegistroVenta(
                        LocalDateTime.of(2021, 5,4,23,23),
                "20", new Comun()));

         }
    @Test
    public void verificarRegistroDeVentaCombustibleComunCONDescuento(){
        Implementador implementador =  new Implementador(new PersistenciaParaTestear());
        implementador.registrarUnaVenta(LocalDateTime.of(2021, 5,4,8,0),
                "20", new Comun());

        assertTrue(
                implementador.seRegistroVenta(LocalDateTime.of(2021, 5,4,8,0),
                        "20", new Comun()));
         }
    @Test
    public void verificarRegistroDeVentaCombustibleSuperSINDescuento(){
        Implementador implementador =  new Implementador(new PersistenciaParaTestear());
        implementador.registrarUnaVenta(LocalDateTime.of(2021, 5,4,23,23),
                "20", new Super());

        assertTrue(
                implementador.seRegistroVenta(LocalDateTime.of(2021, 5,4,23,23),
                        "20", new Super()));
         }
    @Test
    public void verificaeRegistroDeVentaCombustibleSuperCONDescuentoSABADO(){
        Implementador implementador =  new Implementador(new PersistenciaParaTestear());
        implementador.registrarUnaVenta(LocalDateTime.of(2021, 5,8,23,23),
                "20", new Super());

        assertTrue(
                implementador.seRegistroVenta(LocalDateTime.of(2021, 5,8,23,23),
                        "20", new Super()));

    }
    @Test
    public void verificarRegistroDeVentaCombustibleSuperCONDESCUENTODOMINGO(){
        Implementador implementador =  new Implementador(new PersistenciaParaTestear());
        implementador.registrarUnaVenta(LocalDateTime.of(2021, 5,9,23,23),
                "20", new Super());

        assertTrue(
                implementador.seRegistroVenta(LocalDateTime.of(2021, 5,9,23,23),
                        "20", new Super()));
    }








}
