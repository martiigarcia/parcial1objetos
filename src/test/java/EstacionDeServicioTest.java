import modelo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import persistence.RegistroDeVentasParaTestear;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class EstacionDeServicioTest {

    private final RegistroDeVentasParaTestear registroDeVentas = new RegistroDeVentasParaTestear();
    private final String LITROS_CARGADOS = "20";
    private final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final double MONTO_ESPERADO_COMUN_SIN_DESCUENTO = 1400;
    private final double MONTO_ESPERADO_COMUN_CON_DESCUENTO = 1330;
    private final double MONTO_ESPERADO_SUPER_SIN_DESCUENTO = 1800;
    private final double MONTO_ESPERADO_SUPER_CON_DESCUENTO_SABADO = 1620;
    private final double MONTO_ESPERADO_SUPER_CON_DESCUENTO_DOMINGO = 1584;

    private EstacionDeServicio estacionDeServicio;
    private PagoDeUnaVenta venta1;


    @BeforeEach
    public void hacerSetUp() {
        venta1 = new PagoDeUnaVenta(LocalDateTime.of(2021, 5, 4, 23, 23),
                LITROS_CARGADOS, new Comun());

        estacionDeServicio = new EstacionDeServicio(registroDeVentas);
    }

    @Test
    public void verificarQueSeRegistroUnaVenta() {

        estacionDeServicio.agregarVenta(LocalDateTime.of(2021, 5, 4, 23, 23),
                LITROS_CARGADOS, new Comun());
        assertTrue(registroDeVentas.seRegistroLaVenta(venta1));
    }

    @Test
    public void verificarVentaRegistradaEntreFechas() {

        LocalDateTime fecha = LocalDateTime.now();
        String inicio = LocalDateTime.now().minusDays(1).format(FORMATO);
        String fin = LocalDateTime.now().plusDays(1).format(FORMATO);
        estacionDeServicio.agregarVenta(fecha, LITROS_CARGADOS, new Comun());

        assertFalse(
                estacionDeServicio.recuperarListaDeVentasPagadasEntreFechas(inicio, fin)
                        .isEmpty()
        );
    }

    //comun sin descuento
    @Test
    public void verificarVentaRegistradaComunSinDescuento() {

        assertEquals(
                MONTO_ESPERADO_COMUN_SIN_DESCUENTO,
                estacionDeServicio.calcularMontoDeLaVenta(LocalDateTime.of(2021, 5, 4, 23, 23),
                        LITROS_CARGADOS, new Comun())
        );
    }

    //comun con descuento
    @Test
    public void verificarVentaRegistradaComunConDescuento() {

        assertEquals(
                MONTO_ESPERADO_COMUN_CON_DESCUENTO,
                estacionDeServicio.calcularMontoDeLaVenta(LocalDateTime.of(2021, 5, 4, 8, 0),
                        LITROS_CARGADOS, new Comun())
        );
    }

    //super sin descuento
    @Test
    public void verificarVentaRegistradaSuperSinDescuento() {

        assertEquals(
                MONTO_ESPERADO_SUPER_SIN_DESCUENTO,
                estacionDeServicio.calcularMontoDeLaVenta(LocalDateTime.of(2021, 5, 4, 23, 23),
                        LITROS_CARGADOS, new Super())
        );
    }

    //super con descuento sabado+20Litros
    @Test
    public void verificarVentaRegistradaSuperConDescuentoSabadoY20Litros() {

        assertEquals(
                MONTO_ESPERADO_SUPER_CON_DESCUENTO_SABADO,
                estacionDeServicio.calcularMontoDeLaVenta(LocalDateTime.of(2021, 5, 8, 23, 23),
                        LITROS_CARGADOS, new Super())
        );
    }

    //super con descuento domingo
    @Test
    public void verificarVentaRegistradaSuperConDescuentoDomingo() {

        assertEquals(
                MONTO_ESPERADO_SUPER_CON_DESCUENTO_DOMINGO,
                estacionDeServicio.calcularMontoDeLaVenta(LocalDateTime.of(2021, 5, 9, 23, 23),
                        LITROS_CARGADOS, new Super())

        );
    }

}
